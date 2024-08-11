package com.vet.app.controllers;

import com.vet.app.entities.Owner;
import com.vet.app.services.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    @Autowired
    private IOwnerService ownerService;

    @GetMapping("/find")
    public ResponseEntity<List<Owner>> findAll() {
        List<Owner> owners = ownerService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(owners);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Owner> findById(@PathVariable Long id) {
        Optional<Owner> optionalOwner = ownerService.findByID(id);
        if (optionalOwner.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalOwner.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/create")
    public ResponseEntity<Owner> create(@RequestBody Owner owner) {
        Owner saveOwner = ownerService.save(owner);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveOwner);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Owner> delete(@PathVariable Long id) {
        Optional<Owner> ownerOptional = ownerService.findByID(id);
        if (ownerOptional.isPresent()) {
            ownerService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
