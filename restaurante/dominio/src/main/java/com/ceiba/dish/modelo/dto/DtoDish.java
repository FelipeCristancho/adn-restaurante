package com.ceiba.dish.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoDish {
    private Long dishId;
    private String dishName;
    private float price;
}
