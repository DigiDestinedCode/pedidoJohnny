package com.senac.pedido.repository;

import com.senac.pedido.dto.response.PedidoResponse;
import com.senac.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query("SELECT p from Pedido p where p.usuarioId= :usuarioId")
    Optional<PedidoResponse> buscaPedidoPorUsuario(Integer usuarioId);
}
