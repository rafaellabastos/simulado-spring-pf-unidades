package br.com.fiap.simuladospringpfunidades.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Tipo {

    PF( 1L, "Pessoa Física", "PF" ), PJ( 2L, "Pessoa Jurídica", "PJ" );

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO")
    @SequenceGenerator(name = "SQ_TIPO", sequenceName = "SQ_TIPO", allocationSize = 1)
    @Column(name = "ID_TIPO")
    private Long id;

    @Column(name = "NM_TIPO")
    private String nome;

    @Column(name = "SIG_TIPO")
    private String sigla;

    @Override
    public String toString() {
        return String.valueOf( sigla );
    }
}
