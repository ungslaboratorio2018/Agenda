package persistencia.dao.interfaz;

import java.util.List;

import dto.DomicilioDTO;

public interface DomicilioDAO {

	public boolean insert(DomicilioDTO domicilioParaAgregar);

	public boolean delete(DomicilioDTO domicilioParaEliminar);

	public List<DomicilioDTO> readAll();
	
}
