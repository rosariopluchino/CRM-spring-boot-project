package com.example.myCRM.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myCRM.dto.CreateClientModelDTO;
import com.example.myCRM.dto.ResponseClientModelDTO;
import com.example.myCRM.model.ClientModel;
import com.example.myCRM.repository.ClientRepository;

@Service
public class ClientService {
    
    private final ClientRepository repo;

    public ClientService(ClientRepository repo) {
        this.repo = repo;
    }

    public List<ResponseClientModelDTO> getAllClients() {
        List<ClientModel> listClientModel = repo.findAll();
        List<ResponseClientModelDTO> listClientDTO = new ArrayList<>();
        //mapping model -> dto
        listClientModel.forEach(element -> {
            ResponseClientModelDTO dto = new ResponseClientModelDTO();
            dto.setId(element.getId());
            dto.setName(element.getName());
            dto.setSurname(element.getSurname());
            dto.setEmail(element.getEmail());
            listClientDTO.add(dto);
        });
        return listClientDTO;
    }

    public ResponseClientModelDTO getClientById(Long id) {
        ClientModel client = repo.getClientById(id)
                                 .orElseThrow();
        ResponseClientModelDTO dto = new ResponseClientModelDTO();
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setSurname(client.getSurname());
        dto.setEmail(client.getEmail());
        return dto;  
    }

    public ResponseClientModelDTO createClient(CreateClientModelDTO client) {
        //DTO -> Model
        ClientModel persona = new ClientModel();
        persona.setEmail(client.getEmail());
        persona.setName(client.getName());
        persona.setSurname(client.getSurname());

        //salvataggio nel DB
        ClientModel saved = repo.save(persona);
        
        //Model -> DTO
        ResponseClientModelDTO response = new ResponseClientModelDTO();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setSurname(saved.getSurname());
        response.setEmail(saved.getEmail());
        return response;
    }

    public void deleteClient(Long id) {
        repo.deleteById(id);
    }
}
