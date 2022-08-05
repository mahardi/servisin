package io.mahardi.springservisincustomersservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.mahardi.springservisincustomersservice.helper.ResourceNotFoundException;
import io.mahardi.springservisincustomersservice.model.Owner;
import io.mahardi.springservisincustomersservice.repository.OwnerRepository;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/owners")
@RestController
@Timed("servisin.owner")
@RequiredArgsConstructor
@Slf4j
public class OwnerController {

    @Autowired OwnerRepository ownerRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Owner createOwner(@Valid @RequestBody Owner owner){
        return ownerRepository.save(owner);
    }

    @GetMapping("/{ownerId}")
    public Optional<Owner> findOWner(@PathVariable("ownerId") @Min(1) int ownerId){
        return ownerRepository.findById(ownerId);
    }

    @GetMapping
    public List<Owner> findAll(){
        return ownerRepository.findAll();
    }

    @PutMapping("/{ownerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOwner(@PathVariable("ownerId") @Min(1) int ownerId, @Valid @RequestBody Owner ownerRequest){
        final Optional<Owner> owner = ownerRepository.findById(ownerId);
        final Owner ownerModel = owner.orElseThrow(() -> new ResourceNotFoundException("Owner "+ownerId+" not found"));

        ownerModel.setFirstName(ownerRequest.getFirstName());
        ownerModel.setLastName(ownerRequest.getLastName());
        ownerModel.setCity(ownerRequest.getCity());
        ownerModel.setAddress(ownerRequest.getAddress());
        ownerModel.setTelephone(ownerRequest.getTelephone());
        log.info("Saving owner {}", ownerModel);
        ownerRepository.save(ownerModel);
    }
    
}
