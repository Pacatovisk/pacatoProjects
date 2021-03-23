package br.com.pacato.dtos;

import br.com.pacato.enums.Regulatorio;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

public class ProjetoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @Column(name = "PROJETO")
    @NotBlank(message = "O campo projeto não pode ser vazio!")
    private String nomeProjeto;

    @Column(name = "DEPARTAMENTO")
    @NotBlank(message = "O campo departamento não pode ser vazio!")
    private String departamento;

    @Column(name = "DATA_SOLICITAÇÃO")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate dataSolicitacao;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "REGULATÓRIO")
    private Regulatorio regulatorio;

    public ProjetoDto() {

    }

    public ProjetoDto(String nomeProjeto, String departamento, LocalDate dataSolicitacao, Regulatorio regulatorio) {
        this.nomeProjeto = nomeProjeto;
        this.departamento = departamento;
        this.dataSolicitacao = dataSolicitacao;
        this.regulatorio = regulatorio;
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
}


