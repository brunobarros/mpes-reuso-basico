package chamado;

import java.util.ArrayList;
import java.util.List;

public class ChamadoRepository {
	
	private static List<Chamado> chamados;

	public static List<Chamado> getChamados() {
		return chamados;
	}
	
	public synchronized static void save(Chamado chamado) {
		if (chamados == null) {
			chamados = new ArrayList<Chamado>();
		}
		chamados.add(chamado);
	}

}
