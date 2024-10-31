package com.codigo.ruc_registros.controller;

import com.codigo.ruc_registros.entity.PersonaJuridicaEntity;
import com.codigo.ruc_registros.service.PersonaJuridicaService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/personajuridica")
public class PersonaJuridicaController {

    private final PersonaJuridicaService personaJuridicaService;

    public PersonaJuridicaController(PersonaJuridicaService personaJuridicaService) {
        this.personaJuridicaService = personaJuridicaService;
    }
    @PostMapping
    public ResponseEntity<PersonaJuridicaEntity> guardarPersona(@RequestParam("ruc") String ruc){
        PersonaJuridicaEntity personaJuridica = personaJuridicaService.guardar(ruc);
        return new ResponseEntity<>(personaJuridica, HttpStatus.CREATED);
    }
}
