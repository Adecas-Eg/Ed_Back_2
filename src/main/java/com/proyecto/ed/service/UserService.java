package com.proyecto.ed.service;

import com.proyecto.ed.model.Casa;
import com.proyecto.ed.model.User;
import com.proyecto.ed.repository.CasaRepository;
import com.proyecto.ed.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> list (){
        return userRepository.findAll();
    }

    public Optional<User> getOne (int id){
        return userRepository.findById(id);
    }

    public Optional<User> getByEmail (String email){
        return userRepository.findByEmail(email);
    }
    public void save(User user){userRepository.save(user); }

    public void delete(int id){userRepository.deleteById(id);}

    public boolean existsById(int id){
        return userRepository.existsById(id);
    }
    public boolean existsByEmail(String email){  return userRepository.existsByEmail(email); }
}
