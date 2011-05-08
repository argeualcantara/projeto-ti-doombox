package form;

import org.apache.struts.action.ActionForm;

public class UsuarioForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4065953482641861141L;
	private String login_usuario;
	private String nome;
	private String senha;
	
	public UsuarioForm() {
		super();
	}

	public UsuarioForm(String login_usuario, String nome, String senha) {
		super();
		this.login_usuario = login_usuario;
		this.nome = nome;
		this.senha = senha;
	}
	
	public String getLogin_usuario() {
		return login_usuario;
	}
	public void setLogin_usuario(String login_usuario) {
		this.login_usuario = login_usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
