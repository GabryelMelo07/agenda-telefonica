package com.tbd.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tbd.agenda.dto.ContatoDTO;
import com.tbd.agenda.model.Contato;
import com.tbd.agenda.service.interfaces.ContatoService;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    
    @Autowired
    private ContatoService contatoService;
    
    @GetMapping
    public ResponseEntity<List<Contato>> getAll() {
        List<Contato> contatos = contatoService.getAll();
        return ResponseEntity.ok().body(contatos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Contato> getById(@PathVariable int id) {
        Contato contato = contatoService.getById(id);
        return ResponseEntity.ok().body(contato);
    }

    @PostMapping
    public ResponseEntity<Contato> save(@RequestBody ContatoDTO contatoDto) {
        Contato aluno = contatoService.save(contatoDto);
        return ResponseEntity.ok().body(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> update(@PathVariable int id, @RequestBody ContatoDTO alunoDto) {
        Contato aluno = contatoService.update(id, alunoDto);
        return ResponseEntity.ok().body(aluno);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        boolean deletado = contatoService.delete(id);        
        if (deletado) {
            return new ResponseEntity<Boolean>(deletado, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(deletado, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<Contato>> getByCidade(@PathVariable String cidade) {
        List<Contato> contatos = contatoService.findByEnderecoCidade(cidade);
        return ResponseEntity.ok().body(contatos);
    }

    @GetMapping("/get/mais_de_um_telefone")
    public ResponseEntity<List<Contato>> getContatosComMaisDeUmTelefone() {
        List<Contato> contatos = contatoService.getContatosComMaisDeUmTelefone();
        return ResponseEntity.ok().body(contatos);
    }
}
