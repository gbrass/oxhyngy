package model.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.dto.AlumnoDTO;

public class OracleAlumnoDAO implements AlumnoDAO {
	private Connection conn;

	final String insert = "INSERT INTO alumno VALUES (?,?,?,?)"; 
	final String update = "UPDATE alumno SET alumno_rut=?, alumno_dv=?, alumno_nombre=?, alumno_correo=?";
	final String delete = "DELETE alumno WHERE alumno_rut=?";	
	final String getone = "SELECT * FROM alumno WHERE alumno_rut=?";
	final String getall = "SELECT * FROM alumno";

	public OracleAlumnoDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<AlumnoDTO> list() {
		return null;
	}

	@Override
	public void insert(AlumnoDTO e) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(insert);
			stmt.setInt(1, e.getAlumno_rut());
			stmt.setString(2, e.getAlumno_dv());
			stmt.setString(3, e.getAlumno_nombre());
			stmt.setString(4, e.getAlumno_correo());

			if (stmt.executeUpdate() == 0) {
				throw new DAOException("Error en insert");
			}
		} catch (SQLException err) {
			err.printStackTrace();
		} catch (DAOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * @author oundurra
	 *
	 * Método que actualiza un registro de la tabla Employees
	 */
	@Override
	public void update(AlumnoDTO e) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(update);
			stmt.setInt(1, e.getAlumno_rut());
			stmt.setString(2, e.getAlumno_dv());
			stmt.setString(3, e.getAlumno_nombre());
			stmt.setString(4, e.getAlumno_correo());
		
			if (stmt.executeUpdate() == 0) {
				throw new DAOException("Error en update");
			}
		} catch (SQLException err) {
			// TODO Auto-generated catch block1
			err.printStackTrace();
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void delete(AlumnoDTO e) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(delete);
			stmt.setInt(1, e.getAlumno_rut());
			
			if (stmt.executeUpdate() == 0) {
				throw new DAOException("Error en delete");
			}
		} catch (SQLException err) {
			err.printStackTrace();
		} catch (DAOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public AlumnoDTO get(int alumno_rut) throws DAOException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AlumnoDTO almDTO = new AlumnoDTO();
		try {
			stmt = conn.prepareStatement(getone);
			stmt.setInt(1, alumno_rut);
			rs = stmt.executeQuery();
			if (rs.next()) {
				almDTO.setAlumno_rut(rs.getInt("alumno_rut"));
				almDTO.setAlumno_dv(rs.getString("alumno_dv"));
				almDTO.setAlumno_nombre(rs.getString("alumno_nombre"));
				almDTO.setAlumno_correo(rs.getString("alumno_correo"));
			} else {
				throw new DAOException("No se ha encontrado el registro.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return almDTO;
	}
	
}
