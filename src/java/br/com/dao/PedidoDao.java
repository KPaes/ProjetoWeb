package br.com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.exception.DaoException;
import br.com.util.DbUtil;
import br.com.bean.Pedido;

public class PedidoDao {
	
	private static final  String CONSULTA_PEDIDOS_NOME =
			"select nomeCliente, nomePaciente, dataEntrega, totalPedido, observacoesPed from tbpedido where cpfCliente = ? order by cpfCliente";	
	
	public List<Pedido> consultarPedidos(String cpf) throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Pedido> listaPedido = new ArrayList<Pedido>();
		try {
                    //fazer um select pra descubrir o número do cliente
				statement = conn.prepareStatement(CONSULTA_PEDIDOS_NOME);
				statement.setString(1, cpf);
			result = statement.executeQuery();
			while (result.next()) {
				Pedido objPedido = new Pedido();
				objPedido.setNomeCliente(result.getString(1));
				objPedido.setNomePaciente(result.getString(2));
				objPedido.setDataEntrega(result.getDate(3));				
				objPedido.setTotalPedido(result.getDouble(4));
                                objPedido.setObservacoesPed(result.getString(5));
				listaPedido.add(objPedido);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return listaPedido;		
	}	
}