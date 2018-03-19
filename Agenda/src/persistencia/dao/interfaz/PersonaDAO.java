package persistencia.dao.interfaz;

import java.util.List;

import dto.PersonaDTO;

public interface PersonaDAO {

	public boolean insert(PersonaDTO personaParaAgregar);

	public boolean delete(PersonaDTO personaParaEliminar);

	public List<PersonaDTO> readAll();

}
