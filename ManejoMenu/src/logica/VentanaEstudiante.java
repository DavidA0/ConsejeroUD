package logica;

import javax.swing.JOptionPane;

import cableado.IConsultas;
import cableado.IMenuConsultas;
import presentacion.MenuEstudiante;
import utilidades.Cargador;

public class VentanaEstudiante{

	IConsultas estudiante;
	
	public VentanaEstudiante(IConsultas cones) {
		this.estudiante=cones;
	}
	
	public IConsultas getEstudiante(){
		return estudiante;
	}
	
	public void setEstudiante(IConsultas est){
		this.estudiante=est;
	}
	
    public void crearVentana() {
        MenuEstudiante vista = new MenuEstudiante(estudiante);
        vista.setVisible(true);
    }
    
    public boolean comprobacionMenuConsultas(){
    	Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
		Class cls = null;
		try {
			cls = cargador.cargarUnaClase(IMenuConsultas.class.getName());
			if(cls != null) {
				return true;
			}else{
    			return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
    	//IMenuConsultas menu = new ManejoConsultas();
    	//menu.setEstudiante(estudiante);
    	//menu.mostrarHorario();
    }
    
    public void consultarHorario(){
    	Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
		Class cls = null;
		try {
			cls = cargador.cargarUnaClase(IMenuConsultas.class.getName());
			if(cls != null) {
				IMenuConsultas IMenuConsultas = (IMenuConsultas)cls.newInstance();
				IMenuConsultas.setEstudiante(estudiante);
				IMenuConsultas.mostrarHorario();
			}else{
    			JOptionPane.showMessageDialog(null, "No se encuentra componente ManejoConsultas");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	//IMenuConsultas menu = new ManejoConsultas();
    	//menu.setEstudiante(estudiante);
    	//menu.mostrarHorario();
    }
    
    public void consultarInformacion(){
    	Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
		Class cls = null;
		try {
			cls = cargador.cargarUnaClase(IMenuConsultas.class.getName());
			if(cls != null) {
				IMenuConsultas IMenuConsultas = (IMenuConsultas)cls.newInstance();
				IMenuConsultas.setEstudiante(estudiante);
				IMenuConsultas.mostrarInformacionEstudiante();
			}else{
    			JOptionPane.showMessageDialog(null, "No se encuentra componente ManejoConsultas");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	//IMenuConsultas menu = new ManejoConsultas();
    	//menu.setEstudiante(estudiante);
    	//menu.mostrarInformacionEstudiante();
    }
    
    public String consultarNombre(){
    	Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
		Class cls = null;
		try {
			cls = cargador.cargarUnaClase(IConsultas.class.getName());
			if(cls != null) {
				IConsultas IConsultas = (IConsultas)cls.newInstance();
				IConsultas.setCodigoEstudiante(estudiante.getCodigoEstudiante());
				return IConsultas.consultarNombreEstudiante();
			}else{
    			JOptionPane.showMessageDialog(null, "No se encuentra componente ManejoConsultas");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	//InformacionConsejero info = new InformacionConsejero(consejero);
    	return " ";
    	//InformacionEstudiante info = new InformacionEstudiante(getEstudiante());
    	//return info.mostrarNombre();
    }
}
