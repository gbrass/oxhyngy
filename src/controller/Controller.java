package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.AlumnoDTO;
import model.dao.OracleConnection;
import model.dao.OracleConnectionSingleton;
import model.dao.OracleAlumnoDAO;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Controller() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String answer = "";
		OracleConnection conex = OracleConnectionSingleton.getOracleConnectionInstance();
		conex.openConection();
		
		switch(request.getParameter("option")) {
		case "searchAlumno":
			try {
				AlumnoDTO emp = new OracleAlumnoDAO(conex.conn).get(Integer.parseInt(request.getParameter("alumno_rut")));
				answer=Integer.toString(emp.getAlumno_rut()) + ',';
				answer=answer + emp.getAlumno_dv() + ',';
				answer=answer + emp.getAlumno_nombre() + ',';
				answer=answer + emp.getAlumno_correo() + ',';
			} catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "insertAlumno":
			try {
				AlumnoDTO alm = new AlumnoDTO();
				alm.setAlumno_rut(Integer.parseInt(request.getParameter("alumno_rut")));
				alm.setAlumno_dv(request.getParameter("alumno_dv"));
				alm.setAlumno_nombre(request.getParameter("alumno_nombre"));
				alm.setAlumno_correo(request.getParameter("alumno_correo"));

				OracleAlumnoDAO almDAO = new OracleAlumnoDAO(conex.conn);
				almDAO.insert(alm);
				answer="Alumno ingresado correctamente";
			} catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "updateAlumno":
			try {
				AlumnoDTO alm = new AlumnoDTO();
				alm.setAlumno_rut(Integer.parseInt(request.getParameter("alumno_rut")));
				alm.setAlumno_dv(request.getParameter("alumno_dv"));
				alm.setAlumno_nombre(request.getParameter("alumno_nombre"));
				alm.setAlumno_correo(request.getParameter("alumno_correo"));

				OracleAlumnoDAO almDAO = new OracleAlumnoDAO(conex.conn);
				almDAO.update(alm);
				answer="Alumno actualizado correctamente";
			} catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "deleteAlumno":
			try {
				AlumnoDTO alm = new AlumnoDTO();
				alm.setAlumno_rut(Integer.parseInt(request.getParameter("alumno_rut")));
				
				OracleAlumnoDAO almDAO = new OracleAlumnoDAO(conex.conn);
				almDAO.delete(alm);
				answer="Alumno eliminado correctamente";
			} catch(Exception e) {
				e.printStackTrace();
			}
			break;

		default:
			answer = "ERROR: Opcion no valida.";
		}
		
		conex.closeConnection();
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(answer);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String answer = "";
		OracleConnection conex = OracleConnectionSingleton.getOracleConnectionInstance();
		conex.openConection();
		
		switch(request.getParameter("option")) {
		case "searchAlumno":
			try {
				AlumnoDTO emp = new OracleAlumnoDAO(conex.conn).get(Integer.parseInt(request.getParameter("alumno_rut")));
				answer=Integer.toString(emp.getAlumno_rut()) + ',';
				answer=answer + emp.getAlumno_dv() + ',';
				answer=answer + emp.getAlumno_nombre() + ',';
				answer=answer + emp.getAlumno_correo() + ',';
			} catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "insertAlumno":
			try {
				AlumnoDTO alm = new AlumnoDTO();
				alm.setAlumno_rut(Integer.parseInt(request.getParameter("alumno_rut")));
				alm.setAlumno_dv(request.getParameter("alumno_dv"));
				alm.setAlumno_nombre(request.getParameter("alumno_nombre"));
				alm.setAlumno_correo(request.getParameter("alumno_correo"));

				OracleAlumnoDAO almDAO = new OracleAlumnoDAO(conex.conn);
				almDAO.insert(alm);
				answer="Alumno ingresado correctamente";
			} catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "updateAlumno":
			try {
				AlumnoDTO alm = new AlumnoDTO();
				alm.setAlumno_rut(Integer.parseInt(request.getParameter("alumno_rut")));
				alm.setAlumno_dv(request.getParameter("alumno_dv"));
				alm.setAlumno_nombre(request.getParameter("alumno_nombre"));
				alm.setAlumno_correo(request.getParameter("alumno_correo"));

				OracleAlumnoDAO almDAO = new OracleAlumnoDAO(conex.conn);
				almDAO.update(alm);
				answer="Alumno actualizado correctamente";
			} catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case "deleteAlumno":
			try {
				AlumnoDTO alm = new AlumnoDTO();
				alm.setAlumno_rut(Integer.parseInt(request.getParameter("alumno_rut")));
				
				OracleAlumnoDAO almDAO = new OracleAlumnoDAO(conex.conn);
				almDAO.delete(alm);
				answer="Alumno eliminado correctamente";
			} catch(Exception e) {
				e.printStackTrace();
			}
			break;

		default:
			answer = "ERROR: Opcion no valida.";
		}
		
		conex.closeConnection();
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(answer);
	}

}
