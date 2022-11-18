package br.com.fin.tech.bean;

import java.util.Calendar;

public class Receita {
	private int cdReceita;
	private int cdUsuario;
	private Calendar data;
	private double valor;
	private String descricao;

	public Receita() {
		super();
	}
	
	public Receita(int cdReceita, int cdUsuario, Calendar data, double valor, String descricao) {
		super();
		this.cdReceita = cdReceita;
		this.cdUsuario = cdUsuario;
		this.data = data;
		this.valor = valor;
		this.descricao = descricao;
	}

	
	public Receita(int cdUsuario, Calendar data, double valor, String descricao) {
		super();
		this.cdUsuario= cdUsuario;
		this.data = data;
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public Receita(Calendar data, double valor, String descricao, int cdReceita) {
		super();
		this.cdReceita = cdReceita;
		this.data = data;
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public int getCdReceita() {
		return cdReceita;
	}

	public void setCdReceita(int cdReceita) {
		this.cdReceita = cdReceita;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
