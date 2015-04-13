package servico;

import java.util.Map;

public interface IServicoChamado {
	
	String getSigla();

	String getDescricao();

	Map<String, String> getAtributosInput();
	
}
