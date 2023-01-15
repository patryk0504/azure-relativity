package com.example.relativity.controller;

import com.example.relativity.service.AzureFunctionClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class DashboardController {

    private final AzureFunctionClient azureFunctionClient;

    @GetMapping("/error")
    public String getError() {
        throw new RuntimeException("error triggered");
    }

    @GetMapping("/function")
    @ResponseBody
    public String getFunction() {
        Map<String, String> request = Map.of("name", "function from spring app");
        log.info("trigger function");
        var response = azureFunctionClient.callFunction(request);
        log.info(response.toString());
        return response.toString();
    }

    @GetMapping("/dashboard")
    public String getDashboard() {
        return "dashboard";
    }

    @GetMapping("Admin")
    @ResponseBody
    @PreAuthorize("hasAuthority('APPROLE_Admin')")
    public String Admin() {
        return "Admin message";
    }
}