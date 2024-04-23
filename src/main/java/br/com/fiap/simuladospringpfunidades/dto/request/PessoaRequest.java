package br.com.fiap.simuladospringpfunidades.dto.request;

import br.com.fiap.simuladospringpfunidades.entity.Tipo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PessoaRequest (

        @Size(min = 2, max = 40)
        @NotNull(message = "Informe o nome")
        String nome,

        @Size(min = 2, max = 40)
        @NotNull(message = "Informe o sobrenome")
        String sobrenome,

        @Email(message = "E-mail inválido")
        @NotNull(message = "Informe o e-mail")
        String email,

        @PastOrPresent(message = "Data de nascimento inválida")
        @NotNull(message = "Informe a data de nascimento")
        LocalDate nascimento,

        @NotNull(message = "Informe o tipo da pessoa")
        Tipo tipo
){}