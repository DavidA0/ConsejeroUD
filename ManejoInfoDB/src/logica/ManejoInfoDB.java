package logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import cableado.IConsultas;

public class ManejoInfoDB implements IConsultas{

	private String consejeroEstudiante;
    private String carrera;
    private int codigoEstudiante;
    private String contrasenaEstudiante;
    Conexion log = new Conexion();
    private String nombreEstudiante;
    private int identificacionEstudiante;
    
    private String nombreConsejero;
    private int identificacionConsejero;
    private int codigoConsejero;
    private String contrasenaConsejero;
    
    public ManejoInfoDB(){
    	conexion();
    }
	
	@Override
	public void conexion() {
		Conexion.establecerConexion();
	}

	@Override
	public String consultarConsejeroEstudiante() {
		String consejero=" ";
        String sql;
        sql="Select C.nombreConsejero from estudiante E, consejero C where E.codigoestudiante='"+getCodigoEstudiante()+"' and C.codigoconsejero = E.codigoconsejero";
        try {
            Statement st = Conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                consejero = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consejero;
	}

	@Override
	public String consultarNombreConsejero() {
		String sql;
        sql="Select nombreconsejero from consejero where codigoconsejero='"+getCodigoConsejero()+"'";
        String nombreConsejero="";
        try {
            Statement st = Conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                nombreConsejero = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombreConsejero;
	}

	@Override
	public String consultarNombreEstudiante() {
		String sql;
        sql="Select nombreestudiante from estudiante where codigoestudiante='"+getCodigoEstudiante()+"'";
        String nombreEstudiante="";
        try {
            Statement st = Conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                nombreEstudiante = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombreEstudiante;
	}

	@Override
	public String consultarSalonAsignadoConsejero() {
		String sql;
        sql="Select salon from consejero where codigoconsejero='"+getCodigoConsejero()+"'";
        String salon= " ";
        try {
            Statement st = Conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                salon = String.valueOf(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salon;
	}

	@Override
	public String[] desplegarInformacionConsejero() {
		String sql;
        sql="Select nombreconsejero, identificacionconsejero from consejero where codigoconsejero='"+getCodigoConsejero()+"'";
        String[] datos = new String[2];
        try {
            Statement st = Conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                nombreConsejero = rs.getString(1);
                identificacionConsejero = Integer.parseInt(rs.getString(2));
                datos[0]=getNombreConsejero();
                datos[1]=String.valueOf(getIdentificacionConsejero());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
	}

	@Override
	public String[] desplegarInformacionEstudiante() {
		String sql;
        sql="Select nombreestudiante, carrera, identificacionestudiante from estudiante where codigoestudiante='"+getCodigoEstudiante()+"'";
        String[] datos = new String[3];
        try {
            Statement st = Conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                nombreEstudiante = rs.getString(1);
                carrera = rs.getString(2);
                identificacionEstudiante = Integer.parseInt(rs.getString(3));
                datos[0]=getNombreEstudiante();
                datos[1]=carrera;
                datos[2]=String.valueOf(getIdentificacionEstudiante());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
	}

	@Override
	public boolean existenciaEstudiante() {
		 try {
	            Statement st = Conexion.getConexion().createStatement();
	            ResultSet rs = st.executeQuery("Select * FROM estudiante where codigoestudiante = '"+getCodigoEstudiante()+"'");
	            if(!rs.next()){
	                return true;
	            }else{
	                return false;
	            }
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return false;
	}

	@Override
	public int getCodigoConsejero() {
		return codigoConsejero;
	}

	@Override
	public int getCodigoEstudiante() {
		return codigoEstudiante;
	}

	@Override
	public String getConsejeroEstudiante() {
		return consejeroEstudiante;
	}

	@Override
	public int getIdentificacionConsejero() {
		return identificacionConsejero;
	}

	@Override
	public int getIdentificacionEstudiante() {
		return identificacionEstudiante;
	}

	@Override
	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	@Override
	public String getNombreConsejero() {
		 return nombreConsejero;
	}

	@Override
	public boolean iniciarSesionConsejero(char[] contra) {
		contrasenaConsejero = new String(contra);
        try {
            Statement st = Conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("Select * FROM consejero where codigoconsejero = '"+getCodigoConsejero()+"' and \"contrasenaConsejero\" = '"+contrasenaConsejero+"'");
            if(!rs.next()){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
	}

	@Override
	public boolean iniciarSesionEstudiante(char[] contra) {
		contrasenaEstudiante = new String(contra);
        try {
            Statement st = Conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery("Select * FROM estudiante where codigoestudiante = '"+getCodigoEstudiante()+"' and \"contrasenaEstudiante\" = '"+contrasenaEstudiante+"'");
            if(!rs.next()){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
	}

	@Override
	public String[][] obtenerInformacionHorarioEstudiante() {
		int i=0;
        String sql;
        sql="Select \"idHorario\" from horario where \"codigoEstudiante\" = '"+getCodigoEstudiante()+"'";
        try {
            Statement st = Conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                i=i+1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[][] datos = new String[i][7];
        i=0;
        sql="Select G.horainicio, G.horafinal,G.salon, G.dia1, G.dia2, G.dia3, A.nombreasignatura from horario H, grupoasignatura G, asignatura A where H.\"codigoEstudiante\"='"+getCodigoEstudiante()+"' and H.idgrupo = G.idgrupo and A.idasignatura=G.idasignatura";
        try {
            Statement st = Conexion.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[i][0]= rs.getString(1);
                datos[i][1]= rs.getString(2);
                datos[i][2]= rs.getString(3);
                datos[i][3]= rs.getString(4);
                datos[i][4]= rs.getString(5);
                datos[i][5]= rs.getString(6);
                datos[i][6]= rs.getString(7);
                i=i+1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
	}

	@Override
	public void setCodigoConsejero(int cod) {
		this.codigoConsejero=cod;		
	}

	@Override
	public void setCodigoEstudiante(int cod) {
		this.codigoEstudiante = cod;
	}

}
