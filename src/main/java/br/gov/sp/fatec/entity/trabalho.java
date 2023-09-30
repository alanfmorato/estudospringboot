package br.gov.sp.fatec.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tra_trabalho")
public class trabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define o id como auto_increment
    @Column(name = "tra_id")
    private Long id;

    @Column(name = "tra_titulo", unique = true)
    private String titulo;

    @Column(name = "tra_data_hora_entrega")
    private LocalDateTime data_hora_entrega;

    @Column(name = "tra_descricao")
    private String descricao;

    @Column(name = "tra_grupo")
    private String grupo;

    @Column(name = "tra_nota")
    private int nota;
    
    @Column(name = "tra_justificativa")
    private String justificativa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getData_hora_entrega() {
        return data_hora_entrega;
    }

    public void setData_hora_entrega(LocalDateTime data_hora_entrega) {
        this.data_hora_entrega = data_hora_entrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    
}
