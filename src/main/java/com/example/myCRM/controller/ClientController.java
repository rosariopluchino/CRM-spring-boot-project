package com.example.myCRM.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myCRM.dto.CreateClientModelDTO;
import com.example.myCRM.dto.ResponseClientModelDTO;
import com.example.myCRM.service.ClientService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/clients")
public class ClientController {
    
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ResponseClientModelDTO>> getAllClients() {
        List<ResponseClientModelDTO> clients = service.getAllClients();
        return ResponseEntity.ok(clients);
    }
    
    @PostMapping
    public ResponseEntity<ResponseClientModelDTO> createClient(@RequestBody CreateClientModelDTO dto) {
        ResponseClientModelDTO response = service.createClient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
