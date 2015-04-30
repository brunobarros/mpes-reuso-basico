package servicochamado;

import java.util.HashMap;
import java.util.Map;

import servico.IServicoChamado;


public class ChamadoDrenagem implements IServicoChamado {

	public String getSigla() {
		return "D";
	}

	public String getDescricao() {
		return "Drenagem (desentupimento de galeria)";
	}

	public Map<String, String> getAtributosInput() {
		Map<String, String> atributos = new HashMap<String, String>();
		atributos.put("descricao", "text");
		atributos.put("latitude", "double");
		atributos.put("longitude", "double");
		return atributos;
	}

}
