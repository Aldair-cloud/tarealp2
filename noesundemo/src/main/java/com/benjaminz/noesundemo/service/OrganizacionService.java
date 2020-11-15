package com.benjaminz.noesundemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benjaminz.noesundemo.config.CustomNotFoundException;
import com.benjaminz.noesundemo.domain.Organizacion;
import com.benjaminz.noesundemo.model.OrganizacionDTO;
import com.benjaminz.noesundemo.repos.OrganizacionRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;


@Service
public class OrganizacionService {

    private final OrganizacionRepository organizacionRepository;

    @Autowired
    public OrganizacionService(final OrganizacionRepository organizacionRepository) {
        this.organizacionRepository = organizacionRepository;
    }

    public List<OrganizacionDTO> findAll() {
        return organizacionRepository.findAll()
                .stream()
                .map(organizacion -> mapToDTO(organizacion, new OrganizacionDTO()))
                .collect(Collectors.toList());
    }

    public OrganizacionDTO get(final UUID idorganizacion) {
        return organizacionRepository.findById(idorganizacion)
                .map(organizacion -> mapToDTO(organizacion, new OrganizacionDTO()))
                .orElseThrow(CustomNotFoundException::new);
    }

    public UUID create(final OrganizacionDTO organizacionDTO) {
        final Organizacion organizacion = new Organizacion();
        mapToEntity(organizacionDTO, organizacion);
        return organizacionRepository.save(organizacion).getIdorganizacion();
    }

    public void update(final UUID idorganizacion, final OrganizacionDTO organizacionDTO) {
        final Organizacion organizacion = organizacionRepository.findById(idorganizacion)
                .orElseThrow(CustomNotFoundException::new);
        mapToEntity(organizacionDTO, organizacion);
        organizacionRepository.save(organizacion);
    }

    public void delete(final UUID idorganizacion) {
        organizacionRepository.deleteById(idorganizacion);
    }

    private OrganizacionDTO mapToDTO(final Organizacion organizacion, final OrganizacionDTO organizacionDTO) {
        organizacionDTO.setIdorganizacion(organizacion.getIdorganizacion());
        organizacionDTO.setFechaInicio(organizacion.getFechaInicio());
        organizacionDTO.setFechaFin(organizacion.getFechaFin());
        organizacionDTO.setReferenciaDireccion(organizacion.getReferenciaDireccion());
        organizacionDTO.setNomOrganizacion(organizacion.getNomOrganizacion());
        organizacionDTO.setEstado(organizacion.getEstado());
        return organizacionDTO;
    }

    private Organizacion mapToEntity(final OrganizacionDTO organizacionDTO, final Organizacion organizacion) {
        organizacion.setFechaInicio(organizacionDTO.getFechaInicio());
        organizacion.setFechaFin(organizacionDTO.getFechaFin());
        organizacion.setReferenciaDireccion(organizacionDTO.getReferenciaDireccion());
        organizacion.setNomOrganizacion(organizacionDTO.getNomOrganizacion());
        organizacion.setEstado(organizacionDTO.getEstado());
        return organizacion;
    }

}
