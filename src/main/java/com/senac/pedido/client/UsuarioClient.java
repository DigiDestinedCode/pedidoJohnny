package com.senac.pedido.client;

import com.senac.pedido.dto.response.PedidoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//Renan
//@FeignClient(name = "Usuario", url = "10.234.248.64:8080", path= "/api/usuario")
//Gustavo
@FeignClient(name = "Usuario", url = "10.136.36.217:8080", path= "/api/usuario")
public interface UsuarioClient {
    @GetMapping(value = "/pedidos/{id}")
    public ResponseEntity<PedidoResponse> buscarPorUsuario(@PathVariable("usuario") String usuario);


}