/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View.JDialog.ScreenCRUDBook;

import Connection.database.connection.SQLiteConnector;
import Controller.BookController;
import Model.Dao.IDao;
import Model.Dao.IDaoBookDatabase;
import Model.entitites.Book;
import Model.valid.ValidBook;
import View.JTableModel.TMBook;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Otavio
 */
public class CrudBook extends javax.swing.JDialog {
    
    private boolean editing;
    private BookController bookController;
    private TMBook tm_book;
    
    /**
     * Creates new form CrudAuthor
     */
    public CrudBook(java.awt.Frame parent, boolean modal , TMBook tm_book) throws SQLException {
        super(parent, modal);
        initComponents();
        
        this.editing = false;
        
        SQLiteConnector sql_connector = new SQLiteConnector("Biblioteca.db");
        IDao bookDao = new IDaoBookDatabase(sql_connector.getConnection());
        
        this.bookController = new BookController(bookDao);
        
        this.tm_book = tm_book;
        
        this.Update_Table();
        
        this.ClearFilds();
        this.EnableFilds(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        lbnCRUDBook = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblCod_Book = new javax.swing.JLabel();
        lblNameBook = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        txtBookCod = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdBook = new javax.swing.JTable();

        jButton4.setText("jButton1");

        jButton6.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbnCRUDBook.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbnCRUDBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbnCRUDBook.setText("Cadastro de Livro");

        lblCod_Book.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCod_Book.setText("COD_Livro:");

        lblNameBook.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNameBook.setText("Nome:");

        lblAuthor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAuthor.setText("Autor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNameBook)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCod_Book)
                        .addGap(46, 46, 46)
                        .addComponent(txtBookCod, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCod_Book)
                    .addComponent(txtBookCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameBook, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAuthor)
                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/novo_32x32.png"))); // NOI18N
        btnNew.setText("Novo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/del_32x32.png"))); // NOI18N
        btnDel.setText("Excluir");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancel_32x32.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/edit3_32x32.png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/save_32x32.png"))); // NOI18N
        btnSave.setText("Salvar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        grdBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Autor"
            }
        ));
        jScrollPane1.setViewportView(grdBook);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbnCRUDBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lbnCRUDBook, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDel, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        this.editing = false;
        
        String Cod_Book_Find = JOptionPane.showInputDialog("Me informe o Codigo do Livro a ser deletado: ");
        
        Book fouded = bookController.Find_Book(Cod_Book_Find);
        
        if (fouded != null) {
            bookController.removeBook(Cod_Book_Find);
            this.Update_Table();
        }else{
            JOptionPane.showMessageDialog(this, "Livro não encontrado !");
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        this.editing = true;
        
        String Cod_Book_Find = JOptionPane.showInputDialog("Informe o Código do livro a ser editado: ");
        
        Book found = bookController.Find_Book(Cod_Book_Find);
        
        if (found != null) {
            this.FillFilds(found);
            this.EnableFildsForEdit();
        }else{
            JOptionPane.showMessageDialog(this, "Autor não encontrado !");
            this.editing = false;
            
            this.ClearFilds();
            this.EnableFilds(false);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        this.editing = false;
        
        this.ClearFilds();
        this.EnableFilds(true);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.editing = false;
        
        this.ClearFilds();
        this.EnableFilds(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        ValidBook valid_book = new ValidBook();
        Book newAuthor = valid_book.validateBook(txtBookCod.getText(), txtName.getText(), txtAuthor.getText());
        
        if(this.editing)
            this.bookController.updateBook(txtBookCod.getText(), newAuthor);
        else{ 
            if (bookController.Find_Book(newAuthor.getCod_book()) != null) 
                JOptionPane.showMessageDialog(this, "O Autor já esta cadastrado !");
            else
                this.bookController.addBook(txtBookCod.getText(), txtName.getText(), txtAuthor.getText());
        }
        this.Update_Table();
        this.editing = false;
        this.ClearFilds();
        this.EnableFilds(false);
    }//GEN-LAST:event_btnSaveActionPerformed

    
    public void ClearFilds(){
        txtAuthor.setText("");
        txtBookCod.setText("");
        txtName.setText("");
    }
    
    public void EnableFilds(Boolean flag){
        txtAuthor.setEnabled(flag);
        txtName.setEnabled(flag);
        txtBookCod.setEnabled(flag);
    }
    
    public void EnableFildsForEdit(){
        txtBookCod.setEnabled(false);
        txtName.setEnabled(true);
        txtAuthor.setEnabled(true);
    }
    
    public void FillFilds(Book A1){
        txtAuthor.setText(A1.getAuthorId());
        txtName.setText(A1.getName());
        txtBookCod.setText(A1.getCod_book());
    }
    
    public void Update_Table(){
        tm_book = new TMBook(bookController.listBooks());
        grdBook.setModel(tm_book);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JTable grdBook;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblCod_Book;
    private javax.swing.JLabel lblNameBook;
    private javax.swing.JLabel lbnCRUDBook;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBookCod;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
