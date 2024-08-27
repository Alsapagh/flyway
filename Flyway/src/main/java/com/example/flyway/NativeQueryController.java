package com.example.flyway;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class NativeQueryController {

    @Autowired
    private NativeQueryService nativeQueryService;

    @PostMapping("/query")
    public ResponseEntity<List<Map<String, Object>>> executeQuery(@RequestBody PostSql sql) {
        List<Map<String, Object>> results = nativeQueryService.executeNativeQuery(sql);
        return ResponseEntity.ok(results);
    }

    @PostMapping("/ddl")
    public String executeDDL(@RequestBody PostSql sql) {
        return nativeQueryService.executeDdlQuery(sql);

    }

    @PostMapping("/dml")
    public String executeDml(@RequestBody PostSql dml) {
        return nativeQueryService.executeDmlQuery(dml);

    }
}
