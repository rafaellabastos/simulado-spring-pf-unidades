package br.com.fiap.simuladospringpfunidades.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequest (

        @Email(message = "Username inválido")
        @NotNull(message = "Informe o username")
        String username,

        @NotNull(message = "Informe a senha")
        String password,

        @Valid
        @NotNull(message = "Informe o tipo da pessoa")
        PessoaRequest pessoa
){}
