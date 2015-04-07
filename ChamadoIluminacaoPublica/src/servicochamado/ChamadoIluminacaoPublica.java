package servicochamado;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import chamado.Chamado;
import chamado.ChamadoRepository;
import servico.IServicoChamado;

public class ChamadoIluminacaoPublica implements IServicoChamado {

	@Override
	public String descricaoServico() {
		return "Iluminação Pública (poste com lâmpada queimada)";
	}

	@Override
	public Map<String, String> getAtributosInput() {
		Map<String, String> atributos = new HashMap<String, String>();
		atributos.put("descricao", "texto");
		atributos.put("latitude", "double");
		atributos.put("longitude", "double");
		return atributos ;
	}

	@Override
	public String getTipoChamado() {
		return "IP"; //Iluminação Pública
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
