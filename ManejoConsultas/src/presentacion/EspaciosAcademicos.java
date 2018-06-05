package presentacion;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import cableado.IConsultas;
import cableado.LoginMenu;
import utilidades.Cargador;

public class EspaciosAcademicos extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int ancho, alto;
    IConsultas consulta;
	String asignatura;
    DefaultTableModel modelo = new DefaultTableModel();
    
	public EspaciosAcademicos(IConsultas ce, String asig) {
		this.consulta = ce;
		asignatura = asig;
        initComponents();
        preferencias();
        mostrarAsignaturas();
        setResizable(false);
        setLocationRelativeTo(null);
    }

	public void preferencias(){
        setResizable(false);
        setLocationRelativeTo(null);
        ancho = 480;
        alto = 170;
        this.setMinimumSize(new Dimension(ancho,alto)); 
        setTitle("Espacios Academicos");
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
        //((JPanel)getContentPane()).setOpaque(false);
        //ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/papel.jpg"));
        //JLabel fondo= new JLabel();
        //fondo.setIcon(uno);
        //getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        //fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
    }
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTable1.setEnabled(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        modelo.addColumn("Nombre Asignatura");
        modelo.addColumn("Creditos");
        modelo.addColumn("Codigo Asignatura");
        modelo.addColumn("Codigo Grupo");
        modelo.addColumn("Salon");
        modelo.addColumn("Hora inicio");
        modelo.addColumn("Hora final");
        modelo.addColumn("Dia 1");
        modelo.addColumn("Dia 2");
        modelo.addColumn("Dia 3");
        jTable1.setModel(modelo);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 1110, 126));

        btnVolver.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 210, 100, -1));

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel1.setText("Consulta Espacios Academicos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 380, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarAsignaturas(){
    	String[][] datos;
    	datos = consulta.desplegarInformacionAsignaturas(asignatura);
    	for(int j = 0; j<datos.length;j++){
	        datos[j][5]=consultarHora(datos[j][5]);
	        datos[j][6]=consultarHora(datos[j][6]);
	        if(datos[j][7]!=null){
		        datos[j][7]=consultarDia(datos[j][7]);
	        }
	        if(datos[j][8]!=null){
	        	datos[j][8]=consultarDia(datos[j][8]);
	        }
	        if(datos[j][9]!=null){
	        	datos[j][9]=consultarDia(datos[j][9]);
	        }
    	}
    	
    	for(int j = 0; j<datos.length;j++){
	        modelo.addRow(datos[j]);
    	}
    }
    
    public String consultarHora(String hora){
        if(hora.equals("600")){
            return "6:00 am";
        }
        if(hora.equals("800")){
            return "8:00 am";
        }
        if(hora.equals("1000")){
            return "10:00 am";
        }
        if(hora.equals("1200")){
            return "12:00 pm";
        }
        if(hora.equals("1400")){
            return "2:00 pm";
        }
        if(hora.equals("1600")){
            return "4:00 pm";
        }
        if(hora.equals("1800")){
            return "6:00 pm";
        }
        if(hora.equals("2000")){
            return "8:00 pm";
        }
        return null;
    }
    
    public String consultarDia(String horainicio){
        if(horainicio.equals("1")){
            return "Lunes";
        }
        if(horainicio.equals("2")){
            return "Martes";
        }
        if(horainicio.equals("3")){
            return "Miercoles";
        }
        if(horainicio.equals("4")){
            return "Jueves";
        }
        if(horainicio.equals("5")){
            return "Viernes";
        }
        if(horainicio.equals("6")){
            return "Sabado";
        }
        return null;
    }
    
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {
    	Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
		Class cls = null;
		try {                 
			cls = cargador.cargarUnaClase(LoginMenu.class.getName());
			if(cls != null) {
                dispose(); 
                LoginMenu LoginMenu = (LoginMenu)cls.newInstance();
                LoginMenu.setConsejero(consulta);
                LoginMenu.mostrarMenuConsejero();
			}else{
    			JOptionPane.showMessageDialog(null, "No se encuentra componente ManejoMenu");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
