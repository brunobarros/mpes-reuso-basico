package servicochamado;

import java.util.HashMap;
import java.util.Map;

import servico.IServicoChamado;

public class ChamadoLimpezaUrbana implements IServicoChamado {

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
		return "Limpeza Urbana (coleta de lixo)";
	}

	@Override
	public String getSigla() {
		return "LU";
	}
	
}
