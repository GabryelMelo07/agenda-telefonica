package com.tbd.agenda.dto;

import java.util.List;

import com.tbd.agenda.model.Endereco;

public record ContatoDTO(String nome, List<String> telefones, Endereco endereco) {
}
