package br.com.fin.tech.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fin.tech.bean.Receita;
import br.com.fin.tech.dao.ReceitaDAO;
import br.com.fin.tech.singleton.ConnectionManager;

public class OracleReceitaDAO  implements ReceitaDAO {
	private Connection conexao;
	PreparedStatement pstmt = null;

	public void insert(Receita receita) {
		try {
			conexao = ConnectionManager.getInstance().getConnection();

			pstmt = conexao.prepareStatement("INSERT INTO T_SCF_RECEITA"
					+ "( CD_RECEITA, CD_USUARIO, DATA, VALOR, DESCRICAO)" + " VALUES (SQ_RECEITA.NEXTVAL, ?, ?, ?, ?)");

			java.sql.Date data = new java.sql.Date(receita.getData().getTimeInMillis());

			pstmt.setInt(1, receita.getCdUsuario());
			pstmt.setDate(2, data);
			pstmt.setDouble(3, receita.getValor());
			pstmt.setString(4, receita.getDescricao());
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Receita> getAll(int cdUsuario) {
		List<Receita> receitas = new ArrayList<Receita>();
		ResultSet result = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();

			pstmt = conexao.prepareStatement("SELECT * FROM T_SCF_RECEITA WHERE CD_USUARIO = ?");
			pstmt.setInt(1, cdUsuario);
			result = pstmt.executeQuery();

			while (result.next()) {
				java.sql.Date dt = result.getDate("DATA");
				Calendar data = Calendar.getInstance();
				data.setTimeInMillis(dt.getTime());

				int cdReceita = result.getInt("CD_RECEITA");
				int cdUsuarioDB = result.getInt("CD_USUARIO");
				float valor = result.getFloat("VALOR");
				String descricao = result.getString("DESCRICAO");

				Receita receita = new Receita(cdReceita, cdUsuarioDB, data, valor, descricao);
				receitas.add(receita);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return receitas;

	}

	public Receita getByCd(int cdReceita) {
		Receita receita = null;
		ResultSet result = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();

			pstmt = conexao.prepareStatement("SELECT * FROM T_SCF_RECEITA WHERE CD_RECEITA = ?");
			pstmt.setInt(1, cdReceita);
			result = pstmt.executeQuery();

			result.next();

			java.sql.Date dt = result.getDate("DATA");
			Calendar data = Calendar.getInstance();
			data.setTimeInMillis(dt.getTime());

			int cdReceitaDB = result.getInt("CD_RECEITA");
			int cdUsuario = result.getInt("CD_USUARIO");
			float valor = result.getFloat("VALOR");
			String descricao = result.getString("DESCRICAO");

			Receita receitaDB = new Receita(cdReceitaDB, cdUsuario, data, valor, descricao);

			receita = receitaDB;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return receita;

	}

	public void update(Receita receita) {
		try {
			conexao = ConnectionManager.getInstance().getConnection();

			pstmt = conexao.prepareStatement(
					"UPDATE T_SCF_RECEITA SET DATA = ?, VALOR = ?, DESCRICAO = ? WHERE CD_RECEITA = ?");

			java.sql.Date data = new java.sql.Date(receita.getData().getTimeInMillis());

			pstmt.setDate(1, data);
			pstmt.setDouble(2, receita.getValor());
			pstmt.setString(3, receita.getDescricao());
			pstmt.setInt(4, receita.getCdReceita());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(int cdReceita) {
		try {
			conexao = ConnectionManager.getInstance().getConnection();

			pstmt = conexao.prepareStatement("DELETE FROM T_SCF_RECEITA " + "WHERE  CD_RECEITA = ?");

			pstmt.setInt(1, cdReceita);
			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
