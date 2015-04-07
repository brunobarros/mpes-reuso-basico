package chamado;

import java.util.Date;

public class Chamado {
	
	public static String STATUS_OPEN = "O";
	public static String STATUS_PROGRESS = "P";
	public static String STATUS_FINISHED = "F";
	
	private String descricao;
	private Date dataHoraAbertura;
	private String status; //O - Open, P - Progress, F - Finished
	private double latitude;
	private double longitude;
	private String tipoChamado;
	
	public Chamado() {
	
	}

	public Chamado(String descricao, Date dataHoraAbertura, String status,
			double latitude, double longitude, String tipoChamado) {
		super();
		this.descricao = descricao;
		this.dataHoraAbertura = dataHoraAbertura;
		this.status = status;
		this.latitude = latitude;
		this.longitude = longitude;
		this.tipoChamado = tipoChamado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataHoraAbertura() {
		return dataHoraAbertura;
	}

	public void setDataHoraAbertura(Date dataHoraAbertura) {
		this.dataHoraAbertura = dataHoraAbertura;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getTipoChamado() {
		return tipoChamado;
	}

	public void setTipoChamado(String tipoChamado) {
		this.tipoChamado = tipoChamado;
	}
	
}
