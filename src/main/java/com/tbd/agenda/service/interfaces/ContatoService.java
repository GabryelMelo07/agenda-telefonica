package com.tbd.agenda.service.interfaces;

import java.util.List;

import com.tbd.agenda.dto.ContatoDTO;
import com.tbd.agenda.model.Contato;

public interface ContatoService extends CrudService<Contato, ContatoDTO> {
    List<Contato> findByEnderecoCidade(String cidade);
    List<Contato> getContatosComMaisDeUmTelefone();
}
