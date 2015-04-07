package servico;

import java.util.Map;

import chamado.Chamado;

public interface IServicoChamado {
	
	String descricaoServico();

	Map<String, String> getAtributosInput();

	String getTipoChamado();
	
	Chamado abrirChamado(Chamado chamado);
	
}
