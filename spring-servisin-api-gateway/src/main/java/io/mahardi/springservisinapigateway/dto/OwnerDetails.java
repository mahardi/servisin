package io.mahardi.springservisinapigateway.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import static java.util.stream.Collectors.toList;


@Data
public class OwnerDetails {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;
    private final List<CarDetails> cars = new ArrayList<>();
    
    @JsonIgnore
    public List<Integer> getCarIds(){
        return cars.stream()
            .map(CarDetails::getId)
            .collect(toList());
    }
}
