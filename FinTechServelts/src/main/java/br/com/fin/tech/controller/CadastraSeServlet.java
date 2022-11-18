package br.com.fin.tech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fin.tech.bean.Usuario;
import br.com.fin.tech.dao.UsuarioDAO;
import br.com.fin.tech.factory.DAOFactory;

@WebServlet("/cadastra-se")
public class CadastraSeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao;

	public CadastraSeServlet() {
		dao = DAOFactory.getUsuarioDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario(nome, email, senha);

		if (dao.cadastrarUsuario(usuario)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
			session.setAttribute("userNome", nome);
		} else {
			request.setAttribute("erro", "Usuário e/ou senha inválidos");
		}
		request.getRequestDispatcher("cadastra-se-e-login.jsp").forward(request, response);
	}

}
