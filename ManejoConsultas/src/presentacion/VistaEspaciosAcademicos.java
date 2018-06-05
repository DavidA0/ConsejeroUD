package presentacion;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import cableado.IConsultas;
import cableado.LoginMenu;
import utilidades.Cargador;

public class VistaEspaciosAcademicos extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int ancho, alto;
    
	IConsultas consulta;
	
    public VistaEspaciosAcademicos(IConsultas cons) {
		consulta = cons;
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
        getContentPane().add(txtAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 53, 360, -1));

        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });
        
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

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {
    	if(txtAsignatura.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "No ha digitado ninguna asignatura");
        }else{
	    	if(consulta.comprobarAsignatura(txtAsignatura.getText())==false){
		    	EspaciosAcademicos vista = new EspaciosAcademicos(consulta,txtAsignatura.getText());
		        vista.setVisible(true);
		        dispose();
	    	}else{
	    		JOptionPane.showMessageDialog(null, "No se encuentra la asignatura");
	    	}
        }
    }
    
    
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
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
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtAsignatura;
    // End of variables declaration//GEN-END:variables
}
