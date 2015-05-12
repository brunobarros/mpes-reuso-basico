package chamado;

import java.util.Date;

public class Chamado {
	
	public static String STATUS_OPEN = "O";
	public static String STATUS_PROGRESS = "P";
	public static String STATUS_FINISHED = "F";
	
	private Long id;
	private String descricao;
	private Date dataHoraAbertura;
	private String status; //O - Open, P - Progress, F - Finished
	private double latitude;
	private double longitude;
	private TipoChamado tipoChamado;
	private String linkMapa;
	
	public Chamado() {
	
	}

	public Chamado(String descricao, Date dataHoraAbertura, String status,
			double latitude, double longitude, TipoChamado tipoChamado) {
		super();
		this.id = dataHoraAbertura.getTime();
		this.descricao = descricao;
		this.dataHoraAbertura = dataHoraAbertura;
		this.status = status;
		this.latitude = latitude;
		this.longitude = longitude;
		this.tipoChamado = tipoChamado;
		this.linkMapa = "http://localhost:8080/chamados/mapa?lat=" + latitude + "&lng=" + longitude;
	}
	
	public Chamado(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public TipoChamado getTipoChamado() {
		return tipoChamado;
	}

	public void setTipoChamado(TipoChamado tipoChamado) {
		this.tipoChamado = tipoChamado;
	}

	public String getLinkMapa() {
		return linkMapa;
	}

	public void setLinkMapa(String linkMapa) {
		this.linkMapa = linkMapa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
