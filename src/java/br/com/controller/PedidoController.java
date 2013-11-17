package br.com.controller;

import br.com.bean.Pedido;
import br.com.dao.PedidoDao;
import br.com.exception.DaoException;
import br.com.util.ValidaCPF;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.context.RequestContext;
/**
 *
 * @author Karina
 */
@ManagedBean(name="pedidoController")
@SessionScoped
//@ViewScoped 
public class PedidoController {
    private PedidoDao pedidoDAO;
    private Pedido pedido;
    private DataModel<Pedido> pedidos;
   
    
    public void novo(){
        
    }
 
    public PedidoController(){
        pedido = new Pedido();
    }
    
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
         
    
   public List getBuscaPedidos() throws DaoException {  
    return buscarCpf();  
  
}
 /*  public String buscarCpf() throws DaoException {  
       String resultado = "falha";
     //  boolean retorno;
        if (cpf.matches("^[0-9]*$")){            
            resultado = "consultarServicos";
            RequestContext context = RequestContext.getCurrentInstance();  
          context.execute("falha.show();");          
        return resultado;
        }*/
   
   
   public List<Pedido> buscarCpf() throws DaoException {  
       String resultado = "falha"; 
       
//       String resultad = "valido"; 
        if(ValidaCPF.valida(pedido.getCpfCliente()) == false ){
           resultado = "consultarServicos";
      
//           RequestContext context = RequestContext.getCurrentInstance();  
//          context.execute("valida.show();");
           
          FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao Consultar!", "CPF inválido!");            
        RequestContext.getCurrentInstance().showMessageInDialog(message);
     
        }else    if (cpf.equals("")){            
            resultado = "consultarServicos";
//            RequestContext context = RequestContext.getCurrentInstance();  
//          context.execute("falha.show();");
            
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro ao Consultar!", "Digite algum CPF!");            
        RequestContext.getCurrentInstance().showMessageInDialog(message);
       }
        else
           
            pedidoDAO = new PedidoDao();
            List<Pedido> pedidoList = pedidoDAO.consultarPedidos(cpf);
            pedidos = new ListDataModel<Pedido>(pedidoList);
        
            return pedidoList; 
        
}  
   
   
    public DataModel<Pedido> getPedidos() throws DaoException {
        pedidoDAO = new PedidoDao();
        List<Pedido> pedidoList = pedidoDAO.consultarPedidos(cpf);
        pedidos = new ListDataModel<Pedido>(pedidoList);
        return pedidos;
    }
 
    public void setPedidos(DataModel<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
