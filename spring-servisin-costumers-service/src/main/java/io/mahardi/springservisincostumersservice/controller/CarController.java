package io.mahardi.springservisincostumersservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import io.mahardi.springservisincostumersservice.helper.CarDetails;
import io.mahardi.springservisincostumersservice.helper.CarRequest;
import io.mahardi.springservisincostumersservice.helper.ResourceNotFoundException;
import io.mahardi.springservisincostumersservice.model.CarType;
import io.mahardi.springservisincostumersservice.model.Cars;
import io.mahardi.springservisincostumersservice.model.Owner;
import io.mahardi.springservisincostumersservice.repository.CarRepository;
import io.mahardi.springservisincostumersservice.repository.OwnerRepository;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Timed("servisin.car")
@RequiredArgsConstructor
@Slf4j
public class CarController {
    @Autowired CarRepository carRepository;
    @Autowired OwnerRepository ownerRepository;


    @GetMapping("/carTypes")
    public List<CarType> getCarTypes() {
        return carRepository.findCarType();
    }

    @PostMapping("/owners/{ownerId}/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public Cars processCreationForm(
        @RequestBody CarRequest carRequest,
        @PathVariable("ownerId") @Min(1) int ownerId) {

        final Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
        Owner owner = optionalOwner.orElseThrow(() -> new ResourceNotFoundException("Owner "+ownerId+" not found"));

        final Cars car = new Cars();
        owner.addCar(car);
        return save(car, carRequest);
    }

    @PutMapping("/owners/*/cars/{carId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void processUpdateForm(@RequestBody CarRequest carRequest) {
        int carId = carRequest.getId();
        Cars car = findCarById(carId);
        save(car, carRequest);
    }

    private Cars save(final Cars car, final CarRequest carRequest) {

        car.setName(carRequest.getName());
        car.setDateOfPurchase(carRequest.getDateOfPurchase());
        car.setLicensePlate(carRequest.getLicensePlate());

        carRepository.findCarTypeById(carRequest.getTypeId())
            .ifPresent(car::setType);

        log.info("Saving car {}", car);
        return carRepository.save(car);
    }

    @GetMapping("owners/*/cars/{carId}")
    public CarDetails findCar(@PathVariable("carId") int carId) {
        return new CarDetails(findCarById(carId));
    }


    private Cars findCarById(int carId) {
        Optional<Cars> car = carRepository.findById(carId);
        if (!car.isPresent()) {
            throw new ResourceNotFoundException("Cars with id "+carId+" not found");
        }
        return car.get();
    }

}
