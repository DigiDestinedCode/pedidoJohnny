package com.senac.pedido.service;

import com.senac.pedido.dto.request.PedidoRequest;
import com.senac.pedido.dto.response.PedidoResponse;
import com.senac.pedido.model.Pedido;
import com.senac.pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoResponse criarPedido(PedidoRequest pedidoRequest) {

        Pedido pedidoSalvo = new Pedido();

        pedidoSalvo.setData(pedidoRequest.getData());
        pedidoSalvo.setValor_total(pedidoRequest.getValor_total());
        pedidoSalvo.setUsuarioId(pedidoRequest.getUsuarioId());
        pedidoSalvo.setStatus(pedidoRequest.getStatus());

        Pedido pedidoTemp = pedidoRepository.save(pedidoSalvo);
        PedidoResponse pedidoResponse = new PedidoResponse();

        pedidoResponse.setData(pedidoTemp.getData());
        pedidoResponse.setValor_total(pedidoTemp.getValor_total());
        pedidoResponse.setUsuarioId(pedidoTemp.getUsuarioId());
        pedidoResponse.setStatus(pedidoTemp.getStatus());

        return pedidoResponse;
    }

    public Pedido listaPorUsuarioId(Integer usuarioId) {
        return pedidoRepository.buscaPedidoPorUsuario(usuarioId).orElse(null);
    }
}
