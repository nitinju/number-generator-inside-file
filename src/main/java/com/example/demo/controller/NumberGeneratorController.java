package com.example.demo.controller;

import com.example.demo.model.GenerateUUID;
import com.example.demo.service.NumberGeneratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@RestController
@Api(value = "/customer", description = "Customer Profile", produces = "application/json")
@RequestMapping("/numberGenerator")
@RequiredArgsConstructor
public class NumberGeneratorController {

    private final NumberGeneratorService numberGeneratorService;

    @PostMapping("/api/generate")
    @ApiOperation(value = "generate data")
    public ResponseEntity<?> generate(@RequestBody GenerateUUID generateUUID, HttpServletRequest httpServletRequest) {
        UUID uuid = numberGeneratorService.createUUID();
        try {
            return new ResponseEntity<>(numberGeneratorService.createFileAnd(generateUUID, uuid), HttpStatus.ACCEPTED);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/api/tasks/{id}/status")
    @ApiOperation(value = "Fetch status")
    public ResponseEntity<?> getStatus(@PathVariable("id") String id) throws IOException {
        return new ResponseEntity<>(numberGeneratorService.checkStatus(id), HttpStatus.OK);
    }

    @GetMapping("/api/tasks/{id}")
    @ApiOperation(value = "Get number list")
    public ResponseEntity<?> getNumberList(@PathVariable("id") String id, @RequestParam(value = "action", defaultValue = "get_numlist") String action) throws IOException {
        return new ResponseEntity<>(numberGeneratorService.readFile(id), HttpStatus.OK);
    }
}
