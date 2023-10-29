package com.tbd.agenda.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "contato")
@AllArgsConstructor
public class Contato {
    
    @Transient
    public static final String SEQUENCE_NAME = "contato_sequence";
    
    @Id
    private Integer id;
    
    private String nome;

    private List<String> telefones;

    private Endereco endereco;
    
}
