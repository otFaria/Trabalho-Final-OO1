/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View.JDialog.ScreenDescribeBook;

import View.JDialog.ScreenCRUDBook.*;
import Connection.database.connection.SQLiteConnector;
import Controller.BookController;
import Model.Dao.IDao;
import Model.Dao.IDaoBookDatabase;
import Model.entitites.Book;
import Model.valid.ValidBook;
import View.JTableModel.TMBook;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Otavio
 */
public class JDlgDescribeBook extends javax.swing.JDialog {
    
    private boolean editing;
    private BookController bookController;
    private TMBook tm_book;
    
    public static final String API_KEY = "AIzaSyCdiHFAggbETmwQwKoqhzijlKa7IP0d18E";
    
    /**
     * Creates new form CrudAuthor
     */
    public JDlgDescribeBook(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        
        this.editing = false;
        
        SQLiteConnector sql_connector = new SQLiteConnector("Biblioteca.db");
        IDao bookDao = new IDaoBookDatabase(sql_connector.getConnection());
        
        this.bookController = new BookController(bookDao);
        
//        this.tm_book = tm_book;
//        
//        this.Update_Table();
//        
//        this.ClearFilds();
//        this.EnableFilds(false);
    }
    
    private String gerarInformacoesLivro(String nameBook) throws Exception {
        // URL da API com a chave da API
        String apiUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + API_KEY;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        // Corpo da requisição JSON
        String jsonInputString = "{"
            + "\"contents\": [{"
            + "\"parts\": [{"
            + "\"text\": \"Descreva o livro com o nome " + nameBook + "\""
            + "}]"
            + "}]"
            + "}";

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        //Reponse of API
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine;

            while ((responseLine = in.readLine()) != null) {
                response.append(responseLine.trim());
            }
            in.close();

            // Retorna o conteúdo da resposta (o texto gerado pela API)
            return response.toString();
        } else {
            throw new Exception("Falha na geração de texto: " + responseCode);
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

        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        lbnCRUDBook = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtArea = new javax.swing.JTextArea();
        btnCancel = new javax.swing.JButton();

        jButton4.setText("jButton1");

        jButton6.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbnCRUDBook.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbnCRUDBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbnCRUDBook.setText("Descriç�o de Livro");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/search.png"))); // NOI18N
        btnBuscar.setText("Buscar informaç�es do livro");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        jTxtArea.setColumns(20);
        jTxtArea.setRows(5);
        jScrollPane1.setViewportView(jTxtArea);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancel_32x32.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbnCRUDBook, javax.swing.GroupLayout.DEFAULT_SIZE, 1089, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel)
                .addGap(359, 359, 359))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lbnCRUDBook, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        String Cod_Book_Find = JOptionPane.showInputDialog("Informe o código do livro:");
        Book bookFound = this.bookController.Find_Book(Cod_Book_Find);
        
        if (Cod_Book_Find != null && !Cod_Book_Find.isEmpty()) {
            try {
                // Requisição para a API de geração de texto
                String geracaoTexto = gerarInformacoesLivro(bookFound.getName());
                
                // Exibe o texto gerado na JTextArea
                jTxtArea.setText(geracaoTexto);
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao gerar texto sobre o livro", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "O código do livro não pode estar vazio", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelMouseClicked

    
//    public void ClearFilds(){
//        txtAuthor.setText("");
//        txtBookCod.setText("");
//        txtName.setText("");
//    }
//    
//    public void EnableFilds(Boolean flag){
//        txtAuthor.setEnabled(flag);
//        txtName.setEnabled(flag);
//        txtBookCod.setEnabled(flag);
//    }
//    
//    public void EnableFildsForEdit(){
//        txtBookCod.setEnabled(false);
//        txtName.setEnabled(true);
//        txtAuthor.setEnabled(true);
//    }
//    
//    public void FillFilds(Book A1){
//        txtAuthor.setText(A1.getAuthorId());
//        txtName.setText(A1.getName());
//        txtBookCod.setText(A1.getCod_book());
//    }
//    
//    public void Update_Table(){
//        tm_book = new TMBook(bookController.listBooks());
//        grdBook.setModel(tm_book);
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTxtArea;
    private javax.swing.JLabel lbnCRUDBook;
    // End of variables declaration//GEN-END:variables
}
