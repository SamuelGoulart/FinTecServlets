package br.com.fin.tech.bean;

public class Despesa {
	private int cdDespesa;
	private int cdUsuario;
	private float valor;
	private String descricao;
	private int cdCategoriaDespesa;
	private int despesa;

	public Despesa() {
		super();
	}

	public Despesa(int cdDespesa, int cdUsuario, float valor, String descricao, int cdCategoriaDespesa, int despesa) {
       super();
       this.cdDespesa = cdDespesa;
       this.cdUsuario = cdUsuario;
       this.valor = valor;
       this.descricao = descricao;
       this.cdCategoriaDespesa = cdCategoriaDespesa;
       this.despesa = despesa;
	}

	public int getCdDespesa() {
		return cdDespesa;
	}

	public void setCdDespesa(int cdDespesa) {
		this.cdDespesa = cdDespesa;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCdCategoriaDespesa() {
		return cdCategoriaDespesa;
	}

	public void setCdCategoriaDespesa(int cdCategoriaDespesa) {
		this.cdCategoriaDespesa = cdCategoriaDespesa;
	}

	public int getDespesa() {
		return despesa;
	}

	public void setDespesa(int despesa) {
		this.despesa = despesa;
	}

}
