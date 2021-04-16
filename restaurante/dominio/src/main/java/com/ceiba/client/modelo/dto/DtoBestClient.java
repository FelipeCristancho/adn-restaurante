package com.ceiba.client.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoBestClient {

    private Long id;
    private Long dni;
    private String name;
    private String last_name;
    private String telephone;
    private int totalPurchases;
}
