package com.vet.app.services.impl;

import com.vet.app.entities.Owner;
import com.vet.app.repositories.IOwnerRepository;
import com.vet.app.services.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OwnerServiceImpl implements IOwnerService {

    @Autowired
    private IOwnerRepository ownerRepository;

    @Override
    public List<Owner> getAllOwners() {
        return (List<Owner>) ownerRepository.findAll();
    }

    @Override
    public Optional<Owner> getOwnerById(Long id) {
        return ownerRepository.findById(id);
    }

    @Override
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }
}
