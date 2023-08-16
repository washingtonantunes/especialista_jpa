package br.com.wti.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Washington Antunes for wTI on 12/07/2023
 */

@Getter
@Setter
@Entity
@Table(name = "categoria",
        uniqueConstraints = { @UniqueConstraint(name = "unq_nome", columnNames = { "nome" })})
public class Categoria extends EntidadeBaseInteger {

    @Column(length = 100, nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "categoria_pai_id", foreignKey = @ForeignKey(name = "fk_categoria_categoriapai"))
    private Categoria categoriaPai;

    @OneToMany(mappedBy = "categoriaPai")
    private List<Categoria> categorias;

    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos;
}
