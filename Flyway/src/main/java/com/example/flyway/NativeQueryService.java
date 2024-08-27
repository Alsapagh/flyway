package com.example.flyway;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NativeQueryService {

    @Autowired
    private NativeQueryRepository nativeQueryRepository;

    public List<Map<String, Object>> executeNativeQuery(PostSql sql) {
        return nativeQueryRepository.executeNativeQuery(sql.getSql());
    }

    public String executeDmlQuery(PostSql dml) {
        try {
            int i = nativeQueryRepository.executeDDLDMLQuery(dml.getSql());
            return i + " rows affected";
        } catch (Exception e) {
            e.printStackTrace();
            return "dml executed failed\n " + e.getMessage();
        }
    }

    public String executeDdlQuery(PostSql ddl) {
        try {
            int i = nativeQueryRepository.executeDDLDMLQuery(ddl.getSql());
            return "ddl executed successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "ddl executed failed\n " + e.getMessage();
        }
    }
}
