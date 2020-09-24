package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.Usuarios;

/**
 * Servlet implementation class usuarios
 */
@WebServlet("/usuarios")
public class usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = null;
		List<Usuarios> usuarios = new ArrayList<Usuarios>();
		try {
			dao = new DAO();
			String usuario_iq=request.getParameter("usuario");
			String senha_iq=request.getParameter("senha");
			usuarios=dao.getUsuarios();
			boolean naLista = false;
			for (Usuarios user : usuarios) {
				if (user.getUsuario().contentEquals(usuario_iq) && user.getSenha().contentEquals(senha_iq)) {
					naLista=true;
				}
			}
			if (naLista == true) {
				request.setAttribute("usuario", usuario_iq);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Lista");
				dispatcher.forward(request, response);
			}else {
				request.setAttribute("errou", "true");
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/login.jsp");
				dispatcher.forward(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
