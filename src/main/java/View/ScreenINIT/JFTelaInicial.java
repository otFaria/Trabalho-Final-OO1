/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.ScreenINIT;

import Connection.database.connection.SQLiteConnector;
import Model.Dao.IDao;
import Model.Dao.IDaoAuthorDatabase;
import View.JDialog.ScreenCRUDAuthor.CrudAuthor;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

/**
 *
 * @author Otavio
 */
public class JFTelaInicial extends javax.swing.JFrame {

    private IDao dao_author;
    private SQLiteConnector connection;
    
    public JFTelaInicial(String dbName) throws SQLException {
        initComponents();
<<<<<<< HEAD
        this.connection = new SQLiteConnector(dbName);
        this.dao_author = new IDaoAuthorDatabase(connection.getConnection());
=======
        this.connection = new SQLiteConnector("Biblioteca.sqlite");
        this.dao_author = new IDaoAuthorDatabase((Connection) connection);
>>>>>>> d0557e5a6e0eb0c06e4f68aca063915f200388a3
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGerenciarBiblioteca = new javax.swing.JLabel();
        pnButton = new javax.swing.JPanel();
        btnAuthor = new javax.swing.JButton();
        btnBook = new javax.swing.JButton();
        btnLibrary = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblGerenciarBiblioteca.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblGerenciarBiblioteca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGerenciarBiblioteca.setText("Gerenciar Biblioteca");

        btnAuthor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAuthor.setText("Autor");
        btnAuthor.setToolTipText("");
        btnAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuthorActionPerformed(evt);
            }
        });

        btnBook.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBook.setText("Livro");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        btnLibrary.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLibrary.setText("Biblioteca");
        btnLibrary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibraryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnButtonLayout = new javax.swing.GroupLayout(pnButton);
        pnButton.setLayout(pnButtonLayout);
        pnButtonLayout.setHorizontalGroup(
            pnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnButtonLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btnAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addGap(79, 79, 79)
                .addComponent(btnBook, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addGap(89, 89, 89)
                .addComponent(btnLibrary, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addGap(86, 86, 86))
        );
        pnButtonLayout.setVerticalGroup(
            pnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnButtonLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(pnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(195, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGerenciarBiblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblGerenciarBiblioteca)
                .addGap(138, 138, 138)
                .addComponent(pnButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuthorActionPerformed
        JDialog screenCrudAuthor = null;
        try {
            screenCrudAuthor = new CrudAuthor(this, true);
        } catch (SQLException ex) {
            Logger.getLogger(JFTelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        screenCrudAuthor.setVisible(true);
    }//GEN-LAST:event_btnAuthorActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        CrudAuthor screenCrudBook = null;
        try {
            screenCrudBook = new CrudAuthor(this, true);
        } catch (SQLException ex) {
            Logger.getLogger(JFTelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        screenCrudBook.setVisible(true);
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnLibraryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibraryActionPerformed
       
    }//GEN-LAST:event_btnLibraryActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAuthor;
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnLibrary;
    private javax.swing.JLabel lblGerenciarBiblioteca;
    private javax.swing.JPanel pnButton;
    // End of variables declaration//GEN-END:variables
}
