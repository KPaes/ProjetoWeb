package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.exception.DaoException;
import br.com.util.DbUtil;
import br.com.bean.TabeladePreco;

public class TabeladePrecoDao {
		
	private static final  String CONSULTA_TABELADEPRECO =
			"select * from tbtabeladeprecos where tipoProtese = ? order by nomeProtese";
	
        private static final  String CONSULTA_TABELADEPRECO_TIPO =
			"select distinct tipoProtese from tbTabeladePrecos";
	
       	private static final  String CONSULTA_TABELADEPRECO_TUDO =
			"select * from tbTabeladePrecos";
        
	public List<TabeladePreco> consultarProteses(String tipo) throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		List<TabeladePreco> listaTab = new ArrayList<TabeladePreco>();
		try {
			statement = conn.prepareStatement(CONSULTA_TABELADEPRECO);
                        statement.setString(1, tipo);
			result = statement.executeQuery();
			while (result.next()) {
				TabeladePreco objTab = new TabeladePreco();
				objTab.setNumProtese(result.getInt(4));
				objTab.setNomeProtese(result.getString(2));
				objTab.setTipoProtese(result.getString(1));
				objTab.setPrecoProtese(result.getDouble(3));
				listaTab.add(objTab);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return listaTab;		
	}

	public List<TabeladePreco> consultarProtesesTipo() throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		List<TabeladePreco> listaTab = new ArrayList<TabeladePreco>();
		try {
			statement = conn.prepareStatement(CONSULTA_TABELADEPRECO_TIPO);
                        
			result = statement.executeQuery();
			while (result.next()) {
				TabeladePreco objTab = new TabeladePreco();
//				objTab.setNumProtese(result.getInt(4));
//				objTab.setNomeProtese(result.getString(2));
				objTab.setTipoProtese(result.getString(1));
//				objTab.setPrecoProtese(result.getDouble(3));
				listaTab.add(objTab);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return listaTab;		
	}
        
        public List<TabeladePreco> consultarTudo() throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		List<TabeladePreco> listaTab = new ArrayList<TabeladePreco>();
		try {
			statement = conn.prepareStatement(CONSULTA_TABELADEPRECO_TUDO);
                        
			result = statement.executeQuery();
			while (result.next()) {
				TabeladePreco objTab = new TabeladePreco();
				objTab.setNumProtese(result.getInt(4));
				objTab.setNomeProtese(result.getString(2));
				objTab.setTipoProtese(result.getString(1));
				objTab.setPrecoProtese(result.getDouble(3));
				listaTab.add(objTab);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return listaTab;		
	}
}
