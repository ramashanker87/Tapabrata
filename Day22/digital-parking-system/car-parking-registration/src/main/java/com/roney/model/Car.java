package com.roney.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String ownerName;
    private String regNo;
    private String model;
    private String type;
}
