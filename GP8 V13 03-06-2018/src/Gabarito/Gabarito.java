/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gabarito;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author ALCIOMAR
 */
@Entity
public class Gabarito<T> {

    @Id
    @GeneratedValue
    private int id;

    private String nomeGabarito;

    @Column(length = 5000)
    private String respostaJSON;

    @Transient
    private String[] resposta = new String[45];

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
     * @return the nomeGabarito
     */
    public String getNomeGabarito() {
        return nomeGabarito;
    }

    /**
     * @param nomeGabarito the nomeGabarito to set
     */
    public void setNomeGabarito(String nomeGabarito) {
        this.nomeGabarito = nomeGabarito;
    }

    /**
     * @return the respostaJSON
     */
    public String getRespostaJSON() {
        return respostaJSON;
    }

    /**
     * @param respostaJSON the respostaJSON to set
     */
    public void setRespostaJSON(String respostaJSON) {
        this.respostaJSON = respostaJSON;
    }

    /**
     * @return the resposta
     */
    public String[] getResposta() {
        return resposta;
    }

    /**
     * @param resposta the resposta to set
     */
    public void setResposta(String[] resposta) {
        this.resposta = resposta;
    }

}
