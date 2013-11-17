package br.com.bean;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.crypto.Data;

@ManagedBean(name="PedidoBean")
@RequestScoped
public class Pedido extends Pessoa{
	//Atributos
	private Integer numPed;
	private String nomePaciente;
	private Date dataPedido;
	private Date dataEntrega;
	private Double totalPedido;
	private String observacoesPed;
	
	//Getter and Setter
        
	public String getObservacoesPed() {
		return observacoesPed;
	}

        public void setObservacoesPed(String observacoesPed) {
                this.observacoesPed = observacoesPed;
        }
        
	public String getNomePaciente() {
		return nomePaciente;
	}
	
	public Double getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(Double totalPedido) {
		this.totalPedido = totalPedido;
	}

	public void setNomePaciente(String nomePaciente) {
		if(nomePaciente.equals("")){
			System.out.println("Campo Obrigat�rio!");
			
		}else{
		this.nomePaciente = nomePaciente;
		}
	}
	
	public Date getDataEntrega() {
		return dataEntrega;
	}
	
	public void setDataEntrega(Date dataEntrega) {
			this.dataEntrega = dataEntrega;
		
	}
	
	public Integer getNumPed() {
		return numPed;
	}

    public void setNumPed(Integer numPed) {
        this.numPed = numPed;
    }
	
	public void setDataPedido(Date dataPedido) {
			this.dataPedido = dataPedido;
		
	}
	
	
	public Date getDataPedido() {
		return dataPedido;
	}
	
	
	
	//M�todos
	public void efetuaPedido(){
		
		
	}

}
