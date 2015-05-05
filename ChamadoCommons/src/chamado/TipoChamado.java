package chamado;

import java.util.Map;

public class TipoChamado {
	
	private String codigo;
	private String descricao;
	private Map<String, String> atributosInput;
	
	public TipoChamado() {
	
	}
	
	public TipoChamado(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public TipoChamado(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Map<String, String> getAtributosInput() {
		return atributosInput;
	}

	public void setAtributosInput(Map<String, String> atributosInput) {
		this.atributosInput = atributosInput;
	}

}
