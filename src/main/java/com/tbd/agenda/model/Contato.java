package com.tbd.agenda.model;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "contato")
public class Contato {
    
    @Id
    private UUID id;
    
    private String nome;

    private List<String> telefones;

    private Endereco endereco;
    
}
