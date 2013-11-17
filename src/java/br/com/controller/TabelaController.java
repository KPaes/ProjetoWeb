/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.bean.TabeladePreco;
import br.com.dao.TabeladePrecoDao;
import br.com.exception.DaoException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author Karina
 */
@ManagedBean(name="tabelaController")
@SessionScoped

public class TabelaController implements Serializable {

 private static final long serialVersionUID = -333995781063775201L;

 private TabeladePreco tabela = new TabeladePreco();
 private DataModel<TabeladePreco> proteses;
 private TabeladePrecoDao tabelaDAO;
 private String tipo;

 public TabelaController(){
    if(this.tabela == null){
        this.tabela = new TabeladePreco();
    }
 }

 public List<SelectItem> getTabelas() throws DaoException{
    TabeladePrecoDao pessoaService = new TabeladePrecoDao();

    List<TabeladePreco> tabelas = pessoaService.consultarProtesesTipo();
    
    List<SelectItem> itens = new ArrayList<SelectItem>(tabelas.size());

    for(TabeladePreco p : tabelas){
        itens.add(new SelectItem(p.getTipoProtese())); //p.getNumProtese(), 
    }  

 return itens;
 }

 //Mostra o nome e preço \/
 public TabeladePreco getTabela() {
 return tabela;
 }

 public void setTabela(TabeladePreco tabela) {
 this.tabela = tabela;
 }
 
 public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tabela.getTipoProtese();
    }
    
 public List<TabeladePreco> buscarTipo() throws DaoException {  
       String resultado = "falha";                 
           
            tabelaDAO = new TabeladePrecoDao();
            List<TabeladePreco> proteseList = tabelaDAO.consultarProteses(tipo);
            proteses = new ListDataModel<TabeladePreco>(proteseList);
       
       
            return proteseList; 
       
}  
    
    public DataModel<TabeladePreco> getProteses() throws DaoException {
        tabelaDAO = new TabeladePrecoDao();
        List<TabeladePreco> proteseList = tabelaDAO.consultarProteses(tipo);
        proteses = new ListDataModel<TabeladePreco>(proteseList);
        return proteses;
    }
    
     
    public void setProteses(DataModel<TabeladePreco> proteses) {
        this.proteses = proteses;
    }
}
