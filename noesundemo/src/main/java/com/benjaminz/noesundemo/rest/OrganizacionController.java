package com.benjaminz.noesundemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.benjaminz.noesundemo.model.OrganizacionDTO;
import com.benjaminz.noesundemo.service.OrganizacionService;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping(value = "/api/organizacions", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizacionController {

    private final OrganizacionService organizacionService;

    @Autowired
    public OrganizacionController(final OrganizacionService organizacionService) {
        this.organizacionService = organizacionService;
    }

    @GetMapping
    public List<OrganizacionDTO> getAllOrganizacions() {
        return organizacionService.findAll();
    }

    @GetMapping("/{idorganizacion}")
    public OrganizacionDTO getOrganizacion(@PathVariable final UUID idorganizacion) {
        return organizacionService.get(idorganizacion);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID createOrganizacion(@RequestBody @Valid final OrganizacionDTO organizacionDTO) {
        return organizacionService.create(organizacionDTO);
    }

    @PutMapping("/{idorganizacion}")
    public void updateOrganizacion(@PathVariable final UUID idorganizacion, @RequestBody @Valid final OrganizacionDTO organizacionDTO) {
        organizacionService.update(idorganizacion, organizacionDTO);
    }

    @DeleteMapping("/{idorganizacion}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganizacion(@PathVariable final UUID idorganizacion) {
        organizacionService.delete(idorganizacion);
    }

}
