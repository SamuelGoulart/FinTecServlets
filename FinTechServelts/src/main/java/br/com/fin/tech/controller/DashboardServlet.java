package br.com.fin.tech.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fin.tech.bean.Receita;
import br.com.fin.tech.dao.ReceitaDAO;
import br.com.fin.tech.exception.DBException;
import br.com.fin.tech.factory.DAOFactory;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private ReceitaDAO daoReceita;

	public void init() throws ServletException {
		super.init();
		daoReceita = DAOFactory.getReceitaDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int codigoUsuario = (int) session.getAttribute("codigoUsuario");
		List<Receita> receitas = daoReceita.getAll(codigoUsuario);
		request.setAttribute("receitas", receitas);
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		switch (acao) {
		case "cadastrarReceita":
			cadastrarReceita(request, response);
			break;

		case "excluirReceita":
			excluirReceita(request, response);
			break;

		case "editarReceita":
			editarReceita(request, response);
			break;
		}
	}

	private void cadastrarReceita(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			String dataParam = request.getParameter("data");
			String[] splitData = dataParam.split("-");
			String dataPadraBrasileiro = splitData[2] + '/' + splitData[1] + '/' + splitData[0];
			data.setTime(format.parse(dataPadraBrasileiro));

			String descricao = request.getParameter("descricao");

			double valor = Double.parseDouble(request.getParameter("valor"));

			HttpSession session = request.getSession();
			int codigoUsuario = (int) session.getAttribute("codigoUsuario");

			Receita receita = new Receita(codigoUsuario, data, valor, descricao);
			daoReceita.insert(receita);

			request.setAttribute("msgCadastroReceita", "Receita cadastrada com sucesso!");
			response.sendRedirect("dashboard");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("msgErroCadastroReceita", "Erro ao cadastrar a receita");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgErroCadastroReceita", "Por favor, valide os dados");
		}
	}

	private void excluirReceita(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			int codigo = Integer.parseInt(request.getParameter("codigoReceita"));

			daoReceita.delete(codigo);
			request.setAttribute("msgSucessoParaDeletarReceita", "Receita removido!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgDeErroAoDeletarReceita", "Erro ao deletar a receita ");
		}
		response.sendRedirect("dashboard");

	}

	private void editarReceita(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			String dataParam = request.getParameter("data");
			String[] splitData = dataParam.split("-");
			String dataPadraBrasileiro = splitData[2] + '/' + splitData[1] + '/' + splitData[0];
			data.setTime(format.parse(dataPadraBrasileiro));

			int codigoReceita = Integer.parseInt(request.getParameter("codigoDeEditarReceita"));
			double valor = Double.parseDouble(request.getParameter("valor"));
			String descricao = request.getParameter("descricao");
			
			Receita receita = new Receita(data, valor, descricao, codigoReceita);
			daoReceita.update(receita);


		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}

	}
}