package io.mahardi.springservisinapigateway.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CarDetails {
    private int id;
    private String name;
    private String licensePlate;
    private String year;
    private CarType type;
    private final List<VisitDetails> visits = new ArrayList<>();
}
