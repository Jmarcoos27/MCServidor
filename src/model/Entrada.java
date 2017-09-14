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
public class Entrada extends Movimentacao implements Serializable {

    /**
     * @return the cliente
     */
    public Pessoa getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }
    private Pessoa cliente;
}
