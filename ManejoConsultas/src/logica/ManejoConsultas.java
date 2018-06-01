package logica;

import cableado.IConsultas;
import cableado.IMenuConsultas;

public class ManejoConsultas implements IMenuConsultas{
	
	IConsultas consejero;
	IConsultas estudiante;
	
	@Override
	public IConsultas getConsejero() {
		return consejero;
	}

	@Override
	public IConsultas getEstudiante() {
		return estudiante;
	}

	@Override
	public void mostrarDisponibilidadCupos() {
				
	}

	@Override
	public void mostrarEspaciosAcademicosConsejero() {
		InformacionEspaciosAcademicos infoEs = new InformacionEspaciosAcademicos(consejero);
    	infoEs.crearVentana();		
	}

	@Override
	public void mostrarEspaciosAcademicosEstudiante() {
		
	}

	@Override
	public void mostrarHistorialAcademicoConsejero() {
		
	}

	@Override
	public void mostrarHistorialAcademicoEstudiante() {
		
	}

	@Override
	public void mostrarHorario() {
		Horario horario = new Horario(estudiante);
		horario.crearVentana();
	}

	@Override
	public void mostrarInformacionConsejero() {
		InformacionConsejero info = new InformacionConsejero(consejero);
    	info.crearVentana();
	}

	@Override
	public void mostrarInformacionEstudiante() {
		InformacionEstudiante info = new InformacionEstudiante(estudiante);
		info.crearVentana();
	}

	@Override
	public void mostrarViabilidadConsejero() {
				
	}

	@Override
	public void mostrarViabilidadEstudiante() {
		
	}

	@Override
	public void setConsejero(IConsultas cc) {
		this.consejero=cc;
	}

	@Override
	public void setEstudiante(IConsultas ce) {
		this.estudiante=ce;
		
	}

	@Override
	public String mostrarNombreConsejero() {
		return consejero.consultarNombreConsejero();
	}

	@Override
	public String mostrarNombreEstudiante() {
		return estudiante.consultarNombreEstudiante();
	}

}
