package br.edu.ifba.sistema_moveleiro.entidade;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_produto", nullable = false)
    private Integer codigoProduto;

    @Column(name = "nome_produto", nullable = false)
    private String nomeProduto;

    @Column(name = "descricao_produto", nullable = false, length = 1000)
    private String descricaoProduto;

    @Column(name = "cor_produto", nullable = false)
    private String corProduto;

    @Column(name = "preco_produto", nullable = false)
    private Double precoProduto;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Column(name = "atualizadoEm")
    private LocalDateTime atualizado_em = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getCorProduto() {
        return corProduto;
    }

    public void setCorProduto(String corProduto) {
        this.corProduto = corProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizado_em() {
        return atualizado_em;
    }

    public void setAtualizado_em(LocalDateTime atualizado_em) {
        this.atualizado_em = atualizado_em;
    }
}