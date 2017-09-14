/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Ero
 */
public class Produto implements Serializable {

    private String descricao;
    private String unidade;
    private double valorEntrada;
    private double valorSaidaAvista;
    private double valorSaidaAPrazo;
    
    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the valorEntrada
     */
    public double getValorEntrada() {
        return valorEntrada;
    }

    /**
     * @param valorEntrada the valorEntrada to set
     */
    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    /**
     * @return the valorSaidaAvista
     */
    public double getValorSaidaAvista() {
        return valorSaidaAvista;
    }

    /**
     * @param valorSaidaAvista the valorSaidaAvista to set
     */
    public void setValorSaidaAvista(double valorSaidaAvista) {
        this.valorSaidaAvista = valorSaidaAvista;
    }

    /**
     * @return the valorSaidaAPrazo
     */
    public double getValorSaidaAPrazo() {
        return valorSaidaAPrazo;
    }

    /**
     * @param valorSaidaAPrazo the valorSaidaAPrazo to set
     */
    public void setValorSaidaAPrazo(double valorSaidaAPrazo) {
        this.valorSaidaAPrazo = valorSaidaAPrazo;
    }    
}
