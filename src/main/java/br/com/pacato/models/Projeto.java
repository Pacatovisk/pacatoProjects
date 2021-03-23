package br.com.pacato.models;

import br.com.pacato.enums.Regulatorio;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "PROJETOS")
public class Projeto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PROJETO")
    @NotBlank(message = "O campo projeto não pode ser vazio!")
    private String nomeProjeto;

    @Column(name = "DEPARTAMENTO")
    @NotBlank(message = "O campo departamento não pode ser vazio!")
    private String departamento;

    @Column(name = "DATA_SOLICITAÇÃO")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private LocalDate dataSolicitacao;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "REGULATÓRIO")
    private Regulatorio regulatorio;

    @Column(name = "ANALISE_SITUAÇÃO_ATUAL")
    @NotBlank(message = "O campo análise está vazio!")
    private String analiseSituacaoAtual;

    @Column(name = "DESCRIÇÃO_SITUAÇÃO_DESEJADA")
    @NotBlank(message = "O campo situação está vazio!")
    private String descricaoSituacaoDesejada;

    @Column(name = "DECRIÇÃO_DA_SOLUÇÃO")
    @NotBlank(message = "O campo descrição está vazio!")
    private String descricaoSolucao;

    public Projeto() {

    }

    public Projeto(Long id, String nomeProjeto, String departamento, LocalDate dataSolicitacao, Regulatorio regulatorio, String analiseSituacaoAtual, String descricaoSituacaoDesejada, String descricaoSolucao) {
        this.id = id;
        this.nomeProjeto = nomeProjeto;
        this.departamento = departamento;
        this.dataSolicitacao = dataSolicitacao;
        this.regulatorio = regulatorio;
        this.analiseSituacaoAtual = analiseSituacaoAtual;
        this.descricaoSituacaoDesejada = descricaoSituacaoDesejada;
        this.descricaoSolucao = descricaoSolucao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Regulatorio getRegulatorio() {
        return regulatorio;
    }

    public void setRegulatorio(Regulatorio regulatorio) {
        this.regulatorio = regulatorio;
    }

    public String getAnaliseSituacaoAtual() {
        return analiseSituacaoAtual;
    }

    public void setAnaliseSituacaoAtual(String analiseSituacaoAtual) {
        this.analiseSituacaoAtual = analiseSituacaoAtual;
    }

    public String getDescricaoSituacaoDesejada() {
        return descricaoSituacaoDesejada;
    }

    public void setDescricaoSituacaoDesejada(String descricaoSituacaoDesejada) {
        this.descricaoSituacaoDesejada = descricaoSituacaoDesejada;
    }

    public String getDescricaoSolucao() {
        return descricaoSolucao;
    }

    public void setDescricaoSolucao(String descricaoSolucao) {
        this.descricaoSolucao = descricaoSolucao;
    }
}
