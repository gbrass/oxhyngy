package model.dao;
import model.dto.AlumnoDTO;
import java.util.List;

public interface AlumnoDAO {
	/** Metodo abstracto que retorna todos los registros de la tabla Employees
	 * 
	 * @return
	 */
	List<AlumnoDTO> list();
	
	/** Metodo abstracto que inserta un registro en la tabla Employees
	 * 
	 * @return
	 */
	void insert(AlumnoDTO e);
	 
	/** Metodo abstracto que actualiza un registro de la tabla Employees
	 * 
	 * @return
	 */
	void update(AlumnoDTO e);
	
	/** Metodo abstracto que elimina un registro de la tabla Employees
	 * 
	 * @return
	 */
	void delete(AlumnoDTO e);
	
	/** Metodo abstracto que retorna un registro de la tabla Employees
	 * 
	 * @return
	 */
	AlumnoDTO get(int alumno_rut) throws DAOException;
}
