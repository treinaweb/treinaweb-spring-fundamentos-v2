package br.com.treinaweb.twprojects.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.twprojects.core.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
