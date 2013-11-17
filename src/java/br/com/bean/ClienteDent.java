package br.com.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="ClienteDentBean")
@RequestScoped
public class ClienteDent extends Pessoa{
		
		
	//M�todos
	public Double saldoTotal(Double somapedidos){
		return somapedidos;
	}
	
	public String todosPedidos(String pedidos){ //mostrar todos os pedidos cadastrados no banco de dados
		return pedidos;
	}

}
