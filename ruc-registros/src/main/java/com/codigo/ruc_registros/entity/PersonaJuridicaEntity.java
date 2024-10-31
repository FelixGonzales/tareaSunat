package com.codigo.ruc_registros.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Entity
@Table(name = "PersonaJuridica")
@Getter
@Setter
public class PersonaJuridicaEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String razonSocial;
        private String tipoDocumento;
        private String numeroDocumento;
        private String estado;
        private String condicion;
        private String direccion;
        private String ubigeo;
        private String viaTipo;
        private String viaNombre;
        private String zonaCodigo;
        private String zonaTipo;
        private String numero;
        private String interior;
        private String lote;
        private String dpto;
        private String manzana;
        private String kilometro;
        private String distrito;
        private String provincia;
        private String departamento;
        private String tipo;
        private String actividadEconomica;
        private String numeroTrabajadores;
        private String tipoFacturacion;
        private String tipoContabilidad;
        private String comercioExterior;
        private int estadoPersona;
        private String userCreated;
        private Timestamp dateCreated;
        private String userUpdate;
        private Timestamp dateUpdate;



}
