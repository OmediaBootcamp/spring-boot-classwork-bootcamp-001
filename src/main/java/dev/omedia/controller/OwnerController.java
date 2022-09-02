package dev.omedia.controller;


import dev.omedia.domain.LegalEntity;
import dev.omedia.domain.Owner;
import dev.omedia.model.OwnerModel;
import dev.omedia.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("Owners")
//TODO add descriptions
//TODO add logs
//TODO add exceptions
public class OwnerController {

    private final OwnerService service;

    @Autowired
    public OwnerController(OwnerService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<? extends Owner> getOwners() {
        return service.getAll();
    }

    // fixme
    @PostMapping("OwnerModel")
    public OwnerModel geOwnerModel(@RequestBody @Valid OwnerModel ownerModel) {
        return ownerModel;
    }

    // fixme
    @GetMapping("{id}")
    public Owner getOwnerById(@PathVariable long id) {
        return service.getById(id).orElseThrow(RuntimeException::new);
    }


    @PutMapping("{id}")
    public Owner update(@PathVariable long id, @RequestBody Owner owner) {
        owner.setId(id);
        return service.update(owner);
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Owner create(@RequestBody Owner owner) {
//        return service.create(owner);
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Owner create() {
        Owner owner = new LegalEntity(0, null, "123456789", "IT");
        return service.create(owner);
    }


}
