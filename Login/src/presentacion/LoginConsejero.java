package presentacion;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import cableado.IConsultas;
import cableado.ILogin;
import cableado.LoginMenu;
import utilidades.Cargador;

public class LoginConsejero extends javax.swing.JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String codigo,contrasena;    
    private int alto, ancho;
    
    IConsultas consejero;
    
    public LoginConsejero() {
        initComponents();
        ancho = 540;
        alto = 320;
        preferencias();
    }
    
    public void preferencias(){
    	//consejero = new ManejoInfoDB();
        setResizable(false);
        setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(ancho,alto));
        setTitle("Login Consejero");
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/color.jpg"));
        JLabel fondo= new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
    }
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodigo = new javax.swing.JTextField();
        txtPas = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigo.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 220, 30));

        txtPas.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        getContentPane().add(txtPas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 220, 30));

        btnEntrar.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 110, -1));

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Codigo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Clave");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        jButton1.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jButton1.setText("Volver");
        jButton1.setActionCommand("btnVolver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
		Class cls = null;
		try {
			cls = cargador.cargarUnaClase(ILogin.class.getName());
			if(cls != null) {
				dispose();
				ILogin ILogin = (ILogin)cls.newInstance();
				ILogin.crearVentana();
			}else{
				JOptionPane.showMessageDialog(null, "No se encuentra componente Login");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        if(txtCodigo.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "No ha digitado ningun codigo");
        }else{
        	Cargador car = new Cargador("componentes",ClassLoader.getSystemClassLoader());
    		Class clas = null;
    		try {
    			clas = car.cargarUnaClase(IConsultas.class.getName());
    			if(clas != null) {
    				IConsultas IConsultas = (IConsultas)clas.newInstance();
    				consejero = IConsultas;
    	        	consejero.setCodigoConsejero(Integer.parseInt(txtCodigo.getText()));
    	            boolean comprobante = consejero.iniciarSesionConsejero(txtPas.getPassword());
    	            if(comprobante == true){
    	                JOptionPane.showMessageDialog(null, "Compruebe usuario o contraseña");
    	            }else{
    	                Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
    	        		Class cls = null;
    	        		try {                 
    	        			cls = cargador.cargarUnaClase(LoginMenu.class.getName());
    	        			if(cls != null) {
    	                        dispose(); 
    	                        LoginMenu LoginMenu = (LoginMenu)cls.newInstance();
    	                        LoginMenu.setConsejero(consejero);
    	                        LoginMenu.mostrarMenuConsejero();
    	        			}else{
    	            			JOptionPane.showMessageDialog(null, "No se encuentra componente ManejoMenu");
    	        			}
    	        		} catch (Exception e) {
    	        			e.printStackTrace();
    	        		}
    	            }
    			}else{
        			JOptionPane.showMessageDialog(null, "No se encuentra componente ManejoInfoDB");
    			}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char c = evt.getKeyChar();
        if(c<'0'||c>'9') evt.consume();
    }//GEN-LAST:event_txtCodigoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JPasswordField txtPas;
    // End of variables declaration//GEN-END:variables
}
