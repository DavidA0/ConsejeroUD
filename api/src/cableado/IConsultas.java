package cableado;

public interface IConsultas {
	public String getNombreEstudiante();
    public int getIdentificacionEstudiante();
    public boolean iniciarSesionEstudiante(char[] contra);
    public String[][] obtenerInformacionHorarioEstudiante();
    public boolean existenciaEstudiante();
    public String consultarConsejeroEstudiante();
    public int getCodigoEstudiante();
    public String[] desplegarInformacionEstudiante();
    public String getConsejeroEstudiante();
    public void setCodigoEstudiante(int cod);
    public String consultarNombreEstudiante();
    public void conexion();
    
    public String getNombreConsejero();
    public int getIdentificacionConsejero();
    public boolean iniciarSesionConsejero(char[] contra);
    public String consultarSalonAsignadoConsejero();
    public String[] desplegarInformacionConsejero();
    public void setCodigoConsejero(int codigo);
    public int getCodigoConsejero();
    public String consultarNombreConsejero();
}
