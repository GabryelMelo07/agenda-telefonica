package com.tbd.agenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.tbd.agenda.dto.ContatoDTO;
import com.tbd.agenda.model.Contato;
import com.tbd.agenda.repository.ContatoRepository;
import com.tbd.agenda.service.interfaces.ContatoService;

@Service
public class ContatoServiceImpl implements ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Contato> getAll() {
        return contatoRepository.findAll();
    }

    @Override
    public Contato getById(int id) {
        return contatoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Contato não existe"));
    }

    @Override
    public Contato save(ContatoDTO dto) {
        Contato contato = new Contato(sequenceGeneratorService.generateSequence(Contato.SEQUENCE_NAME), dto.nome(),
        dto.telefones(), dto.endereco());
        return contatoRepository.save(contato);
    }

    @Override
    public Contato update(int id, ContatoDTO dto) {
        Contato contato = getById(id);
        contato.setNome(dto.nome());
        contato.setTelefones(dto.telefones());
        contato.setEndereco(dto.endereco());
        return contatoRepository.save(contato);
    }

    @Override
    public boolean delete(int id) {
        if(contatoRepository.existsById(id)) {
            contatoRepository.deleteById(id);
            return true;
        }
        throw new NotFoundException("Contato não encontrado ou não existe");
    }

    @Override
    public List<Contato> findByEnderecoCidade(String cidade) {
        List<Contato> contatos = contatoRepository.findByEnderecoCidade(cidade);
        return contatos;
    }

    @Override
    public List<Contato> getContatosComMaisDeUmTelefone() {
        List<Contato> contatos = contatoRepository.getContatosComMaisDeUmTelefone();
        return contatos;
    }

}
