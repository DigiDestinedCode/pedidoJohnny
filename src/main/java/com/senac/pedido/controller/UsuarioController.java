package com.senac.pedido.controller;

import com.senac.pedido.dto.request.UsuarioRequest;
import com.senac.pedido.dto.response.UsuarioResponse;
import com.senac.pedido.model.Pedido;
import com.senac.pedido.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/usuario") // Prefixo do endpoint
@CrossOrigin("*")
public class UsuarioController {

    private final PedidoService pedidoService;

    public UsuarioController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // Define o caminho específico: /{usuario}/json/
    // O Feign constrói a URL final e faz a chamada HTTP GET.

    @GetMapping("/{usuario}/json/")
    public ResponseEntity<Pedido> listarPedido(@PathVariable("id") Integer usuarioId){
        return ResponseEntity.ok(pedidoService.listaPorUsuarioId(usuarioId));
    }

    @PostMapping("/{usuario}/json/")
    public ResponseEntity<UsuarioResponse> cadastroUsuario(@PathVariable("usuario") String usuario, @RequestBody UsuarioRequest UsuarioRequest){
        return null;
    }
}