package br.edu.insper.mvc.model;

import java.io.Reader;
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
			tarefa.setPrazo(rs.getDate("prazo"));
			tarefa.setTarefa(rs.getNString("tarefa"));
			tarefas.add(tarefa);
			
		}
		
		rs.close();
		stmt.close();
		return tarefas;
	}
	public List<Tarefas> getQuery(String query, String categoria) throws SQLException {
		
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		if (query == null) {
			String string = "SELECT * FROM tarefas";
			PreparedStatement stmt = connection.prepareStatement(string);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Tarefas tarefa = new Tarefas();
				tarefa.setId(rs.getInt("id"));
				tarefa.setCriador(rs.getString("criador"));
				tarefa.setNivel(rs.getInt("nivel"));
				tarefa.setPrazo(rs.getDate("prazo"));
				tarefa.setTarefa(rs.getNString("tarefa"));
				tarefas.add(tarefa);
				
			}
			
			rs.close();
			stmt.close();
			return tarefas;
		}
		else {
			String string = null;
			if (categoria.contentEquals("prazo")) {
				string="SELECT * FROM tarefas WHERE prazo LIKE ?";
			}
			else if (categoria.contentEquals("tarefa")) {
				string="SELECT * FROM tarefas WHERE tarefa LIKE ?";
			}
			else if (categoria.contentEquals("criador")) {
				string="SELECT * FROM tarefas WHERE criador LIKE ?";
			}
			else if (categoria.contentEquals("nivel")) {
				string="SELECT * FROM tarefas WHERE nivel LIKE ?";
			}
			PreparedStatement stmt = connection.prepareStatement(string);
			stmt.setNString(1, query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				Tarefas tarefa = new Tarefas();
				tarefa.setId(rs.getInt("id"));
				tarefa.setCriador(rs.getString("criador"));
				tarefa.setNivel(rs.getInt("nivel"));
				tarefa.setPrazo(rs.getDate("prazo"));
				tarefa.setTarefa(rs.getNString("tarefa"));
				tarefas.add(tarefa);
				
			}
			
			rs.close();
			stmt.close();
			return tarefas;
		}
		
		
		
		
		
	}
	
	public List<Tarefas> getListaImpAsc() throws SQLException {
		
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tarefas ORDER BY nivel ASC");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			Tarefas tarefa = new Tarefas();
			tarefa.setId(rs.getInt("id"));
			tarefa.setCriador(rs.getString("criador"));
			tarefa.setNivel(rs.getInt("nivel"));
			tarefa.setPrazo(rs.getDate("prazo"));
			tarefa.setTarefa(rs.getNString("tarefa"));
			tarefas.add(tarefa);
			
		}
		
		rs.close();
		stmt.close();
		return tarefas;
	}
	public List<Tarefas> getListaImpDesc() throws SQLException {
		
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tarefas ORDER BY nivel DESC");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			Tarefas tarefa = new Tarefas();
			tarefa.setId(rs.getInt("id"));
			tarefa.setCriador(rs.getString("criador"));
			tarefa.setNivel(rs.getInt("nivel"));
			tarefa.setPrazo(rs.getDate("prazo"));
			tarefa.setTarefa(rs.getNString("tarefa"));
			tarefas.add(tarefa);
			
		}
		
		rs.close();
		stmt.close();
		return tarefas;
	}
	public List<Tarefas> getListaDatAsc() throws SQLException {
		
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tarefas ORDER BY prazo ASC");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			Tarefas tarefa = new Tarefas();
			tarefa.setId(rs.getInt("id"));
			tarefa.setCriador(rs.getString("criador"));
			tarefa.setNivel(rs.getInt("nivel"));
			tarefa.setPrazo(rs.getDate("prazo"));
			tarefa.setTarefa(rs.getNString("tarefa"));
			tarefas.add(tarefa);
			
		}
		
		rs.close();
		stmt.close();
		return tarefas;
	}
	public List<Tarefas> getListaDatDesc() throws SQLException {
		
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tarefas ORDER BY prazo DESC");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			Tarefas tarefa = new Tarefas();
			tarefa.setId(rs.getInt("id"));
			tarefa.setCriador(rs.getString("criador"));
			tarefa.setNivel(rs.getInt("nivel"));
			tarefa.setPrazo(rs.getDate("prazo"));
			tarefa.setTarefa(rs.getNString("tarefa"));
			tarefas.add(tarefa);
			
		}
		
		rs.close();
		stmt.close();
		return tarefas;
	}
	
	public List<Usuarios> getUsuarios() throws SQLException {
		
		List<Usuarios> usuarios = new ArrayList<Usuarios>();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM login");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			Usuarios usuario = new Usuarios();
			usuario.setUsuario(rs.getString("usuario"));
			usuario.setSenha(rs.getString("senha"));
			usuarios.add(usuario);
			
		}
		
		rs.close();
		stmt.close();
		return usuarios;
	}
	public void adicionaUsuario (Usuarios usuario) throws SQLException {
		String sql = "INSERT INTO login" + "(usuario, senha) VALUES (?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, usuario.getUsuario());
		stmt.setString(2, usuario.getSenha());
		stmt.execute();
		stmt.close();
	}

	public void adiciona (Tarefas tarefa) throws SQLException {
		String sql = "INSERT INTO tarefas" + "(tarefa, prazo, nivel, criador) VALUES (?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, tarefa.getTarefa());
		stmt.setDate(2, (Date) tarefa.getPrazo());
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
		stmt.setDate(2,(java.sql.Date) tarefa.getPrazo());
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
