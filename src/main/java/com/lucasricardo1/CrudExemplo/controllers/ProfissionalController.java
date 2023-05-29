package com.lucasricardo1.CrudExemplo.controllers;

import com.lucasricardo1.CrudExemplo.dtos.ProfissionalDTO;
import com.lucasricardo1.CrudExemplo.mappers.ContatoMapper;
import com.lucasricardo1.CrudExemplo.mappers.ProfissionalMapper;
import com.lucasricardo1.CrudExemplo.services.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @Autowired
    private ProfissionalMapper profissionalMapper;


    @GetMapping
    public ResponseEntity<List<ProfissionalDTO>> getProfissionais(@RequestParam String q) {
        return ResponseEntity.ok(ProfissionalMapper.INSTANCE.toDtos(profissionalService.buscarProfissional(q)));

    }

    @GetMapping("/{id}")
    public ProfissionalDTO getProfissionalById(@PathVariable Long id) {
        return ProfissionalMapper.INSTANCE.toDto(profissionalService.buscarProfissionalPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProfissionalDTO> createProfissional(@RequestBody ProfissionalDTO profissionalDTO) {

        return ResponseEntity.ok(
                ProfissionalMapper.INSTANCE.toDto(profissionalService.salvarProfissional(profissionalDTO)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalDTO> updateProfissional(@PathVariable Long id,
                                                     @RequestBody ProfissionalDTO profissionalDTO) {

        return ResponseEntity.ok(
                ProfissionalMapper.INSTANCE.toDto(profissionalService.atualizarProfissional(profissionalDTO)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfissional(@PathVariable Long id) {
        profissionalService.deletarProfissional(id);
        return ResponseEntity.ok("Profissional excluído com sucesso");
    }
}

