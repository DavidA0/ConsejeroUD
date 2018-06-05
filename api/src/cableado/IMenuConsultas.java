package cableado;

public interface IMenuConsultas {
	public IConsultas getConsejero();
	public void setConsejero(IConsultas ce);
	public void mostrarEspaciosAcademicosConsejero();
	public void mostrarDisponibilidadCupos();
	public void mostrarInformacionConsejero();
	public void mostrarHistorialAcademicoConsejero();
	public void mostrarViabilidadConsejero();

	public IConsultas getEstudiante();
	public void setEstudiante(IConsultas ce);
	public void mostrarHorario();
	public void mostrarInformacionEstudiante();
	public void mostrarViabilidadEstudiante();
	public void mostrarHistorialAcademicoEstudiante();

	public String mostrarNombreEstudiante();
	public String mostrarNombreConsejero();
	public void mostrarHistorialConsejero();
}
