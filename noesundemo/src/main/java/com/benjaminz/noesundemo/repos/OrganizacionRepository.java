package com.benjaminz.noesundemo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.benjaminz.noesundemo.domain.Organizacion;

import java.util.UUID;

public interface OrganizacionRepository extends JpaRepository<Organizacion, UUID> {
    // add custom queries here
}
