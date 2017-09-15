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
public class ItemEntrada extends ItemMovimenta implements Serializable {
    private int entrada;
    /**
     * @return the entrada
     */
    public int getCodEntrada() {
        return entrada;
    }

    /**
     * @param entrada the entrada to set
     */
    public void setCodEntrada(int entrada) {
        this.entrada = entrada;
    }
}
