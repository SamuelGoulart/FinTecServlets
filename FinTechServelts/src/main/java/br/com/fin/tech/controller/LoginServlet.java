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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao;

	public LoginServlet() {
		dao = DAOFactory.getUsuarioDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario(email, senha);
	    Usuario resultUsuario = dao.validarUsuario(usuario);
		
		if ( resultUsuario != null) {
			HttpSession session = request.getSession();
			session.setAttribute("codigoUsuario", resultUsuario.getCdUsuario());
			session.setAttribute("user", email);

			response.sendRedirect("dashboard");
			
		} else {
			request.setAttribute("erro", "Usuário e/ou senha inválidos");
			request.getRequestDispatcher("cadastra-se-e-login.jsp").forward(request, response);
		}
	}

}
