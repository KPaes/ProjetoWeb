package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.exception.DaoException;
import br.com.util.DbUtil;
import br.com.bean.ClienteDent;
import br.com.bean.Funcionario;

public class FuncionarioDao {
	private static final String EXCLUIR_FUNCIONARIO = 
			"delete from tbfuncionario where numFunc = ?";
	
	private static final String INSERIR_FUNCIONARIO =
			"insert into tbfuncionario(nomeFunc, telFunc, profissaoFunc, "+
			"login_funcionario, senha_funcionario, salarioFunc) " +
			"values (?,?,?,?,?,?)";
	
	private static final String ATUALIZAR_FUNCIONARIO =
			"update tbfuncionario set " +
			"nomeFunc = ?, " +
			"telFunc = ?, " +
			"profissaoFunc = ?, " +
			"login_funcionario = ?, " +
			"senha_funcionario = ?, " +
			"salarioFunc = ? " +			
			"where numFunc = ? ";
	
	private static final String ATUALIZAR_FUNCIONARIO_FOLHA =
			"update tbfuncionario set " +
			"nomeFunc = ?, " +
			//"telFunc = ?, " +
			"profissaoFunc = ?, " +
			"salarioFunc = ?, " +
			//"login_funcionario = ?, " +
			//"senha_funcionario = ? " +
			"where numFunc = ? ";
	
	private static final String VALIDAR_LOGIN_SENHA = 
		"select "+
			"count(numFunc) as total " +
		"from "+
			"tbfuncionario f "+
		"where "+
			"f.login_funcionario = ? and " +
			"f.senha_funcionario = ?";
	
	private static final  String CONSULTA_FUNCIONARIOS =
			"select * from tbfuncionario order by numFunc";
	
	private static final  String CONSULTA_FUNCIONARIO_ID = 
			"select * from tbfuncionario where numFunc = ?";
	
	private static final  String CONSULTA_FUNCIONARIOS_NOME =
			"select * from tbfuncionario where nomeFunc like ? order by nomeFunc";	
	
	private static final String PROCURAR_FUNCIONARIO_ID =
			"select nomeFunc from tbfuncionario where numFunc = ?";
	
