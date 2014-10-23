/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sols.View;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import sols.DAO.QuestionDAO;
import sols.Util.SQLHelper;
import static sols.View.AddQuestionFib.driver;
import static sols.View.AddQuestionFib.password;
import static sols.View.AddQuestionFib.url;
import static sols.View.AddQuestionFib.user;
import sun.security.krb5.Config;

/**
 *
 * @author ryzal_000
 */
public class EditQuestionFIB extends javax.swing.JFrame {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    private String sql1;
    private String sql2;
     
    public static String url;
    public static String user;
    public static String password;
    public static String driver;
   
    public String questionID;
    
    public String question = "";
    
    private String hlanswer;
    private String hlanswer2;
    private String instructions;
    private String tempQuestion;
    private String tempAnswer;

    private QuestionDAO questionDAO;

    int counter = 0;
    
    /**
     * Creates new form EditFIBQuestion
     */
    public EditQuestionFIB() {
        initComponents();
    }
    

    public void startSQL() {
        try {

            InputStream in = this.getClass().getResourceAsStream("/sols/Util/jdbc.properties");
            Properties pp = new Properties();
            pp.load(in);
            url = pp.getProperty("jdbc.url");
            user = pp.getProperty("jdbc.username");
            password = pp.getProperty("jdbc.password");
            driver = pp.getProperty("jdbc.driver");

        } catch (IOException ex) {
            Logger.getLogger(SQLHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void connectDb() {
        startSQL(); 
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, user, password);
            
            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
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

        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        instructionField = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionField = new javax.swing.JTextArea();
        addBlankBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MELT - Edit FIB Question");

        jLabel3.setText("Write the question's instructions in the following field:");

        instructionField.setColumns(20);
        instructionField.setRows(3);
        instructionField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                instructionFieldMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(instructionField);

        jLabel1.setText("Write the question in the following field:");

        questionField.setColumns(20);
        questionField.setRows(5);
        questionField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                questionFieldMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(questionField);

        addBlankBtn.setText("Add a Blank");
        addBlankBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBlankBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("CANCEL");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addBlankBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addBlankBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn)
                    .addComponent(cancelBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void instructionFieldMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instructionFieldMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_instructionFieldMouseReleased

    private void questionFieldMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionFieldMouseReleased

    }//GEN-LAST:event_questionFieldMouseReleased

    private void addBlankBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBlankBtnActionPerformed
        try {

            question = questionField.getText();
            instructions = instructionField.getText();

            hlanswer = questionField.getSelectedText();
            hlanswer2="[" +hlanswer+ "]";

            int start = questionField.getText().indexOf(hlanswer);

            if (start >= 0 && hlanswer.length() > 0) {
                questionField.replaceRange(hlanswer2, start,start + hlanswer.length() );
            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }//GEN-LAST:event_addBlankBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed

        question = questionField.getText();
        instructions = instructionField.getText();

        // set the match patter of "[]"
        Matcher matcher = Pattern.compile("\\[([^\\]]+)").matcher(question);

        ArrayList<String> answers = new ArrayList<String>();

        int pos = -1;
        while (matcher.find(pos+1)){
            pos = matcher.start();
            // Add the matched word to the Arraylist
            answers.add(matcher.group(1));
        }

        // Find the word with bracket and replace it with blank
        String newQuestion = question.replaceAll("\\[.*?]", "_____");

        //System.out.println(answers);
        System.out.println(newQuestion);

        int key = 0;

        try {
            connectDb();

            int QType_ID = 2;

            int errors = 0;
            
            // Update the question table
            sql1 = "UPDATE fib SET QuestionText='"+question+"',QuestionBlank='"+newQuestion+"', Instructions='"+instructions+"' WHERE QuestionID='"+questionID+"' ";
            int rows = st.executeUpdate(sql1);
            if(rows == 0) {
                errors++;
            }
            
            //System.out.println(sql1);

            // Delete all the answers
            String deleteAnswer = "DELETE FROM fibanswer WHERE QuestionID='"+questionID+"'";
            int rows2 = st.executeUpdate(deleteAnswer);
            if(rows2 == 0) {
                errors++;
            }
            
            if (errors == 0) {
                JOptionPane.showMessageDialog(null, "Question was successfully updated!");
            } else {
                 JOptionPane.showMessageDialog(null, "ERROR in updating question!!", "error", JOptionPane.ERROR_MESSAGE);
            }
            
            //System.out.println(deleteAnswer);
 
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
 
        // Loop through ArrayList and Insert NEW Answers into DB
        for (String answer : answers) {

            try {
                connectDb();

                
                // Insert answer to DB
                sql2 = "INSERT INTO fibanswer (AnswerContentText,QuestionID) VALUES('"+answer+"', '"+questionID+"')";
                st.executeUpdate(sql2);

                System.out.println(sql2);

            }
            catch (Exception exc) {
                exc.printStackTrace();
            }

        }


    }//GEN-LAST:event_updateBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

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
            java.util.logging.Logger.getLogger(EditQuestionFIB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditQuestionFIB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditQuestionFIB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditQuestionFIB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditQuestionFIB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBlankBtn;
    private javax.swing.JButton cancelBtn;
    public javax.swing.JTextArea instructionField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTextArea questionField;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
