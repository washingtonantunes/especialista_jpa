package br.com.wti.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Length;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Washington Antunes for wTI on 12/07/2023
 */

@Getter
@Setter
@Entity
@Table(name = "produto",
        uniqueConstraints = {@UniqueConstraint(name = "unq_nome", columnNames = { "nome" })},
        indexes = { @Index(name = "idx_nome", columnList = "nome" )})
public class Produto extends EntidadeBaseInteger {

    @Column(name = "data_criacao", updatable = false, nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_ultima_atualizacao", insertable = false)
    private LocalDateTime dataUltimaAtualizacao;

    @Column(length = 100, nullable = false)
    private String nome;

    @Lob
    @Column(length = Length.LONG32)
    private String descricao;

    private BigDecimal preco;

    @Lob
    @Column(length = 1000)
    private byte[] foto;

    @ManyToMany
    @JoinTable(name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id",
                    foreignKey = @ForeignKey(name = "fk_produto_categoria_produto")),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"),
                    foreignKey = @ForeignKey(name = "fk_produto_categoria_categoria"))
    private List<Categoria> categorias;

    @OneToOne(mappedBy = "produto")
    private Estoque estoque;

    @ElementCollection
    @CollectionTable(name = "produto_tag",
            joinColumns = @JoinColumn(name = "produto_id"),
            foreignKey = @ForeignKey(name = "fk_produto_tag_produto"))
    @Column(name = "tag", length = 50, nullable = false)
    private List<String> tags;

    @ElementCollection
    @CollectionTable(name = "produto_atributo",
            joinColumns = @JoinColumn(name = "produto_id"),
            foreignKey = @ForeignKey(name = "fk_produto_atributo_produto"))
    private List<Atributo> atributos;
}
