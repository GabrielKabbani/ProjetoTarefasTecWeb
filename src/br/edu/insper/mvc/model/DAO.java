package br.edu.insper.mvc.model;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;


public class DAO {
	private Connection connection = null;
	public DAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection= DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "");
		
	}
	
	
	public List<Tarefas> getLista() throws SQLException {
		
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tarefas");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			Tarefas tarefa = new Tarefas();
			tarefa.setId(rs.getInt("id"));
			tarefa.setCriador(rs.getString("criador"));
			tarefa.setNivel(rs.getInt("nivel"));
			tarefa.setData(rs.getDate("prazo"));
			tarefa.setTarefa(rs.getNString("tarefa"));
			tarefas.add(tarefa);
			
		}
		
		rs.close();
		stmt.close();
		return tarefas;
	}
	
	public void adiciona (Tarefas tarefa) throws SQLException {
		String sql = "INSERT INTO tarefas" + "(tarefa, prazo, nivel, criador) VALUES (?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, tarefa.getTarefa());
		stmt.setDate(2, (Date) tarefa.getData());
		stmt.setInt(3, tarefa.getNivel());
		stmt.setString(4, tarefa.getCriador());
		stmt.execute();
		stmt.close();
	}
	public void remove (Integer id) throws SQLException{
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM tarefas WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
	}
	public void atualiza (Tarefas tarefa) throws SQLException{
		PreparedStatement stmt = connection.prepareStatement("UPDATE tarefas SET tarefa=?, prazo=?, nivel=?, criador=? WHERE id=?");
		stmt.setString(1,tarefa.getTarefa());
		stmt.setDate(2,(java.sql.Date) tarefa.getData());
		stmt.setInt(3,Integer.valueOf(tarefa.getNivel()));
		stmt.setString(4,tarefa.getCriador());
		stmt.setInt(5, Integer.valueOf(tarefa.getId()));
		
		
		
		
		stmt.execute();
		stmt.close();
	}

	
	public void close() throws SQLException {
		connection.close();
	}
}
