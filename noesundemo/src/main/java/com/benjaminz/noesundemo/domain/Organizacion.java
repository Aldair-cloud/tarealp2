package com.benjaminz.noesundemo.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Organizacion {

    @Id
    @Column(nullable = false, updatable = false)
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator =  "uuid")
    private UUID idorganizacion;

    @Column
    private LocalDate fechaInicio;

    @Column
    private LocalDate fechaFin;

    @Column
    private String referenciaDireccion;

    @Column
    private String nomOrganizacion;

    @Column(length = 1)
    private String estado;

    @Column(nullable = false, updatable = false)
    protected OffsetDateTime dateCreated;
    /*fecha de creacion*/

    @Column(nullable = false)
    protected OffsetDateTime lastUpdated;
    /*fecha de actualizacion*/
    @PrePersist
    public void prePersist() {
        dateCreated = OffsetDateTime.now();
        lastUpdated = dateCreated;
    }

    @PreUpdate
    public void preUpdate() {
        lastUpdated = OffsetDateTime.now();
    }

    public UUID getIdorganizacion() {
        return idorganizacion;/*generar id*/
    }

    public void setIdorganizacion(final UUID idorganizacion) {
        this.idorganizacion = idorganizacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(final LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(final LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getReferenciaDireccion() {
        return referenciaDireccion;
    }

    public void setReferenciaDireccion(final String referenciaDireccion) {
        this.referenciaDireccion = referenciaDireccion;
    }

    public String getNomOrganizacion() {
        return nomOrganizacion;
    }

    public void setNomOrganizacion(final String nomOrganizacion) {
        this.nomOrganizacion = nomOrganizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(final String estado) {
        this.estado = estado;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

}
