package dto;

import java.sql.Date;

public class PersonaDTO {
	
	private long idPersona;
	private String nombre;
	private String telefono;
	private String email;
	private Date fechaDeNacimiento;
	private DomicilioDTO domicilio;
	private TipoDeContactoDTO tipoDeContacto;
	
	public PersonaDTO(long idPersona, String nombre, String telefono, String email,
			Date fechaDeNacimiento, DomicilioDTO domicilio, TipoDeContactoDTO tipoDeContacto) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.domicilio = domicilio;
		this.tipoDeContacto = tipoDeContacto;
	}
	
	public long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public DomicilioDTO getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(DomicilioDTO domicilio) {
		this.domicilio = domicilio;
	}
	public TipoDeContactoDTO getTipoDeContacto() {
		return tipoDeContacto;
	}
	public void setTipoDeContacto(TipoDeContactoDTO tipoDeContacto) {
		this.tipoDeContacto = tipoDeContacto;
	}

}
