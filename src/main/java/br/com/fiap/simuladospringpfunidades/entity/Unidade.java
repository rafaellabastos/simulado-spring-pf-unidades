package br.com.fiap.simuladospringpfunidades.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TB_UNIDADE", uniqueConstraints = {@UniqueConstraint(name = "UK_", columnNames = "")})

public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_UNIDADE")
    @SequenceGenerator(name = "SQ_UNIDADE", sequenceName = "SQ_UNIDADE", allocationSize = 1)
    @Column(name = "ID_UNIDADE")
    private Long id;

    @Column(name = "NM_UNIDADE")
    private String nome;

    @Column(name = "SIG_UNIDADE")
    private String sigla;

    @Column(name = "DESC_UNIDADE")
    private String descricao;

    private Unidade macro;
}
