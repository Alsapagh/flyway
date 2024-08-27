package com.example.flyway;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.*;

@Repository
public class NativeQueryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Map<String, Object>> executeNativeQuery(String sql) {
        List<Map<String, Object>> results = new ArrayList<>();
        entityManager.unwrap(Session.class).doWork(connection -> {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                SortedMap<String, Object> rowMap = new TreeMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    rowMap.put(columnName, resultSet.getObject(i));
                }
                results.add(rowMap);
            }
        });
        return results;
    }

    @Transactional
    public int executeDDLDMLQuery(String dml) {
        return entityManager.createNativeQuery(dml).executeUpdate();
    }
}

