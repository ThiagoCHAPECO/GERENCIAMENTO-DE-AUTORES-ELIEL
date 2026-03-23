package com.gerenciamento.autores.services;

import com.gerenciamento.autores.models.AutorModel;
import com.gerenciamento.autores.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<AutorModel> findAll(){
        return autorRepository.findAll();
    }

    public Optional<AutorModel> findById(Long id){
        return autorRepository.findById(id);
    }

    public void delete(Long id){
        autorRepository.deleteById(id);
    }

    public AutorModel save(AutorModel pedidoModel){
        return autorRepository.save(pedidoModel);
    }
}
