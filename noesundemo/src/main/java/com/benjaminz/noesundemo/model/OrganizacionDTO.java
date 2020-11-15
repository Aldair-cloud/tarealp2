package com.benjaminz.noesundemo.model;

import java.time.LocalDate;
import java.util.UUID;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;


public class OrganizacionDTO {

    private UUID idorganizacion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaInicio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaFin;

    @Size(max = 255)
    private String referenciaDireccion;

    @Size(max = 255)
    private String nomOrganizacion;

    @Size(max = 1)
    private String estado;

    public UUID getIdorganizacion() {
        return idorganizacion;
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

}
