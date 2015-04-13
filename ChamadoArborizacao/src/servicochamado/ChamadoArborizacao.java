package servicochamado;

import java.util.HashMap;
import java.util.Map;

import servico.IServicoChamado;


public class ChamadoArborizacao implements IServicoChamado {

	public String getSigla() {
		return "A";
	}

	public String getDescricao() {
		return "Arborização (poda de árvore)";
	}

	public Map<String, String> getAtributosInput() {
		Map<String, String> atributos = new HashMap<String, String>();
		atributos.put("descricao", "text");
		atributos.put("latitude", "double");
		atributos.put("longitude", "double");
		return atributos;
	}

}
