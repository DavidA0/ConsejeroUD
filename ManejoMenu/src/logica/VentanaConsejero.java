package logica;

import javax.swing.JOptionPane;

import cableado.IConsultas;
import cableado.IMenuConsultas;
import presentacion.MenuConsejero;
import utilidades.Cargador;

public class VentanaConsejero{

	
	IConsultas consejero;
	public VentanaConsejero(IConsultas con) {
		this.consejero=con;
	}
	
	public IConsultas getEstudiante(){
		return consejero;
	}
	
	public void setConsejero(IConsultas con){
		this.consejero=con;
	}
	
    public void crearVentana() {
        MenuConsejero vista = new MenuConsejero(consejero);
        vista.setVisible(true);
    }
    
    public void consultarDisponibilidad(){
    	Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
		Class cls = null;
		try {
			cls = cargador.cargarUnaClase(IMenuConsultas.class.getName());
			if(cls != null) {
				IMenuConsultas IMenuConsultas = (IMenuConsultas)cls.newInstance();
				IMenuConsultas.setConsejero(consejero);
				IMenuConsultas.mostrarDisponibilidadCupos();
			}else{
    			JOptionPane.showMessageDialog(null, "No se encuentra componente ManejoConsultas");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void consultarHistorial(){
    	Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
		Class cls = null;
		try {
			cls = cargador.cargarUnaClase(IMenuConsultas.class.getName());
			if(cls != null) {
				IMenuConsultas IMenuConsultas = (IMenuConsultas)cls.newInstance();
				IMenuConsultas.setConsejero(consejero);
				IMenuConsultas.mostrarHistorialAcademicoConsejero();
			}else{
    			JOptionPane.showMessageDialog(null, "No se encuentra componente ManejoConsultas");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
    	//menu.setConsejero(consejero);
    	//menu.mostrarInformacionConsejero();
    }
    
    public void consultarInformacion(){
    	Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
		Class cls = null;
		try {
			cls = cargador.cargarUnaClase(IMenuConsultas.class.getName());
			if(cls != null) {
				IMenuConsultas IMenuConsultas = (IMenuConsultas)cls.newInstance();
				IMenuConsultas.setConsejero(consejero);
				IMenuConsultas.mostrarInformacionConsejero();
			}else{
    			JOptionPane.showMessageDialog(null, "No se encuentra componente ManejoConsultas");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	//IMenuConsultas menu = new ManejoConsultas();
    	//menu.setConsejero(consejero);
    	//menu.mostrarInformacionConsejero();
    }
    
    public String consultarNombre(){
    	Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
		Class cls = null;
		try {
			cls = cargador.cargarUnaClase(IConsultas.class.getName());
			if(cls != null) {
				IConsultas IConsultas = (IConsultas)cls.newInstance();
				IConsultas.setCodigoConsejero(consejero.getCodigoConsejero());
				return IConsultas.consultarNombreConsejero();
			}else{
    			JOptionPane.showMessageDialog(null, "No se encuentra componente ManejoInfoDB");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	//InformacionConsejero info = new InformacionConsejero(consejero);
    	return " ";
    }
    
    public void consultarEspacios(){
    	Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
		Class cls = null;
		try {
			cls = cargador.cargarUnaClase(IMenuConsultas.class.getName());
			if(cls != null) {
				IMenuConsultas IMenuConsultas = (IMenuConsultas)cls.newInstance();
				IMenuConsultas.setConsejero(consejero);
				IMenuConsultas.mostrarEspaciosAcademicosConsejero();
			}else{
    			JOptionPane.showMessageDialog(null, "No se encuentra componente ManejoConsultas");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	//IMenuConsultas menu = new ManejoConsultas();
    	//menu.setConsejero(consejero);
    	//menu.mostrarEspaciosAcademicosConsejero();
    }
}
