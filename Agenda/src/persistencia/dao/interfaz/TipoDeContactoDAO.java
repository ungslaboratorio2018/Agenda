package persistencia.dao.interfaz;

import java.util.List;
import dto.TipoDeContactoDTO;

public interface TipoDeContactoDAO {

	public boolean insert(TipoDeContactoDTO tipoDeContactoParaAgregar);

	public boolean delete(TipoDeContactoDTO tipoDeContactoParaEliminar);

	public List<TipoDeContactoDTO> readAll();
	
}
