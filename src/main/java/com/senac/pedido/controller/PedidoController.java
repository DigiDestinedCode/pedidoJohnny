package com.senac.pedido.controller;

import com.senac.pedido.dto.request.PedidoRequest;
import com.senac.pedido.dto.response.PedidoResponse;
import com.senac.pedido.model.Pedido;
import com.senac.pedido.repository.PedidoRepository;
import com.senac.pedido.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pedido") // Prefixo do endpoint
@CrossOrigin(origins="*")
public class PedidoController{

        private final PedidoService pedidoService;
        public PedidoController(PedidoService pedidoService, PedidoRepository pedidoRepository) {
            this.pedidoService = pedidoService;
        }

        @GetMapping("/{id}")
        @CrossOrigin(origins = "*")
        public ResponseEntity<PedidoResponse> visualizarPedidos(@PathVariable("id") Integer usuarioId) {
            PedidoResponse pedido = pedidoService.buscarPedidoPorUsuario(usuarioId);

            return ResponseEntity.ok(pedido);
        }

        @PostMapping("/criarpedido")
        public ResponseEntity<PedidoResponse> criarPedido(@RequestBody PedidoRequest pedidoRequest){
            return ResponseEntity.ok(pedidoService.criarPedido(pedidoRequest));
        }
}