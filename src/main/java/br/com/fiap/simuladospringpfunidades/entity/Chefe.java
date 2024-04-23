package br.com.fiap.simuladospringpfunidades.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TB_CHEFE", uniqueConstraints = {@UniqueConstraint(name = "UK_CHEFE_USUARIO_UNIDADE_FIM", columnNames = {"ID_USUARIO", "ID_UNIDADE", "FIM"})
})

public class Chefe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CHEFE")
    @SequenceGenerator(name = "SQ_CHEFE", sequenceName = "SQ_CHEFE", allocationSize = 1)
    @Column(name = "ID_CHEFE")
    private Long id;

    @Column(name = "SUBS_CHEFE")
    private Boolean substituto;

    @Column(name = "INIC_CHEFE")
    private LocalDateTime inicio;

    @Column(name = "FIM_CHEFE")
    private LocalDateTime fim;

    private Usuario usuario;

    private Unidade unidade;
}
