package br.com.fiap.challenge.diner.adapter.driver.request;

import br.com.fiap.challenge.diner.core.domain.entities.Cliente;
import br.com.fiap.challenge.diner.core.domain.entities.Empresa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CadastrarPedidoRequest {

    @Hidden
    @JsonIgnore
    @Builder.Default
    private LocalDateTime data = LocalDateTime.now();

    private Long empresaId;
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private String status;
}
