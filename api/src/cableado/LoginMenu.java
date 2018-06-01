package cableado;

public interface LoginMenu {
	public void setEstudiante(IConsultas ce);
	public void setConsejero(IConsultas cc);
	public IConsultas getEstudiante();
	public IConsultas getConsejero();
	public void mostrarMenuConsejero();
	public void mostrarMenuEstudiante();
}
