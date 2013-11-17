/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

import java.sql.Date;

/**
 *
 * @author Karina
 */
public class AgendaVisita {
  //  private Date data;
    private String data;
    private String hora;
    private String nomeVisitante;
    private Integer numVisitante;

/*    public Date getData() {
    return data;
    }
    public void setData(Date data) {
    this.data = data;
    }*/
    
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNomeVisitante() {
        return nomeVisitante;
    }

    public void setNomeVisitante(String nomeVisitante) {
        this.nomeVisitante = nomeVisitante;
    }

    public Integer getNumVisitante() {
        return numVisitante;
    }

    public void setNumVisitante(Integer numVisitante) {
        this.numVisitante = numVisitante;
    }
    
    
    
}
