package presentacion;

import java.awt.Dimension;
import javax.swing.ImageIcon;

public class VistaEspaciosAcademicos extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ancho, alto;
    
    public VistaEspaciosAcademicos() {
        initComponents();
        preferencias();
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

        txtAsignatura = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        btnConsulta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAsignatura.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        txtAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAsignaturaActionPerformed(evt);
            }
        });
        getContentPane().add(txtAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 53, 360, -1));

        btnVolver.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 160, -1));

        btnConsulta.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnConsulta.setText("Consultar");
        getContentPane().add(btnConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 160, -1));

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel1.setText("Asignatura");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 19, 110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAsignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAsignaturaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtAsignatura;
    // End of variables declaration//GEN-END:variables
}
