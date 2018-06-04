/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corrigirGabarito;

import Gabarito.Gabarito;
import aluno.Aluno;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author ALCIOMAR
 */
@Entity
public class CorrigirGabarito<T> {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Aluno aluno = new Aluno();

    @OneToOne
    private Gabarito gabarito = new Gabarito();

    @Transient
    private String[] resposta = new String[45];

    @Column(length = 5000)
    private String respostaJSON;

    private double notaFinal = 0;
    private int qtdAcertosMatematica = 0;
    private int qtdAcertosPortugues = 0;
    private int qtdAcertosBiologia = 0;
    private int qtdAcertosQuimica = 0;
    private int qtdAcertosFisica = 0;
    private int qtdAcertosHistoria = 0;
    private int qtdAcertosGeografia = 0;
    private int qtdAcertosLinguas = 0;
    private int qtdAcertosRedacao = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Gabarito getGabarito() {
        return gabarito;
    }

    public void setGabarito(Gabarito gabarito) {
        this.gabarito = gabarito;
    }

    public String[] getResposta() {
        return resposta;
    }

    public void setResposta(String[] resposta) {
        this.resposta = resposta;
    }

    public String getRespostaJSON() {
        return respostaJSON;
    }

    public void setRespostaJSON(String respostaJSON) {
        this.respostaJSON = respostaJSON;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public int getQtdAcertosMatematica() {
        return qtdAcertosMatematica;
    }

    public void setQtdAcertosMatematica(int qtdAcertosMatematica) {
        this.qtdAcertosMatematica = qtdAcertosMatematica;
    }

    public int getQtdAcertosPortugues() {
        return qtdAcertosPortugues;
    }

    public void setQtdAcertosPortugues(int qtdAcertosPortugues) {
        this.qtdAcertosPortugues = qtdAcertosPortugues;
    }

    public int getQtdAcertosBiologia() {
        return qtdAcertosBiologia;
    }

    public void setQtdAcertosBiologia(int qtdAcertosBiologia) {
        this.qtdAcertosBiologia = qtdAcertosBiologia;
    }

    public int getQtdAcertosQuimica() {
        return qtdAcertosQuimica;
    }

    public void setQtdAcertosQuimica(int qtdAcertosQuimica) {
        this.qtdAcertosQuimica = qtdAcertosQuimica;
    }

    public int getQtdAcertosFisica() {
        return qtdAcertosFisica;
    }

    public void setQtdAcertosFisica(int qtdAcertosFisica) {
        this.qtdAcertosFisica = qtdAcertosFisica;
    }

    public int getQtdAcertosHistoria() {
        return qtdAcertosHistoria;
    }

    public void setQtdAcertosHistoria(int qtdAcertosHistoria) {
        this.qtdAcertosHistoria = qtdAcertosHistoria;
    }

    public int getQtdAcertosGeografia() {
        return qtdAcertosGeografia;
    }

    public void setQtdAcertosGeografia(int qtdAcertosGeografia) {
        this.qtdAcertosGeografia = qtdAcertosGeografia;
    }

    public int getQtdAcertosLinguas() {
        return qtdAcertosLinguas;
    }

    public void setQtdAcertosLinguas(int qtdAcertosLinguas) {
        this.qtdAcertosLinguas = qtdAcertosLinguas;
    }

    public int getQtdAcertosRedacao() {
        return qtdAcertosRedacao;
    }

    public void setQtdAcertosRedacao(int qtdAcertosRedacao) {
        this.qtdAcertosRedacao = qtdAcertosRedacao;
    }

}
