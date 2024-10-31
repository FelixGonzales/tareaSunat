package com.codigo.ruc_registros.service.impl;

import com.codigo.ruc_registros.aggregates.constants.Constants;
import com.codigo.ruc_registros.aggregates.response.ResponseSunat;
import com.codigo.ruc_registros.client.ClientSunat;
import com.codigo.ruc_registros.entity.PersonaJuridicaEntity;
import com.codigo.ruc_registros.repository.PersonaJuridicaRepository;
import com.codigo.ruc_registros.service.PersonaJuridicaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Objects;

@Service
public class PersonaJuridicaServiceImpl  implements PersonaJuridicaService {

    private final PersonaJuridicaRepository personaJuridicaRepository;
    private final ClientSunat clientSunat;

    @Value("${token.api}")
    private String token;

    public PersonaJuridicaServiceImpl(PersonaJuridicaRepository personaJuridicaRepository, ClientSunat clientSunat) {
        this.personaJuridicaRepository = personaJuridicaRepository;
        this.clientSunat = clientSunat;
    }


    @Override
    public PersonaJuridicaEntity guardar(String ruc) {
        PersonaJuridicaEntity personaJuridica = getEntity(ruc);
        if(Objects.nonNull(personaJuridica)){
            return personaJuridicaRepository.save(personaJuridica);
        }else{
            return null;
        }

    }

    private PersonaJuridicaEntity getEntity(String ruc){
        PersonaJuridicaEntity personaJuridicaEntity = new PersonaJuridicaEntity();
        ResponseSunat datosSunat = executionSunat(ruc);
        if(Objects.nonNull(datosSunat)){
            personaJuridicaEntity.setRazonSocial(datosSunat.getRazonSocial());
            personaJuridicaEntity.setTipoDocumento(datosSunat.getTipoDocumento());
            personaJuridicaEntity.setNumeroDocumento(datosSunat.getNumeroDocumento());
            personaJuridicaEntity.setEstado(datosSunat.getEstado());
            personaJuridicaEntity.setCondicion(datosSunat.getCondicion());
            personaJuridicaEntity.setDireccion(datosSunat.getDireccion());
            personaJuridicaEntity.setUbigeo(datosSunat.getUbigeo());
            personaJuridicaEntity.setViaTipo(datosSunat.getViaTipo());
            personaJuridicaEntity.setViaNombre(datosSunat.getViaNombre());
            personaJuridicaEntity.setZonaCodigo(datosSunat.getZonaCodigo());
            personaJuridicaEntity.setZonaTipo(datosSunat.getZonaTipo());
            personaJuridicaEntity.setNumero(datosSunat.getNumero());
            personaJuridicaEntity.setInterior(datosSunat.getInterior());
            personaJuridicaEntity.setLote(datosSunat.getLote());
            personaJuridicaEntity.setDpto(datosSunat.getDpto());
            personaJuridicaEntity.setManzana(datosSunat.getManzana());
            personaJuridicaEntity.setKilometro(datosSunat.getKilometro());
            personaJuridicaEntity.setDistrito(datosSunat.getDistrito());
            personaJuridicaEntity.setProvincia(datosSunat.getProvincia());
            personaJuridicaEntity.setDepartamento(datosSunat.getDepartamento());
            personaJuridicaEntity.setTipo(datosSunat.getTipo());
            personaJuridicaEntity.setActividadEconomica(datosSunat.getActividadEconomica());
            personaJuridicaEntity.setNumeroTrabajadores(datosSunat.getNumeroTrabajadores());
            personaJuridicaEntity.setTipoFacturacion(datosSunat.getTipoFacturacion());
            personaJuridicaEntity.setTipoContabilidad(datosSunat.getTipoContabilidad());
            personaJuridicaEntity.setComercioExterior(datosSunat.getComercioExterior());
            personaJuridicaEntity.setUserCreated(Constants.USER_CREATED);
            personaJuridicaEntity.setDateCreated(new Timestamp(System.currentTimeMillis()));
            personaJuridicaEntity.setUserUpdate(Constants.USER_CREATED);
            personaJuridicaEntity.setDateUpdate(new Timestamp(System.currentTimeMillis()));
            personaJuridicaEntity.setEstadoPersona(Constants.ESTADO_ACTIVO);
        }
        return personaJuridicaEntity;
    }

    private ResponseSunat executionSunat(String ruc){
        String tokenOk = Constants.BEARER + token;
        return clientSunat.getPersonaSunat(ruc, tokenOk);
    }
}
