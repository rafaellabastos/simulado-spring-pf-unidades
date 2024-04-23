package br.com.fiap.simuladospringpfunidades.resource;

import br.com.fiap.simuladospringpfunidades.entity.Pessoa;
import br.com.fiap.simuladospringpfunidades.entity.Tipo;
import br.com.fiap.simuladospringpfunidades.entity.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource implements ResourceDTO<UsuarioRequest, UsuarioResponse> {

    @Autowired
    UsuarioService service;

    @GetMapping
    public ResponseEntity<Collection<UsuarioResponse>> findAll(
            @RequestParam(name = "pessoa.tipo", required = false) Tipo pessoaTipo,
            @RequestParam(name = "pessoa.name", required = false) String pessoaNome,
            @RequestParam(name = "pessoa.sobrenome", required = false) String pessoaSobrenome,
            @RequestParam(name = "pessoa.nascimento", required = false) LocalDate pessoaNascimento,
            @RequestParam(name = "pessoa.email", required = false) String pessoaEmail,
            @RequestParam(name = "username", required = false) String username
    )
    {
        var pessoa = Pessoa.builder()
                .nome(pessoaNome)
                .sobrenome(pessoaSobrenome)
                .nascimento(pessoaNascimento)
                .email(pessoaEmail)
                .tipo(pessoaTipo)
                .build();

        var usuario = Usuario.builder()
                .username(username)
                .pessoa(pessoa)
                .build();
    }

    public ResponseEntity<UsuarioResponse> save(@RequestBody @Valid UsuarioRequest r) {
        var entity = service.toEntity(r);
        var saved = service.save(entity);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }