package model.dao;
import java.sql.*;

public class Alumno {

	public Alumno() {
	}

	public boolean setName(int alumno_rut, String alumno_nombre, Connection pConn) {
		boolean ret = false;
		int files;
		String qry;
		
		try {
			Statement stmt = pConn.createStatement();
			qry="UPDATE ALUMNO SET alumno_nombre='" + alumno_nombre + "' ";
			qry=qry+"WHERE alumno_rut="+alumno_rut;
			files = stmt.executeUpdate(qry);
			System.out.println(Integer.toString(files));
			ret = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	
}
