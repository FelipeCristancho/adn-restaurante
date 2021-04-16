package com.ceiba.configuracion;

import com.ceiba.client.puerto.repositorio.RepositorioClient;
import com.ceiba.client.servicio.ServicioCrearClient;
import com.ceiba.dish.puerto.repositorio.RepositorioDish;
import com.ceiba.sale.puerto.repositorio.RepositorioSale;
import com.ceiba.sale.servicio.ServicioCrearSale;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearSale servicioCrearSale(RepositorioSale repositorioSale, RepositorioDish repositorioDish, RepositorioClient repositorioClient){
        return new ServicioCrearSale(repositorioSale, repositorioDish, repositorioClient);
    }

    @Bean
    public ServicioCrearClient servicioCrearClient(RepositorioClient repositorioClient){
        return new ServicioCrearClient(repositorioClient);
    }

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
	

}
