package com.proyecto.ed.service;

import com.proyecto.ed.model.Casa;
import com.proyecto.ed.repository.CasaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CasaService {
    @Autowired
    CasaRepository casaRepository;

    public List<Casa> list (){
        return casaRepository.findAll();
    }

    public Optional<Casa> getOne (int id){
        return casaRepository.findById(id);
    }

    public Optional<Casa> getByNombre (String name){
        return casaRepository.findByName(name);
    }
    public void save(Casa casa){casaRepository.save(casa); }

    public void delete(int id){casaRepository.deleteById(id);}

    public boolean existsById(int id){
        return casaRepository.existsById(id);
    }
    public boolean existsByName(String name){  return casaRepository.existsByName(name); }



}
