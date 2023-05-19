package com.proyecto.ed.controller;


import com.proyecto.ed.dto.Mensaje;
import com.proyecto.ed.model.Casa;
import com.proyecto.ed.service.CasaService;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/casa")
@CrossOrigin(origins = "http://localhost:4200")
public class CasaController {
    @Autowired
    CasaService casaService;

    @GetMapping("/show")
    public ResponseEntity<List<Casa>> list(){
        List<Casa> list = casaService.list();
        return new ResponseEntity<List<Casa>>(list, HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<Casa> getById(int id){
        if(!casaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No se encontro la casa que busca"),HttpStatus.NOT_FOUND);
        }
        Casa casa = casaService.getOne(id).get();
        return new ResponseEntity(casa, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{name}")
    public ResponseEntity<Casa> getDetail(String name){
        if(!casaService.existsByName(name)){
            return new ResponseEntity(new Mensaje("No se encontro la casa que busca"),HttpStatus.NOT_FOUND);
        }
        Casa casa = casaService.getByNombre(name).get();
        return new ResponseEntity(casa, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Casa casa){
        //condicion para validadr lo haremos en angular
        if(StringUtils.isBlank(casa.getName())){
            return new ResponseEntity(new Mensaje("Nombre obligatorio"),HttpStatus.BAD_REQUEST);
        }
        //para saber que sea unico
        if(casaService.existsById(casa.getId())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        casaService.save(casa);
        return  new ResponseEntity(new Mensaje("Casa  creado"),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Casa casa,@PathVariable("id")int id){
        if(!casaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No se encontro la casa que busca"),HttpStatus.NOT_FOUND);
        }
        //METODO PARA CANCELAR QUE SE CREE UN PRODUCTO CON EL EMAIL DEL OTRO
//        if(casaService.existsByName(casa.getName()) && casaService.getByNombre(casa.getName()).get().getId() != id){
//            return new ResponseEntity("Ese nombre ya esxiste",HttpStatus.BAD_REQUEST);
//        }

        Casa newCasa =  casaService.getOne(id).get();
        newCasa.setName(casa.getName());
        newCasa.setTipoVenta(casa.getTipoVenta());
        newCasa.setCiudad(casa.getCiudad());
        newCasa.setPais(casa.getPais());
        newCasa.setImg(casa.getPais());
        newCasa.setVideo(casa.getVideo());
        newCasa.setEstrato(casa.getEstrato());
        newCasa.setPiso(casa.getPiso());
        newCasa.setHabitaciones(casa.getHabitaciones());
        newCasa.setArea(casa.getArea());
        newCasa.setParqueadero(casa.getParqueadero());
        newCasa.setBalcon(casa.getBalcon());
        newCasa.setAntiguedad(casa.getAntiguedad());
        casaService.save(newCasa);
        return  new ResponseEntity(new Mensaje("Casa Modificado"),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!casaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No se encontro la casa que busca"),HttpStatus.NOT_FOUND);
        }
        casaService.delete(id);
        return new ResponseEntity(new Mensaje("Casa Eliminado"),HttpStatus.OK);
    }





}
