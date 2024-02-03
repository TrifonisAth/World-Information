package com.example.worldinfo.worldinfoservice.controllers;

import com.example.worldinfo.worldinfoservice.models.responses.actions.Action;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("api/versions")
@RestController
public class ApiDiscoveryController {

    @GetMapping
    public ResponseEntity<?> getApiVersions() {
        Map<String, Object> data = new HashMap<>();
        data.put("apiVersions", getVersions());
        data.put("menuAction", getMenuAction());
        return ResponseEntity.ok(data);
    }

    private List<ApiVersionInfo> getVersions() {
        return Collections.singletonList(
                new ApiVersionInfo("v1", "/api/v1")
        );
    }

    private Action getMenuAction() {
        return new Action(
                "GetMainMenu",
                "/menu",
                "GET",
                null
        );
    }

    static class ApiVersionInfo {
        private final String version;
        private final String url;

        public ApiVersionInfo(String version, String url) {
            this.version = version;
            this.url = url;
        }

        public String getVersion() {
            return version;
        }

        public String getUrl() {
            return url;
        }
    }
}