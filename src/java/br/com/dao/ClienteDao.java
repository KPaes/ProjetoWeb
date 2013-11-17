package br.com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.exception.DaoException;
import br.com.util.DbUtil;
import br.com.bean.ClienteDent;

public class ClienteDao {

	private static final String INSERIR_CLIENTE =
			"insert into tbcliente(nomeCliente, cpfCliente, telCliente, "+
			"ruaCliente, numEndCliente, bairroCliente, cidadeCliente, cepCliente, emailCliente, complCliente) " +
			"values (?,?,?,?,?,?,?,?,?,?)";
	
	
	private static final String VERIFICAR_CPF_EXISTENTE =
			"SELECT * FROM tbcliente WHERE cpfCliente = ?";
        
        
        
	public boolean inserirClientes(ClienteDent obj) throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(INSERIR_CLIENTE);
			statement.setString(1, obj.getNomeCliente());
			statement.setString(3, obj.getTelCliente());
			statement.setString(2, obj.getCpfCliente());
			statement.setString(4, obj.getRuaCliente());
			statement.setString(5, obj.getNumEndCliente());
			statement.setString(6, obj.getBairroCliente());
			statement.setString(7, obj.getCidadeCliente());
			statement.setString(8, obj.getCepCliente());
			statement.setString(9, obj.getEmailCliente());
                        statement.setString(10, obj.getComplCliente());
			statement.executeUpdate();
			
						
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}	
		return true;		
	}
	
	public boolean buscarCpfExistente(String cpfPaciente) throws DaoException{
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;		
		boolean existe = false;
		try{
			statement = conn.prepareStatement(VERIFICAR_CPF_EXISTENTE);	
			statement.setString(1, cpfPaciente);
			result = statement.executeQuery();
			if(result.next()){
				existe = true;				
			}
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			DbUtil.close(conn, statement, result);
		
		}
		
		return existe;
	}
}
