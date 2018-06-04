/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aluno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author ALCIOMAR
 */
@Entity
public class Aluno {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, length = 150)
    private String nome;
    private String email;
    private String telefone;
    private String cidade;
    private String primeiraOpcaoDeCurso;
    private String segundaOpcaoDeCurso;
    

    //  @OneToOne
    // private corrigirGabarito.CorrigirGabarito corrigirGabarito;
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the endereço
     */
    /**
     * @return the primeiraOpcaoDeCurso
     */
    public String getPrimeiraOpcaoDeCurso() {
        return primeiraOpcaoDeCurso;
    }

    /**
     * @param primeiraOpcaoDeCurso the primeiraOpcaoDeCurso to set
     */
    public void setPrimeiraOpcaoDeCurso(String primeiraOpcaoDeCurso) {
        this.primeiraOpcaoDeCurso = primeiraOpcaoDeCurso;
    }

    /**
     * @return the segundaOpcaoDeCurso
     */
    public String getSegundaOpcaoDeCurso() {
        return segundaOpcaoDeCurso;
    }

    /**
     * @param segundaOpcaoDeCurso the segundaOpcaoDeCurso to set
     */
    public void setSegundaOpcaoDeCurso(String segundaOpcaoDeCurso) {
        this.segundaOpcaoDeCurso = segundaOpcaoDeCurso;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }



}
