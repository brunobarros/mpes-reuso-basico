package servicochamado;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import servico.IServicoChamado;
import chamado.Chamado;
import chamado.ChamadoRepository;
import chamado.TipoChamado;


public class ChamadoArborizacao implements IServicoChamado {

	@Override
	public TipoChamado getTipoChamado() {
		Map<String, String> atributos = new HashMap<String, String>();
		atributos.put("descricao", "text");
		atributos.put("latitude", "double");
		atributos.put("longitude", "double");
		
		TipoChamado tipoChamado = new TipoChamado("A", "Arborização (poda de árvore)");
		tipoChamado.setAtributosInput(atributos);
		
		return tipoChamado;
	}
	
	@Override
	public Chamado abrirChamado(Chamado chamado) {
		chamado.setDataHoraAbertura(new Date());
		chamado.setStatus(Chamado.STATUS_OPEN);
		chamado.setTipoChamado(getTipoChamado());
		
		ChamadoRepository.save(chamado);
		
		return chamado;
	}

}
