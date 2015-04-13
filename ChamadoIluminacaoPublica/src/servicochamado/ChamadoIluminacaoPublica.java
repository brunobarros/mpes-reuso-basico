package servicochamado;

import java.util.HashMap;
import java.util.Map;

import servico.IServicoChamado;

public class ChamadoIluminacaoPublica implements IServicoChamado {

	@Override
	public Map<String, String> getAtributosInput() {
		Map<String, String> atributos = new HashMap<String, String>();
		atributos.put("descricao", "text");
		atributos.put("latitude", "double");
		atributos.put("longitude", "double");
		return atributos;
	}

	@Override
	public String getDescricao() {
		return "Iluminação Pública (poste com lâmpada queimada)";
	}

	@Override
	public String getSigla() {
		return "IP";
	}
	
}
