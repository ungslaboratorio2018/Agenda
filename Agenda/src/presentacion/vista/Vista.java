package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import persistencia.conexion.Conexion;

public class Vista {

	private JFrame frame;
	private JTable tablaPersonas;
	private JButton btnAgregarPersona;
	private JButton btnAgregarTipoDeContacto;
	private JButton btnAgregarLocalidad;
	private JButton btnBorrar;
	private JButton btnReporte;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = { "Nombre y apellido", "Teléfono", "Correo Electronico", "Fecha de Nacimiento", "Domicilio", "Tipo de Contacto" };

	public Vista() {
		super();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1000, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 800, 200);
		panel.add(spPersonas);

		modelPersonas = new DefaultTableModel(null, nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);

		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);

		spPersonas.setViewportView(tablaPersonas);

		btnAgregarPersona = new JButton("Agregar Persona");
		btnAgregarPersona.setBounds(10, 228, 150, 23);
		panel.add(btnAgregarPersona);
		
		btnAgregarTipoDeContacto = new JButton("Agregar Tipo de Contacto");
		btnAgregarTipoDeContacto.setBounds(160, 228, 150, 23);
		panel.add(btnAgregarTipoDeContacto);
		
		btnAgregarLocalidad= new JButton("Agregar Localidad");
		btnAgregarLocalidad.setBounds(310, 228, 150, 23);
		panel.add(btnAgregarLocalidad);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(540, 228, 89, 23);
		panel.add(btnEditar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(629, 228, 89, 23);
		panel.add(btnBorrar);

		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(718, 228, 89, 23);
		panel.add(btnReporte);
	}

	public void show() {
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(null, "Estas seguro que quieres salir de la Agenda!?",
						"Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 0) {
					Conexion.getConexion().cerrarConexion();
					System.exit(0);
				}
			}
		});
		this.frame.setVisible(true);
	}

	public JButton getBtnAgregarPersona() {
		return btnAgregarPersona;
	}
	
	public JButton getBtnAgregarTipoDeContacto() {
		return btnAgregarTipoDeContacto;
	}
	
	public JButton getBtnAgregarLocalidad() {
		return btnAgregarLocalidad;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public JButton getBtnReporte() {
		return btnReporte;
	}

	public DefaultTableModel getModelPersonas() {
		return modelPersonas;
	}

	public JTable getTablaPersonas() {
		return tablaPersonas;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}
}
