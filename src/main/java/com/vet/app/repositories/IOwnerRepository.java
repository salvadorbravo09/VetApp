package com.vet.app.repositories;

import com.vet.app.entities.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOwnerRepository extends CrudRepository<Owner, Long> {
}
