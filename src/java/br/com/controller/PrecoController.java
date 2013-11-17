package br.com.controller;


import br.com.bean.TabeladePreco;
import br.com.dao.TabeladePrecoDao;
import br.com.exception.DaoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Karina
 */
@ManagedBean(name="precoController")
@SessionScoped
public class PrecoController {
    private TabeladePrecoDao tabelaDAO;
    private TabeladePreco tabela;
    private DataModel<TabeladePreco> proteses;
   
    private String tipo;
    
    
    public void novo(){
        
    }

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
        this.tipo = tipo;
    }
 
    public PrecoController(){
        TabeladePreco tabela = new TabeladePreco();
    }
    
    private String tipoProtese;

    public String getTipoProtese() {
        return tipoProtese;
    }

    public void setTipoProtese(String tipoProtese) {
        this.tipoProtese = tipoProtese;
    }
                
    
   public List getBuscaProteses() throws DaoException {  
    return buscarTipo();     
  
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
    
    //populando select
//    public List<SelectItem> getProteses() throws Exception{
// TabeladePrecoDao pessoaService = new TabeladePrecoDao();
//
// List<TabeladePreco> protese = pessoaService.consultarTudo();
//
// List<SelectItem> proteses = new ArrayList<SelectItem>(protese.size()); 
//
// for(TabeladePreco p : protese){
// proteses.add(new SelectItem(p.getTipoProtese()));
// }
//        return proteses;
//    }
    
//
//public List<TabeladePreco> arrayListaProfissoes(){    
//        List<TabeladePreco> lista;    
//        lista = new tabelaDAO<TabeladePrecoDao>().findAll("Profissao", "profissao");    
//        return lista;    
//}


}