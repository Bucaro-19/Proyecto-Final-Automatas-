package graficandoaritmeticas;

import analizadores.Lexico;
import analizadores.Sintactico;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author david
 */
public class Principal extends javax.swing.JFrame {

    
  
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        for(int i =1;i<6;i++){
         Imagen[i] = new ImageIcon(getClass().getResource("/Imagen/graf"+i+".jpg"));
        }
      //  lblimagen.setIcon(Imagen[1]);
    }
     ImageIcon Imagen[]= new ImageIcon[6];
  
    

    java.io.File DER;

    private void abrirArchivo(JFileChooser selectorArchivo) {
        DER = selectorArchivo.getSelectedFile();
        String contenido = "";
        if (!"".equals(getTexto())) {
            try {
                Scanner scn = new Scanner(DER);
                while (scn.hasNext()) {
                    contenido += scn.nextLine() + "\n";
                }
                agregarPestana(DER.getName(), contenido);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            try {
                Scanner scn = new Scanner(DER);
                while (scn.hasNext()) {
                    contenido += scn.nextLine() + "\n";
                }
                setTexto(contenido);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void agregarPestana(String titulo, String contenido) {
        marco.addTab(titulo, new JScrollPane(new JTextArea(contenido)));
    }

    public void probar() {
        JTextArea c = (JTextArea) (((JViewport) (((JScrollPane) marco.getComponentAt(marco.getSelectedIndex())).getViewport()))).getView();
        System.out.println(c.getText());
    }

    private void crearArchivo() {
        try {
            JFileChooser nuevo = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos .rep", "rep");
            nuevo.setFileFilter(filtro);
            nuevo.showSaveDialog(this);
            DER = nuevo.getSelectedFile();
            if (DER != null) {
                try (FileWriter save = new FileWriter(DER + ".rep")) {
                    save.write(getTexto());
                }
                JOptionPane.showMessageDialog(null, "Se a guardado el Archivo correctamente.", "Exito al Guardar", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al guardar el archivo, no se a guardado con exito.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sobreescribirArchivo() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(DER));
            bw.write(getTexto());
            JOptionPane.showMessageDialog(null, "Se a guardado el Archivo correctamente.", "Exito al Guardar", JOptionPane.INFORMATION_MESSAGE);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        consola = new javax.swing.JTextArea();
        marco = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        codigo = new javax.swing.JTextArea();
        lblimagen = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        nuevoArchivo = new javax.swing.JMenuItem();
        abrirArchivo = new javax.swing.JMenuItem();
        guardarArchivo = new javax.swing.JMenuItem();
        informacion = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        botonAnalizar = new javax.swing.JMenuItem();
        btnseleccionar = new javax.swing.JMenuItem();
        btn1 = new javax.swing.JMenuItem();
        btn2 = new javax.swing.JMenuItem();
        btn3 = new javax.swing.JMenuItem();
        btn4 = new javax.swing.JMenuItem();
        btn5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        consola.setEditable(false);
        consola.setBackground(new java.awt.Color(0, 0, 0));
        consola.setColumns(20);
        consola.setForeground(new java.awt.Color(51, 255, 51));
        consola.setRows(5);
        consola.setText("Consola:");
        jScrollPane1.setViewportView(consola);

        codigo.setColumns(20);
        codigo.setRows(5);
        jScrollPane2.setViewportView(codigo);

        marco.addTab("tab1", jScrollPane2);

        lblimagen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        marco.addTab("grafica", lblimagen);

        jMenu1.setText("     Archivo     ");

        nuevoArchivo.setText("Nuevo Archivo");
        nuevoArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(nuevoArchivo);

        abrirArchivo.setText("Abrir Archivo");
        abrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(abrirArchivo);

        guardarArchivo.setText("Guardar");
        guardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(guardarArchivo);

        informacion.setText("Acerca de");
        informacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informacionActionPerformed(evt);
            }
        });
        jMenu1.add(informacion);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jMenu1.add(salir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("     Acciones    ");

        botonAnalizar.setText("Analizar");
        botonAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnalizarActionPerformed(evt);
            }
        });
        jMenu2.add(botonAnalizar);

        btnseleccionar.setText("seleccionar imagen");
        btnseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseleccionarActionPerformed(evt);
            }
        });
        jMenu2.add(btnseleccionar);

        btn1.setText("Expresion (1)");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jMenu2.add(btn1);

        btn2.setText("Expresion (2)");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jMenu2.add(btn2);

        btn3.setText("Expresion (3)");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jMenu2.add(btn3);

        btn4.setText("Expresion (4)");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jMenu2.add(btn4);

        btn5.setText("Expresion (5)");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jMenu2.add(btn5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
                    .addComponent(marco))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(marco, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoArchivoActionPerformed
        // TODO add your handling code here:
        crearArchivo();
    }//GEN-LAST:event_nuevoArchivoActionPerformed

    private void abrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirArchivoActionPerformed
        // TODO add your handling code here:
        JFileChooser selectorArchivo = new JFileChooser();
        selectorArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (selectorArchivo.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            abrirArchivo(selectorArchivo);
        }
    }//GEN-LAST:event_abrirArchivoActionPerformed

    private void guardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarArchivoActionPerformed
        // TODO add your handling code here:
        if (DER != null) {
            int n = JOptionPane.showConfirmDialog(null, "El archivo sera modificado permanentemente, desea continuar?", "Verificacion de Guardado", JOptionPane.YES_NO_OPTION);
            if (true) {
                sobreescribirArchivo();
            }
        } else {
            crearArchivo();
        }
    }//GEN-LAST:event_guardarArchivoActionPerformed

    private void informacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informacionActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_informacionActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        int n = JOptionPane.showConfirmDialog(null, "Desea Cerrar la Aplicacion?", "Salir", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_salirActionPerformed

    String path = System.getProperty("user.dir");

    private ArrayList<String> obtenerficheros(String tipo) {
        ArrayList<String> rutas = new ArrayList();
        File dir = new File(path + "\\src\\" + tipo);
        String[] ficheros = dir.list();
        if (ficheros == null) {
            System.out.println("No hay ficheros en el directorio especificado");
        } else {
            for (String fichero : ficheros) {
                System.out.println("/" + tipo + "/" + fichero);
                rutas.add("/" + tipo + "/" + fichero);
            }
        }
        return rutas;
    }


    private void botonAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnalizarActionPerformed
        // TODO add your handling code here:
        Lexico lexico;
        Sintactico analizar = null;
        try {
            String input = getTexto();
            lexico = new Lexico(new BufferedReader(new StringReader(input)));
            analizar = new Sintactico(lexico);
            try {
                analizar.parse();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }//GEN-LAST:event_botonAnalizarActionPerformed

    private void btnseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseleccionarActionPerformed
      
       
         JFileChooser buscar = new JFileChooser();
         FileNameExtensionFilter extension = new FileNameExtensionFilter("Seleccionar IMAGEN","jpg","png");
         buscar.setFileFilter(extension);
         
         if(buscar.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
         Toolkit tool=Toolkit.getDefaultToolkit();
        String ruta=buscar.getSelectedFile().toString();
        Image imagen=tool.createImage(ruta);
        lblimagen.setIcon(new ImageIcon(imagen.getScaledInstance(lblimagen.getWidth(), lblimagen.getHeight(),Image.SCALE_AREA_AVERAGING)));
         
         
         }
         
        
        
        
        
        
    }//GEN-LAST:event_btnseleccionarActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        
       lblimagen.setIcon(Imagen[1]);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
          lblimagen.setIcon(Imagen[2]);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
          lblimagen.setIcon(Imagen[3]);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
          lblimagen.setIcon(Imagen[4]);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
          lblimagen.setIcon(Imagen[5]);
    }//GEN-LAST:event_btn5ActionPerformed

    private void setTexto(String texto) {
        JTextArea c = (JTextArea) (((JViewport) (((JScrollPane) marco.getComponentAt(marco.getSelectedIndex())).getViewport()))).getView();
        c.setText(texto);
    }

    private String getTexto() {
        JTextArea c = (JTextArea) (((JViewport) (((JScrollPane) marco.getComponentAt(marco.getSelectedIndex())).getViewport()))).getView();
        return c.getText();
    }

    public static void Imprimir(String impresion) {
        consola.setText(consola.getText() + "\n" + impresion);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirArchivo;
    private javax.swing.JMenuItem botonAnalizar;
    private javax.swing.JMenuItem btn1;
    private javax.swing.JMenuItem btn2;
    private javax.swing.JMenuItem btn3;
    private javax.swing.JMenuItem btn4;
    private javax.swing.JMenuItem btn5;
    private javax.swing.JMenuItem btnseleccionar;
    private javax.swing.JTextArea codigo;
    public static javax.swing.JTextArea consola;
    private javax.swing.JMenuItem guardarArchivo;
    private javax.swing.JMenuItem informacion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblimagen;
    private javax.swing.JTabbedPane marco;
    private javax.swing.JMenuItem nuevoArchivo;
    private javax.swing.JMenuItem salir;
    // End of variables declaration//GEN-END:variables
}
