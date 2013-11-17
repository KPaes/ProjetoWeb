package br.com.bean;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="TabeladePrecoBean")
@RequestScoped
public class TabeladePreco implements Serializable{

    static TabeladePreco Prot;
        
	//Atributos Tabela de Pre�o
	private Integer numProtese;
	private String nomeProtese;
	private String tipoProtese;
	private Double precoProtese;
	
//        public TabeladePreco(String tipoProtese, String nomeProtese, Double precoProtese) {
//                this.tipoProtese = tipoProtese;
//                this.nomeProtese = nomeProtese;
//                this.precoProtese = precoProtese;
//        }    

    

    	
	//M�todos
	
	//Getter and Setter Tabela de Pre�o
			public String getNomeProtese() {
				return nomeProtese;
			}
			public void setNomeProtese(String nomeProtese) {
				this.nomeProtese = nomeProtese;
				
			}
			
			public String getTipoProtese() {
				return tipoProtese;
			}
			public void setTipoProtese(String tipoProtese) {
				
					this.tipoProtese = tipoProtese;
				
			}
			
			public Double getPrecoProtese() {
				return precoProtese;
			}
			public void setPrecoProtese(Double precoProtese) {
				this.precoProtese = precoProtese;				
			}
			
			public Integer getNumProtese() {
				return numProtese;
			}
									

			public void setNumProtese(Integer numProtese) {
				this.numProtese = numProtese;
			}
                        
                        
                        
//Eclipse Generated hashCode and equals
//        @Override
//        public int hashCode() {
//                final int prime = 31;
//                int result = 1;
//                result = prime * result + ((tipoProtese == null) ? 0 : tipoProtese.hashCode());
//                result = prime * result + ((nomeProtese == null) ? 0 : nomeProtese.hashCode());
//                result = prime * result + ((precoProtese == null) ? 0 : precoProtese.hashCode());
//                return result;
//        }
//    			
//        @Override
//        public boolean equals(Object obj) {
//                if (this == obj)
//                        return true;
//                if (obj == null)
//                        return false;
//                if (getClass() != obj.getClass())
//                        return false;
//                TabeladePreco other = (TabeladePreco) obj;
//                if (tipoProtese == null) {
//                        if (other.tipoProtese != null)
//                                return false;
//                } else if (!tipoProtese.equals(other.tipoProtese))
//                        return false;
//                if (precoProtese == null) {
//                        if (other.precoProtese != null)
//                                return false;
//                } else if (!precoProtese.equals(other.precoProtese))
//                        return false;
//                if (nomeProtese == null) {
//                        if (other.nomeProtese != null)
//                                return false;
//                } else if (!nomeProtese.equals(other.nomeProtese))
//                        return false;
//                return true;
//        }
//
//        @Override
//        public String toString() {
//                return tipoProtese;
//        }
}
