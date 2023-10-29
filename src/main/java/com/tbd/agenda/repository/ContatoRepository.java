package com.tbd.agenda.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tbd.agenda.model.Contato;

public interface ContatoRepository extends MongoRepository<Contato, Integer> {

    List<Contato> findByEnderecoCidade(String cidade);
    
    @Query("{telefones: { $exists: true, $ne: null }, $where: 'this.telefones.length > 1' }")
    List<Contato> getContatosComMaisDeUmTelefone();

}
