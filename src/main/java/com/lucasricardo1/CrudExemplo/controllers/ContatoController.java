package com.lucasricardo1.CrudExemplo.controllers;

import com.lucasricardo1.CrudExemplo.dtos.ContatoDTO;
import com.lucasricardo1.CrudExemplo.mappers.ContatoMapper;
import com.lucasricardo1.CrudExemplo.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @Autowired
    private ContatoMapper contatoMapper;


    @GetMapping
    public ResponseEntity<List<ContatoDTO>> getContatos(@RequestParam String q) {
        return ResponseEntity.ok(ContatoMapper.INSTANCE.toDtos(contatoService.buscarContatos(q)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoDTO> getContatoById(@PathVariable Long id) {
        return ResponseEntity.ok(ContatoMapper.INSTANCE.toDto(contatoService.buscarContatoPorId(    id)));
    }

    @PostMapping
    public ResponseEntity<ContatoDTO> createContato(@RequestBody ContatoDTO contatoDTO) {
        return ResponseEntity.ok(ContatoMapper.INSTANCE.toDto(contatoService.salvarContato(contatoDTO)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoDTO> updateContato(@RequestBody ContatoDTO contatoDTO) {

        return ResponseEntity.ok(ContatoMapper.INSTANCE.toDto(contatoService.atualizarContato(contatoDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContato(@PathVariable Long id) {
        contatoService.deletarContato(id);
        return ResponseEntity.ok("Contato excluído com sucesso");
    }
}
