package com.ceiba.sale.comando.fabrica;

import com.ceiba.sale.comando.ComandoSale;
import com.ceiba.sale.modelo.entidad.Sale;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FabricaSale {

    public Sale crear(ComandoSale comandoSale){
        return new Sale(
          comandoSale.getId(),
          LocalDate.now(),
          comandoSale.getDish(),
          comandoSale.getClient(),
          comandoSale.getPromotion()
        );
    }
}
