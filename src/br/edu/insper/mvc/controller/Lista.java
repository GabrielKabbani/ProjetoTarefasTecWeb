package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.Tarefas;

/**
 * Servlet implementation class Lista
 */
@WebServlet("/Lista")
public class Lista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao;
		List<Tarefas> tarefas = null;
		try {
			dao = new DAO();
			String usuario = (String) request.getAttribute("usuario");
			System.out.println("ATRIBUTO NA LISTA"+usuario);
			System.out.println("PARAM NA LISTA"+request.getParameter("usuario"));
			String imp = request.getParameter("imp");
			String dat = request.getParameter("dat");
			String query = request.getParameter("query");
			String categoria = request.getParameter("categoria");
			

			if(query!=null) {
				tarefas=dao.getQuery("%"+query+"%",categoria,request.getParameter("usuario"));
			}
			else if (imp!= null && imp.contentEquals("imp_asc")) {
				tarefas = dao.getListaImpAsc(request.getParameter("usuario"));
			}
			else if (imp!= null && imp.contentEquals("imp_desc")) {
				tarefas = dao.getListaImpDesc(request.getParameter("usuario"));
			}
			else if (dat!= null && dat.contentEquals("dat_asc")) {
				tarefas = dao.getListaDatAsc(request.getParameter("usuario"));
			}
			else if (dat!= null && dat.contentEquals("dat_desc")) {
				tarefas = dao.getListaDatDesc(request.getParameter("usuario"));
			}
			else {
				tarefas = dao.getLista(usuario);
			}
			request.setAttribute("tarefas", tarefas);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/Main.jsp");
			dispatcher.forward(request,response);
			dao.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	

}
