package com.ceiba.client.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoClient {
    private Long id;
    private Long dni;
    private String name;
    private String last_name;
    private String telephone;
}
