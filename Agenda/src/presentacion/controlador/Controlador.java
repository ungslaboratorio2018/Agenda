package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dto.DomicilioDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoDeContactoDTO;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.VentanaTipoDeContacto;
import presentacion.vista.Vista;

public class Controlador implements ActionListener {

	private Vista vista;
	private List<PersonaDTO> personas_en_tabla;
	private VentanaPersona ventanaPersona;
	private VentanaLocalidad ventanaLocalidad;
	private VentanaTipoDeContacto ventanaTipoDeContacto;
	private Agenda agenda;

	public Controlador(Vista vista, Agenda agenda) {
		this.vista = vista;
		this.vista.getBtnAgregarPersona().addActionListener(this);
		this.vista.getBtnAgregarTipoDeContacto().addActionListener(this);
		this.vista.getBtnAgregarLocalidad().addActionListener(this);
		this.vista.getBtnBorrar().addActionListener(this);
		this.vista.getBtnReporte().addActionListener(this);
		this.agenda = agenda;
		this.personas_en_tabla = null;
	}

	public void inicializar() {
		this.llenarTabla();
		this.vista.show();
	}

	private void llenarTabla() {
		this.vista.getModelPersonas().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelPersonas().setColumnCount(0);
		this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());

		this.personas_en_tabla = agenda.obtenerPersonas();
		for (int i = 0; i < this.personas_en_tabla.size(); i++) {
			PersonaDTO persona = this.personas_en_tabla.get(i);
			DomicilioDTO domicilio = agenda.obtenerDomicilioPorId(persona.getIdDomicilio());
			Object[] fila = { persona.getNombre(), 
					          persona.getTelefono(),
					          persona.getEmail(),
					          persona.getFechaDeNacimiento(),
					          domicilio.getCalle() + " - " + domicilio.getAltura()
					          };
			this.vista.getModelPersonas().addRow(fila);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.getBtnAgregarPersona()) {
			this.ventanaPersona = new VentanaPersona(this);
			setLocalidades();
			setTipoDeContacto();
		} else if (e.getSource() == this.vista.getBtnBorrar()) {
			int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filas_seleccionadas) {
				this.agenda.borrarPersona(this.personas_en_tabla.get(fila));
			}
			this.llenarTabla();
		} else if (e.getSource() == this.vista.getBtnReporte()) {
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();
		} else if (e.getSource() == this.ventanaPersona.getBtnAgregarPersona()) {
			try {
				String fechaString = this.ventanaPersona.getTxtFechaDeNacimiento().getText();
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");			
				Date date = format.parse(fechaString);
				@SuppressWarnings("deprecation")
				java.sql.Date sqlDate = new java.sql.Date(date.getYear(), date.getMonth(), date.getDay());
				
				LocalidadDTO localidad = (LocalidadDTO) this.ventanaPersona.getComboBoxLocalidades().getSelectedItem();
				TipoDeContactoDTO tipoDeContacto = (TipoDeContactoDTO) this.ventanaPersona.getComboBoxTipoDeContacto().getSelectedItem();
				
				DomicilioDTO domicilio =  new DomicilioDTO(
										  0, 
										  this.ventanaPersona.getTxtCalle().getText(), 
										  Integer.parseInt(this.ventanaPersona.getTxtAltura().getText()), 
										  Integer.parseInt(this.ventanaPersona.getTxtPiso().getText()), 
										  Integer.parseInt(this.ventanaPersona.getTxtDepartamento().getText()), 
										  localidad.getIdLocalidad());
				this.agenda.agregarDomicilio(domicilio);				
				int idDomicilio = agenda.idUltimoDomicilioAgregado();
				
				PersonaDTO persona = new PersonaDTO(
									      0, 
									      this.ventanaPersona.getTxtNombre().getText(), 
									      this.ventanaPersona.getTxtTelefono().getText(), 
									      this.ventanaPersona.getTxtEmail().getText(), 
									      sqlDate, 
									      idDomicilio, 
									      tipoDeContacto.getIdTipoDeContacto());
				this.agenda.agregarPersona(persona);
				this.llenarTabla();
				this.ventanaPersona.dispose();
				
			} catch (ParseException e1) {
				e1.printStackTrace();
			}			
		//} else if (e.getSource() == this.ventanaLocalidad.getBtnAgregarLocalidad()) {			
		//} else if (e.getSource() == this.ventanaLocalidad.getBtnAgregarTipoDeContacto()) {	
		}
	}

	private void setLocalidades() {
		List<LocalidadDTO> localidades = agenda.obtenerLocalidades();
		for (LocalidadDTO localidadDTO : localidades) {
			this.ventanaPersona.getComboBoxLocalidades().addItem(localidadDTO);
		}		
	} 
	
	private void setTipoDeContacto() {
		List<TipoDeContactoDTO> tiposDeContactos = agenda.obtenerTipoDeContactos();
		for (TipoDeContactoDTO tipoDeContactoDTO : tiposDeContactos) {
			this.ventanaPersona.getComboBoxTipoDeContacto().addItem(tipoDeContactoDTO);
		}
	} 

}
