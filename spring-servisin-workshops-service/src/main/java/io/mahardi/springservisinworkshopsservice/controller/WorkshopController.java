package io.mahardi.springservisinworkshopsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mahardi.springservisinworkshopsservice.model.Workshop;
import io.mahardi.springservisinworkshopsservice.repository.WorkshopRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/workshops")
@RequiredArgsConstructor
public class WorkshopController {
    @Autowired WorkshopRepository workshopRepository;

    @GetMapping
    public List<Workshop> getWorkshopList(){
        return workshopRepository.findAll();
    }
}
