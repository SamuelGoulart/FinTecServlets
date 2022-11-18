package br.com.fin.tech.bean;

import br.com.fin.tech.util.CriptografiaUtils;

public class Usuario {

	private int cdUsuario;
	private String nome;
	private String email;
	private String senha;
	private String foto;

	public Usuario() {
		super();
	}

	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		setSenha(senha);
	}

	public Usuario(String email, String senha) {
		super();
		this.email = email;
		setSenha(senha);
	}

	public Usuario(String nome, String email, int cdUsuario) {
		super();
		this.cdUsuario = cdUsuario;
		this.email = email;
		this.nome = nome;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		try {
			this.senha = CriptografiaUtils.criptografar(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
