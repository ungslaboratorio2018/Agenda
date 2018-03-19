package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.DomicilioDTO;
import dto.PersonaDTO;
import dto.TipoDeContactoDTO;

public class PersonaDAOSQL implements PersonaDAO {

	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono, email, fechaDeNacimiento, idDomicilio, idTipoDeContacto) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM personas";

	public boolean insert(PersonaDTO persona) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setLong(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, persona.getEmail());
			statement.setDate(5, persona.getFechaDeNacimiento());
			statement.setLong(6, persona.getDomicilio().getIdDomicilio());
			statement.setLong(7, persona.getTipoDeContacto().getIdTipoDeContacto());
			if (statement.executeUpdate() > 0) // Si se ejecut� devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(PersonaDTO persona_a_eliminar) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Long.toString(persona_a_eliminar.getIdPersona()));
			chequeoUpdate = statement.executeUpdate();
			if (chequeoUpdate > 0) // Si se ejecutó devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<PersonaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				personas.add(new PersonaDTO(resultSet.getLong("idPersona"), resultSet.getString("nombre"),
						resultSet.getString("telefono"), resultSet.getString("email"),
						resultSet.getDate("fechaDeNacimiento"), new DomicilioDTO(1,"",1,1,1,1),
						new TipoDeContactoDTO(1,"")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personas;
	}

	@Override
	public boolean update(PersonaDTO personaParaActualizar) {
		// TODO Auto-generated method stub
		return false;
	}
}
