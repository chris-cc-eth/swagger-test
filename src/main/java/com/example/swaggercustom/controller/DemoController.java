package com.example.swaggercustom.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Demo", description = "Demo API for Swagger UI customization")
public class DemoController {

    @Operation(summary = "Get demo data", description = "Retrieves sample data to demonstrate Swagger documentation", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @GetMapping("/demo")
    public ResponseEntity<Map<String, Object>> getDemo() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Hello from Swagger UI Custom Demo!");
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create demo data", description = "Creates a new demo entity", responses = {
            @ApiResponse(responseCode = "201", description = "Successfully created", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PostMapping("/demo")
    public ResponseEntity<Map<String, Object>> createDemo(@RequestBody Map<String, Object> payload) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Demo created successfully");
        response.put("data", payload);
        return ResponseEntity.status(201).body(response);
    }
}
