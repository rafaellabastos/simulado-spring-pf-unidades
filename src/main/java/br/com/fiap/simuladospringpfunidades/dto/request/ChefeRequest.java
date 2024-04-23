package br.com.fiap.simuladospringpfunidades.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record ChefeRequest (

        @NotNull(message = "Informe se o chefe é substituto ou não (True ou False)")
        Boolean substituto,

        @Valid
        @NotNull(message = "Informe o usuário")
        AbstractRequest usuario,

        @Valid
        @NotNull(message = "Informe a unidade")
        AbstractRequest unidade,

        @NotNull(message = "Informe a data de início do chefe")
        LocalDateTime inicio,

        LocalDateTime fim
){}