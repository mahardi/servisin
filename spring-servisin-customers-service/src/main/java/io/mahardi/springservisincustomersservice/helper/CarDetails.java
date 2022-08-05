package io.mahardi.springservisincustomersservice.helper;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import io.mahardi.springservisincustomersservice.model.CarType;
import io.mahardi.springservisincustomersservice.model.Cars;
import lombok.Data;

@Data
public class CarDetails {

    private long id;

    private String name;

    private String owner;

    private String licensePlate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfPurchase;

    private CarType type;

    public CarDetails(Cars car) {
        this.id = car.getId();
        this.name = car.getName();
        this.owner = car.getOwner().getFirstName() + " " + car.getOwner().getLastName();
        this.dateOfPurchase = car.getDateOfPurchase();
        this.type = car.getType();
    }
}