package com.gerenciamento.autores.controllers;

import com.gerenciamento.autores.models.AutorModel;
import com.gerenciamento.autores.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {

        @Autowired
        private AutorService autorService;

        @PostMapping
        public ResponseEntity<AutorModel> criar(@RequestBody AutorModel autor) {
            AutorModel salvo = autorService.save(autor);
            return ResponseEntity.status(201).body(salvo);
        }

        @GetMapping
        public ResponseEntity<List<AutorModel>> findAll() {
            return ResponseEntity.ok(autorService.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<AutorModel> findById(@PathVariable Long id) {
            return autorService.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletar(@PathVariable Long id) {
            autorService.delete(id);
            return ResponseEntity.noContent().build();
        }
}
