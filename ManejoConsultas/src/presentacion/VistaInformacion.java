package presentacion;

import cableado.IConsultas;
import cableado.ILogin;
import cableado.LoginMenu;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import logica.InformacionEstudiante;
import utilidades.Cargador;

public class VistaInformacion extends javax.swing.JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ancho, alto;
    
    private int cod;
    
    IConsultas consulta;
    
    public VistaInformacion(int codigo,IConsultas ce) {
    	this.consulta = ce;
        initComponents();
        cod = codigo;
        preferencias();
    }
    
    public void preferencias(){
        mostrarinformacion();
        setResizable(false);
        setLocationRelativeTo(null);
        ancho = 460;
        alto = 170;
        this.setMinimumSize(new Dimension(ancho,alto)); 
        setTitle("Vista Informacion Estudiante");
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

        lblnombre = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblcarrera = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblConsejero = new javax.swing.JLabel();
        lblIdentificacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblnombre.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        getContentPane().add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 36, 380, 30));

        lblCodigo.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        getContentPane().add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 68, 380, 30));

        lblcarrera.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        getContentPane().add(lblcarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 100, 380, 30));

        jButton1.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 120, -1));

        lblConsejero.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        getContentPane().add(lblConsejero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 380, 30));

        lblIdentificacion.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        getContentPane().add(lblIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 380, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
		Class cls = null;
		try {                 
			cls = cargador.cargarUnaClase(LoginMenu.class.getName());
			if(cls != null) {
                dispose(); 
                LoginMenu LoginMenu = (LoginMenu)cls.newInstance();
                LoginMenu.setEstudiante(consulta);
                LoginMenu.mostrarMenuEstudiante();
			}else{
    			JOptionPane.showMessageDialog(null, "No se encuentra componente ManejoMenu");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }//GEN-LAST:event_jButton1ActionPerformed
    public void mostrarinformacion(){
    	InformacionEstudiante info = new InformacionEstudiante(consulta);
        String[] datos = info.mostrarInformacion();
        String consejero = info.mostrarConsejero();
        lblCodigo.setText("Codigo: "+cod);
        lblConsejero.setText("Consejero: "+consejero);
        lblcarrera.setText("Carrera: "+datos[1]);
        lblnombre.setText("Nombre: "+datos[0]);
        lblIdentificacion.setText("Identificacion: "+datos[2]);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblConsejero;
    private javax.swing.JLabel lblIdentificacion;
    private javax.swing.JLabel lblcarrera;
    private javax.swing.JLabel lblnombre;
    // End of variables declaration//GEN-END:variables
}
