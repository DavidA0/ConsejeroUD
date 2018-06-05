package presentacion;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import cableado.IConsultas;
import cableado.LoginMenu;
import logica.Horario;
import utilidades.Cargador;

/**
 *
 * @author David
 */
public class VistaViabilidadEstudiante extends javax.swing.JFrame {

    int alto,ancho;
    IConsultas estudiante;
    javax.swing.JTable tablaHorario;
    String asignatura,grupo;
    public VistaViabilidadEstudiante(IConsultas est, javax.swing.JTable tabla,String asig, String gru) {
    	asignatura = asig;
    	grupo = gru;
    	tablaHorario = tabla;
    	estudiante = est;
        initComponents();
        preferencias();
        mostrarHorario();
    }
    public void preferencias(){
        setResizable(false);
        setLocationRelativeTo(null);
        ancho = 1160;
        alto = 280;
        this.setMinimumSize(new Dimension(ancho,alto)); 
        setTitle("Viabilidad de "+asignatura+" grupo "+grupo);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
        //((JPanel)getContentPane()).setOpaque(false);
        //ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/papel.jpg"));
        //JLabel fondo= new JLabel();
        //fondo.setIcon(uno);
        //getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        //fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
    }   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        //btnVolver = new javax.swing.JButton();
        //tablaHorario = new javax.swing.JTable();
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel1.setText("Viabilidad");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        /*btnVolver.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 260, -1, -1));*/

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarHorario(){
    	JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setViewportView(tablaHorario);
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1110, 160));
    }
    
    /*private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
    	Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
		Class cls = null;
		try {                 
			cls = cargador.cargarUnaClase(LoginMenu.class.getName());
			if(cls != null) {
                dispose(); 
                LoginMenu LoginMenu = (LoginMenu)cls.newInstance();
                LoginMenu.setEstudiante(estudiante);
                LoginMenu.mostrarMenuEstudiante();
			}else{
    			JOptionPane.showMessageDialog(null, "No se encuentra componente ManejoMenu");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }//GEN-LAST:event_btnVolverActionPerformed*/
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
   // private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
