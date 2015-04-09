package servico;

import chamado.Chamado;
import chamado.TipoChamado;

public interface IServicoChamado {
	
	TipoChamado getTipoChamado();

	Chamado abrirChamado(Chamado chamado);
	
}
