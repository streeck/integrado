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
public class Fonte {
    private String fonte;
    private double valor;
    private String tipoLicitacao;

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public double getValor() {
        return valor;
    }
    
    public String getFormattedValor() {
        String ret = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(this.valor);
        System.out.println(ret);
        return ret;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipoLicitacao() {
        return tipoLicitacao;
    }

    public void setTipoLicitacao(String tipoLicitacao) {
        this.tipoLicitacao = tipoLicitacao;
    }
    
    
}
