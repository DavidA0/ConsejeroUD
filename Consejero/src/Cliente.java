import javax.swing.JOptionPane;

import cableado.ILogin;
import utilidades.Cargador;

public class Cliente {
	public static void main(String args[]) {
		Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
		Class cls = null;
		try {
			cls = cargador.cargarUnaClase(ILogin.class.getName());
			if(cls != null) {
			   ILogin ILogin = (ILogin)cls.newInstance();
			   ILogin.crearVentana();
			}else{
				JOptionPane.showMessageDialog(null, "No se encuentra componente Login");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
    }
}
