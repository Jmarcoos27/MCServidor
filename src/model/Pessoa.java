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
public class Pessoa implements Serializable{

    private String nome;
    private String cnpj_cpf;
    private String rg_insc;
    private String rua;
    private int numeroEndereco;
    private String bairro;
    private String cidade;
    private String estado;
    private int cliente;
    private int fornecedor;
    private int transportador;

    /**
     * @return the cliente
     */
    public int getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the fornecedor
     */
    public int getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the transportador
     */
    public int getTransportador() {
        return transportador;
    }

    /**
     * @param transportador the transportador to set
     */
    public void setTransportador(int transportador) {
        this.transportador = transportador;
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
     * @return the cnpj_cpf
     */
    public String getCnpj_cpf() {
        return cnpj_cpf;
    }

    /**
     * @param cnpj_cpf the cnpj_cpf to set
     */
    public void setCnpj_cpf(String cnpj_cpf) {
        this.cnpj_cpf = cnpj_cpf;
    }

    /**
     * @return the rg_insc
     */
    public String getRg_insc() {
        return rg_insc;
    }

    /**
     * @param rg_insc the rg_insc to set
     */
    public void setRg_insc(String rg_insc) {
        this.rg_insc = rg_insc;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the numeroEndereco
     */
    public int getNumeroEndereco() {
        return numeroEndereco;
    }

    /**
     * @param numeroEndereco the numeroEndereco to set
     */
    public void setNumeroEndereco(int numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
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

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

}
