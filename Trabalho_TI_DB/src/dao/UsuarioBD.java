package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioBD {
	
	private static UsuarioBD instance;
	private static final String role = "user";
	
	public static UsuarioBD getInstance(){
		if(instance == null){
			instance = new UsuarioBD();
		}
		return instance;
	}
	
	public boolean login(Usuario u){
		try {
			String sql = "SELECT * FROM USUARIO";

			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			String login=u.getLogin();
			String senha=u.getSenha();

			while (rs.next()) {
				String login_usuario = rs.getString("login_usuario");
				String senha_usuario = rs.getString("senha");
				if(login_usuario.equalsIgnoreCase(login) && senha_usuario.equals(senha)){
					return true;
				}
				
			}	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public void inserir(final Usuario usuario) {
		try {
			String sql = "INSERT INTO USUARIO VALUES (?,?,?,?)";

			Connection con = null;
			PreparedStatement st = null;

			con = BD.getCon();
			st = con.prepareStatement(sql.toString());
			st.setString(1, usuario.getLogin());
			st.setString(2, usuario.getNome());
			st.setString(3, usuario.getSenha());
			st.setString(4, role);
			st.executeUpdate();
			BD.closeCon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean validarLigin(String login){
		try {
			String sql = "SELECT login_usuario FROM USUARIO";

			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				String login_usuario = rs.getString("login_usuario");
				if(login_usuario.equalsIgnoreCase(login)){
					return false;
				}
				
			}	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}
	
	public List<Usuario> listarUsuarios(){
		List<Usuario> list = new ArrayList<Usuario>();
		try {
			String sql = "SELECT * FROM USUARIO";

			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			con = BD.getCon();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				String login_usuario = rs.getString("login_usuario");
				String nome = rs.getString("nome");
				String senha = rs.getString("senha");
				list.add(new Usuario(login_usuario, nome, senha));
			}	
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
}
