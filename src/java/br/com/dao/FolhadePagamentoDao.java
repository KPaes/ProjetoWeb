package br.com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.exception.DaoException;
import br.com.util.DbUtil;
import br.com.bean.ClienteDent;
import br.com.bean.FolhaPagamento;

public class FolhadePagamentoDao {

	private static final String EXCLUIR_PAGAMENTO = 
			"delete from tbfolhadepagamento where numFunc = ?";
	
	private static final String INSERIR_PAGAMENTO =
			"insert into tbfolhadepagamento(numFunc, nomeFunc, profissaoFunc, salarioFunc, " +
			"comissaoFunc, bonusFunc, totalFunc)" +
			"values (?,?,?,?,?,?)";
	
	private static final String ATUALIZAR_PAGAMENTO =
			"update tbfolhadepagamento set " +
			"nomeFunc = ?, " +
			"profissaoFunc = ?, " +
			"salarioFunc = ?, " +
			"comissaoFunc = ?, " +
			"bonusFunc = ?, " +
			"totalFunc = ?, " +
			"where numFunc = ? ";
	
	
	private static final  String CONSULTA_PAGAMENTO=
			"select * from tbfolhadepagamento order by nomeFunc";
	
	private static final  String CONSULTA_PAGAMENTO_ID = 
			"select * from tbfolhadepagamento where numFunc = ?";
	
	
	
	public List<FolhaPagamento> consultarPagamento() throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		List<FolhaPagamento> listaFolha = new ArrayList<FolhaPagamento>();
		try {
			statement = conn.prepareStatement(CONSULTA_PAGAMENTO);
			result = statement.executeQuery();
			while (result.next()) {
				FolhaPagamento objFolha = new FolhaPagamento();
				objFolha.setNumFunc(result.getInt(1)); 
				objFolha.setNomeFunc(result.getString(2));
				objFolha.setSalarioFunc(result.getDouble(3));
				objFolha.setProfissaoFunc(result.getString(4));
				objFolha.setComissaoFunc(result.getDouble(5));
				objFolha.setBonusFunc(result.getDouble(6));
				objFolha.setTotalFunc(result.getDouble(7));
				listaFolha.add(objFolha);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return listaFolha;		
	}

	public FolhaPagamento consultarPagamentoID(int idFunc) throws DaoException{		
		FolhaPagamento objFolha = new FolhaPagamento();
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(CONSULTA_PAGAMENTO_ID);
			statement.setInt(1, idFunc);
			result = statement.executeQuery();
			while (result.next()) {
				objFolha.setCodDep(result.getInt(1)); 
				objFolha.setNumFunc(result.getInt(1)); 
				objFolha.setNomeFunc(result.getString(2));
				objFolha.setSalarioFunc(result.getDouble(3));
				objFolha.setProfissaoFunc(result.getString(4));
				objFolha.setComissaoFunc(result.getDouble(5));
				objFolha.setBonusFunc(result.getDouble(6));
				objFolha.setTotalFunc(result.getDouble(7));
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return objFolha;		
	}

	public boolean inserirPagamento(FolhaPagamento obj) throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(INSERIR_PAGAMENTO);
			statement.setInt(1, obj.getNumFunc());
			statement.setString(2, obj.getNomeFunc());
			statement.setDouble(3, obj.getSalarioFunc());
			statement.setString(4, obj.getProfissaoFunc());
			statement.setDouble(5, obj.getComissaoFunc());
			statement.setDouble(6, obj.getBonusFunc());
			//statement.setDouble(7, obj.getTotalFunc());
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return true;		
	}
	
	public boolean atualizarPagamento(FolhaPagamento objFolha) throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(ATUALIZAR_PAGAMENTO);
			statement.setInt(1, objFolha.getNumFunc());
			statement.setString(2, objFolha.getNomeFunc());
			statement.setDouble(3, objFolha.getSalarioFunc());
			statement.setString(4, objFolha.getProfissaoFunc());
			statement.setDouble(5, objFolha.getComissaoFunc());
			statement.setDouble(6, objFolha.getBonusFunc());
			//statement.setDouble(7, objFolha.getTotalFunc());
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return true;		
	}

	public boolean excluirPagamento(int idFunc) throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(EXCLUIR_PAGAMENTO);
			statement.setInt(1, idFunc);
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return true;		
	}
}

