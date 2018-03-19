package dto;

public class DomicilioDTO {
	
	private long idDomicilio;
	private String calle;
	private int altura;
	private int piso;
	private int departamento;
	private LocalidadDTO localidad;
	
	public DomicilioDTO(long idDomicilio, String calle, int altura, int piso, int departamento,
			LocalidadDTO localidad) {
		this.idDomicilio = idDomicilio;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.departamento = departamento;
		this.localidad = localidad;
	}
	
	public long getIdDomicilio() {
		return idDomicilio;
	}
	public void setIdDomicilio(long idDomicilio) {
		this.idDomicilio = idDomicilio;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public int getDepartamento() {
		return departamento;
	}
	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}
	public LocalidadDTO getLocalidad() {
		return localidad;
	}
	public void setLocalidad(LocalidadDTO localidad) {
		this.localidad = localidad;
	}

}
