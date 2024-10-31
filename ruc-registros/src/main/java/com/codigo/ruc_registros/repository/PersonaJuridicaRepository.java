package com.codigo.ruc_registros.repository;

import com.codigo.ruc_registros.entity.PersonaJuridicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaJuridicaRepository extends JpaRepository<PersonaJuridicaEntity, Long> {
}
