package model.dao;
import java.sql.*;

public class Lists {

	public Lists() {
	}
	
	public String getAlumno(Connection conn) {
		String vret="";
		String sql="SELECT alumno_rut, alumno_nombre || ' ' || alumno_correo ";
		sql = sql + "FROM alumno";
				
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			vret = vret + "<table class='table table-bordered'>";
			vret = vret + "<thead><tr>";
			vret = vret + "<th>ALUMNO</th><th>NOMBRE</th><th>CORREO</th>";
			vret = vret + "</tr></thead>";
			vret = vret + "<tbody id='data'>";
			while(rs.next()) {
				vret=vret+"<tr>";
				vret=vret+"<td>"+rs.getString("alumno_rut")+"</td>";
				vret=vret+"<td>"+rs.getString("alumno_nombre")+"</td>";
				vret=vret+"<td>"+rs.getString("alumno_correo")+"</td>";
				vret=vret+"</tr>";
			}
			vret = vret + "</tbody></table>";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vret;
	}
}
