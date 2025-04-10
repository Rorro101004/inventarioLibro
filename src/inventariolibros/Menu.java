/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventariolibros;

import static inventariolibros.BibliotecaLibroInventario.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author roroc
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        crearFichero();
        ArrayList<String> registerLibro = leeInventario();
        initRegisterLibro(registerLibro);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonAgr = new javax.swing.JButton();
        jButtonEdi = new javax.swing.JButton();
        jButtonEli = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 3, 24)); // NOI18N
        jLabel1.setText("Bienvenido al menú para el inventario de Libros");

        jButtonAgr.setText("Agregar Libro");
        jButtonAgr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgrActionPerformed(evt);
            }
        });

        jButtonEdi.setText("Editar Libro");
        jButtonEdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEdiActionPerformed(evt);
            }
        });

        jButtonEli.setText("Eliminar Libro");
        jButtonEli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliActionPerformed(evt);
            }
        });

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonEli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAgr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEdi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButtonAgr)
                .addGap(18, 18, 18)
                .addComponent(jButtonEdi)
                .addGap(18, 18, 18)
                .addComponent(jButtonEli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSalir)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgrActionPerformed
        // TODO add your handling code here:
        Agregar ag = new Agregar(this, true);
        ag.setVisible(true);
    }//GEN-LAST:event_jButtonAgrActionPerformed

    private void jButtonEdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEdiActionPerformed
        ArrayList<String> atributos = leeInventario();
        String isbn = JOptionPane.showInputDialog(this, "Diga el ISBN del libro \n Libros disponibles: \n " + atributos);
        boolean existe = existenciaLibro(isbn);
        Libro libro_temporal = devolverLibro(isbn);
        if (existe) {
            Editar editar =  new Editar(libro_temporal.getISBN(), libro_temporal.getAutor() ,libro_temporal.getTitulo(),libro_temporal.getPrecio(),libro_temporal.getCantidadInventario());
            editar.setVisible(true);
        } else{
            JOptionPane.showMessageDialog(this, "El libro no se puede editar, verifica el ISBN ","",2);
        }
    }//GEN-LAST:event_jButtonEdiActionPerformed

    private void jButtonEliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliActionPerformed
        ArrayList atributos = leeInventario();
        String isbn = JOptionPane.showInputDialog(this, "Diga el ISBN del libro \n Libros disponibles \n: " + atributos);
        boolean existe = existenciaLibro(isbn);
        Libro libro_temporal = devolverLibro(isbn);
        if (existe) {
            eliminarLibro(libro_temporal);
            JOptionPane.showMessageDialog(this, "Se eliminó el libro de ISBN "+ libro_temporal.getISBN());
        }else {
            JOptionPane.showMessageDialog(this, "El libro no se pudo eliminar, verifica el ISBN ","",2);
        }
    }//GEN-LAST:event_jButtonEliActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgr;
    private javax.swing.JButton jButtonEdi;
    private javax.swing.JButton jButtonEli;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
