
package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.Tarefas;

/**
 * Servlet implementation class atualiza
 */
@WebServlet("/atualiza")
public class atualiza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public atualiza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/atualiza.jsp");
		dispatcher.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao=null;
		try {
			dao = new DAO();
			Tarefas tarefa = new Tarefas();
			tarefa.setNivel(Integer.valueOf(request.getParameter("nivel")));
			tarefa.setCriador(request.getParameter("criador"));
			String data = request.getParameter("prazo");
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(data);
			java.sql.Date prazo= new java.sql.Date(date.getTime());
			tarefa.setPrazo(prazo);
			tarefa.setTarefa(request.getParameter("tarefa"));
			tarefa.setId(Integer.valueOf(request.getParameter("id")));
			
			dao.atualiza(tarefa);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Lista");
		dispatcher.forward(request, response);
		
	}

}
