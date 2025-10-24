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
@RequestMapping("/api/v1/loja") // Prefixo do endpoint
public class PedidoController{


        private final PedidoService pedidoService;

        private final PedidoRepository pedidoRepository;

        // Injeção de Dependência via Construtor
        public PedidoController(PedidoService pedidoService, PedidoRepository pedidoRepository) {
            this.pedidoService = pedidoService;
            this.pedidoRepository = pedidoRepository;
        }

        // Endpoint: GET /api/v1/pedido/{loja}
        @GetMapping("/{loja}")
        public Pedido buscarPedido(@PathVariable Integer loja) {

            // Chama o Feign Usuario para fazer a requisição externa
            Optional<Pedido> pedido = pedidoRepository.buscaPedidoPorUsuario(loja);

            // Tratamento simples para PEDIDO não encontrado (ViaPEDIDO retorna campos nulos)
            if (!pedido.isEmpty() && pedido.getId() == null) {
                // Lança uma exceção para o Spring tratar como erro (Geralmente HTTP 500)
                throw new RuntimeException("PEDIDO não encontrado ou inválido: " + pedido);
            }

            return pedido;
        }

        @PostMapping("/criarpedido")
        public ResponseEntity<PedidoResponse> criarPedido(@RequestBody PedidoRequest pedidoRequest){
            return ResponseEntity.ok(pedidoService.criarPedido(pedidoRequest));
        }
}