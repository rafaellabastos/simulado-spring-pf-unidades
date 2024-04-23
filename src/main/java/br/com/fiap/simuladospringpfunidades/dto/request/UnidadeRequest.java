package br.com.fiap.simuladospringpfunidades.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UnidadeRequest (

        @Size(min = 2, max = 100)
        @NotNull(message = "Informe o nome")
        String nome,

        @Size(min = 2, max = 100)
        @NotNull(message = "Informe a sigla")
        String sigla,

        @Size(min = 10, max = 1500)
        @NotNull(message = "Informe a descrição")
        String descricao,

        @Valid
        AbstractRequest macro
){}
