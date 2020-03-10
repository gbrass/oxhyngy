package model.dto;

public class AlumnoDTO {
	private int alumno_rut;
	private String alumno_dv;
	private String alumno_nombre;
	private String alumno_correo;
	
	public AlumnoDTO() {
	}

	public int getAlumno_rut() {
		return alumno_rut;
	}

	public void setAlumno_rut(int alumno_rut) {
		this.alumno_rut = alumno_rut;
	}

	public String getAlumno_dv() {
		return alumno_dv;
	}

	public void setAlumno_dv(String alumno_dv) {
		this.alumno_dv = alumno_dv;
	}

	public String getAlumno_nombre() {
		return alumno_nombre;
	}

	public void setAlumno_nombre(String alumno_nombre) {
		this.alumno_nombre = alumno_nombre;
	}

	public String getAlumno_correo() {
		return alumno_correo;
	}

	public void setAlumno_correo(String alumno_correo) {
		this.alumno_correo = alumno_correo;
	}
}
