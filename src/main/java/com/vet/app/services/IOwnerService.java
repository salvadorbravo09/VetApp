package com.vet.app.services;

import com.vet.app.entities.Owner;

import java.util.List;
import java.util.Optional;

public interface IOwnerService {

    List<Owner> findAll();

    Optional<Owner> findByID(Long id);

    Owner save(Owner owner);

    void deleteById(Long id);
}