	/**
	 * Atrav�s do n�mero digitado pelo usu�rio, o sistema faz uma busca e retorna o nome do funcionario
	 * @param idFunc
	 * @return
	 * @throws DaoException
	 */
	public Funcionario procurarFuncionarioID(Integer idFunc) throws DaoException{
		Funcionario objFunc = new Funcionario();
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(PROCURAR_FUNCIONARIO_ID);
			statement.setInt(1, idFunc);
			result = statement.executeQuery();
			if(result.next()) {
			
				objFunc.setNomeFunc(result.getString(1)); // o n�mero 1 indica a posi��o do dado no sql--> select (1)nomeCliente, (2)emailCliente from tbcliente where numCliente = ?
				
			}else{
				JOptionPane.showMessageDialog(null, "Funcion�rio n�o encontrado!");
			}
		}
			catch (SQLException e) {
				throw new DaoException(e);
			} finally {
				DbUtil.close(conn, statement, result);
			}
			return objFunc;	
	}
	
	public boolean getAutenticacao(String nome, String senha) throws DaoException {
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		int numReg = 0;
		boolean autenticado = false;
		try {			
			statement = conn.prepareStatement(VALIDAR_LOGIN_SENHA);
			statement.setString(1, nome);
			statement.setString(2, senha);
			result = statement.executeQuery();
			if (result.next()) {
				numReg = result.getInt("total");
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		if(numReg != 0){
			return autenticado = true;
		}else{
			return autenticado;			
		}
	}		

	
	public List<Funcionario> consultarFuncionarios() throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Funcionario> listaFunc = new ArrayList<Funcionario>();
		try {
			statement = conn.prepareStatement(CONSULTA_FUNCIONARIOS);
			result = statement.executeQuery();
			while (result.next()) {
				Funcionario objFunc = new Funcionario();
				objFunc.setNumFunc(result.getInt(1));
				objFunc.setNomeFunc(result.getString(2));
				objFunc.setTelFunc(result.getString(3));
				objFunc.setProfissaoFunc(result.getString(4));
				objFunc.setLogin(result.getString(5));
				objFunc.setSenha(result.getString(6));
				objFunc.setSalarioFunc(result.getDouble(7));				
				listaFunc.add(objFunc);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return listaFunc;		
	}

	public Funcionario consultarFuncionarioID(int idFunc) throws DaoException{		
		Funcionario objFunc = new Funcionario();
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(CONSULTA_FUNCIONARIO_ID);
			statement.setInt(1, idFunc);
			result = statement.executeQuery();
			while (result.next()) {
				//JOptionPane.showMessageDialog(null, String.valueOf(result.getInt(1)));
				objFunc.setNumFunc(result.getInt(1));
				objFunc.setNomeFunc(result.getString(2));
				objFunc.setTelFunc(result.getString(3));
				objFunc.setProfissaoFunc(result.getString(4));
				objFunc.setLogin(result.getString(5));
				objFunc.setSenha(result.getString(6));
				objFunc.setSalarioFunc(result.getDouble(7));				
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return objFunc;		
	}
	
	public List<Funcionario> consultarFuncionarios(String nome) throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Funcionario> listaFunc = new ArrayList<Funcionario>();
		try {
			if(nome.equals("")){
				statement = conn.prepareStatement(CONSULTA_FUNCIONARIOS);
			}else{
				statement = conn.prepareStatement(CONSULTA_FUNCIONARIOS_NOME);
				statement.setString(1, "%"+nome+"%");
			}
			result = statement.executeQuery();
			while (result.next()) {
				Funcionario objFunc = new Funcionario();
				objFunc.setNumFunc(result.getInt(1));
				objFunc.setNomeFunc(result.getString(2));
				objFunc.setTelFunc(result.getString(3));
				objFunc.setProfissaoFunc(result.getString(4));
				objFunc.setSalarioFunc(result.getDouble(7));
				objFunc.setLogin(result.getString(5));
				objFunc.setSenha(result.getString(6));
				listaFunc.add(objFunc);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return listaFunc;		
	}	

	public int inserirFuncionarios(Funcionario obj, int matri) throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			statement = conn.prepareStatement(INSERIR_FUNCIONARIO);
			statement.setString(1, obj.getNomeFunc());
			statement.setString(2, obj.getTelFunc());
			statement.setString(3, obj.getProfissaoFunc());
			statement.setString(4, obj.getLogin());
			statement.setString(5, obj.getSenha());
			statement.setDouble(6, obj.getSalarioFunc());			
			statement.executeUpdate();
			
			statement = conn.prepareStatement("select max(numFunc) from tbfuncionario");
			result = statement.executeQuery();
			
			result.next();
			matri = result.getInt(1);
			
			JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!\n N�mero do Funcion�rio: " + matri);
			

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return matri;		
	}
	
	public boolean atualizarFuncionario(Funcionario objFunc) throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(ATUALIZAR_FUNCIONARIO);
			statement.setString(1, objFunc.getNomeFunc());
			statement.setString(2, objFunc.getTelFunc());
			statement.setString(3, objFunc.getProfissaoFunc());
			statement.setString(4, objFunc.getLogin());
			statement.setString(5, objFunc.getSenha());		
			statement.setInt(7, objFunc.getNumFunc()); //6
			statement.setDouble(6, objFunc.getSalarioFunc());			
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return true;		
	}
	
	public boolean atualizarFuncionarioFunc(Funcionario objFunc) throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(ATUALIZAR_FUNCIONARIO_FOLHA);
			statement.setString(1, objFunc.getNomeFunc());
			//statement.setString(2, objFunc.getTelFunc());
			statement.setString(3, objFunc.getProfissaoFunc());
			statement.setDouble(6, objFunc.getSalarioFunc());
			//statement.setString(5, objFunc.getLogin());
			//statement.setString(6, objFunc.getSenha());		
			statement.setInt(7, objFunc.getNumFunc());
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return true;		
	}

	public boolean excluirFuncionarios(int idFuncioanrio) throws DaoException{		
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(EXCLUIR_FUNCIONARIO);
			statement.setInt(1, idFuncioanrio);
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbUtil.close(conn, statement, result);
		}
		return true;		
	}
}