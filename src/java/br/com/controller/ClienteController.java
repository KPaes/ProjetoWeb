/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

/**
 *
 * @author Karina
 */

import br.com.bean.ClienteDent;
import br.com.dao.ClienteDao;
import br.com.exception.DaoException;
import br.com.util.ValidaCPF;
import br.com.util.ValidaEmail;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

@ManagedBean(name="clienteController")
@SessionScoped
@ViewScoped 
public class ClienteController {
    private ClienteDao clienteDao;
    private ClienteDent cliente;
 
    public void novo(){
        
    }
 
    public ClienteController(){
        cliente = new ClienteDent();
    }
    
    public String inserir() throws DaoException{
        String resultado = "falha";
        if(cliente.getNomeCliente().isEmpty() || cliente.getCpfCliente().isEmpty() 
             || cliente.getTelCliente().isEmpty() || cliente.getRuaCliente().isEmpty()
             || cliente.getNumEndCliente().isEmpty() || cliente.getEmailCliente().isEmpty()
             || cliente.getBairroCliente().isEmpty() || cliente.getCidadeCliente().isEmpty()
             || cliente.getCepCliente().isEmpty() || cliente.getEmailCliente().isEmpty()){
       resultado = "cadastroCliente";
      
          FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao Cadastrar!", "Há campo(s) vazio(s)!");            
        RequestContext.getCurrentInstance().showMessageInDialog(message);
          
     } else
        if(ValidaCPF.valida(cliente.getCpfCliente()) == false ){
           resultado = "cadastroCliente";
      
          FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao Cadastrar!", "CPF inválido!");            
        RequestContext.getCurrentInstance().showMessageInDialog(message);
          
        }else  if(ValidaCPF.existe(cliente.getCpfCliente()) == false ){
           resultado = "cadastroCliente";
          FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao Cadastrar!", "CPF já cadastrado! Tente outro!");            
           RequestContext.getCurrentInstance().showMessageInDialog(message);
          
        }
        else if(ValidaEmail.validaEmail(cliente.getEmailCliente()) == false) {
            resultado = "cadastroCliente";
          
       FacesMessage   message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao Cadastrar!", "Email inválido!");            
        RequestContext.getCurrentInstance().showMessageInDialog(message);

   }else if(resultado.equals("falha")){
        
        clienteDao = new ClienteDao();
        boolean retorno = clienteDao.inserirClientes(cliente);
        if(retorno){
            resultado = "cadastroCliente";
            
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Cliente cadastrado!");            
        RequestContext.getCurrentInstance().showMessageInDialog(message);
        
        }
        else{
            resultado = "cadastroCliente";
          
         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro!", "Cliente não cadastrado!");            
        RequestContext.getCurrentInstance().showMessageInDialog(message);
        }
        }
        
        return resultado;
    }
    
    public void showMessage() {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro", "Salvo com sucesso!");  
          
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, message);
    } 
 
 public ClienteDent getCliente() {
        return cliente;
    }
 
    public void setCliente(ClienteDent cliente) {
        this.cliente = cliente;
    }
    
 public String valida(){
     String resultado = "falha";
     if(cliente.getNomeCliente().isEmpty() || cliente.getCpfCliente().isEmpty() 
             || cliente.getTelCliente().isEmpty() || cliente.getRuaCliente().isEmpty()
             || cliente.getNumEndCliente().isEmpty() || cliente.getEmailCliente().isEmpty()
             || cliente.getBairroCliente().isEmpty() || cliente.getCidadeCliente().isEmpty()
             || cliente.getCepCliente().isEmpty() || cliente.getEmailCliente().isEmpty()){
       resultado = "cadastroCliente";
      
          FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao Cadastrar!", "Há campo(s) vazio(s)!");            
        RequestContext.getCurrentInstance().showMessageInDialog(message);
          
     }
 return resultado;
 
}
}