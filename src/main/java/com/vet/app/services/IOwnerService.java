package com.vet.app.services;

import com.vet.app.entities.Owner;

import java.util.List;
import java.util.Optional;

public interface IOwnerService {

    List<Owner> getAllOwners();

    Optional<Owner> getOwnerById(Long id);

    Owner saveOwner(Owner owner);

    void deleteOwner(Long id);
}
