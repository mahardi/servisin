package io.mahardi.springservisincustomersservice.helper;

import java.util.Date;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CarRequest {
    private int id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfPurchase;

    @Size(min = 1)
    private String name;

    private String licensePlate;

    private int typeId;
}
