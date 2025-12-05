package com.example.myCRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myCRM.model.ClientModel;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {
}
