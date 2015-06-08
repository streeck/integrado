/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author charles
 */
public class SubDominio {
    private String descricao;
    private double valor;

    public String getFormattedValor () {
        String ret = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(this.valor);
        System.out.println(ret);
        return ret;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


}
