/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import java.util.regex.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 *
 * @author Annapurna
 */
public class FinalChangePassword extends javax.swing.JFrame {

    /**
     * Creates new form FinalChangePassword
     */
    JLabel currentPwLabel;
    JLabel newPwLabel;
    JLabel confirmPwLabel;
    JPasswordField currentPasswordField;
    JPasswordField newPasswordField;
    JPasswordField confirmPasswordField;
    JButton okButton;
    JButton cancelButton;
   // static FinalLoginForm myLogin = new FinalLoginForm();
    static FinalChangePassword change = new FinalChangePassword();
    String currentPassword;
    String newPassword;
    String confirmPassword;
    String userid;
    public FinalChangePassword() {
       // this.userid=user;
       // initComponents();
        super("Change Password");
        setLayout(null);
        currentPwLabel = new JLabel("Current Password: ");
        newPwLabel = new JLabel("New Password: ");
        confirmPwLabel = new JLabel("Confirm Password: ");
        currentPasswordField = new JPasswordField("");
        newPasswordField = new JPasswordField("");
        confirmPasswordField = new JPasswordField("");
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        currentPwLabel.setBounds(30,60,200,35);    currentPasswordField.setBounds(145,60,100,30);
        newPwLabel.setBounds(30,90,100,35);        newPasswordField.setBounds(145,90,100,30);
        confirmPwLabel.setBounds(30,120,200,35);   confirmPasswordField.setBounds(145,120,100,30);
        okButton.setBounds(45,150,100,30);         cancelButton.setBounds(145,150,100,30);

        add(currentPwLabel);
        add(newPwLabel);
        add(confirmPwLabel);
        add(currentPasswordField);
        add(newPasswordField);
        add(confirmPasswordField);
        add(okButton);       
       
         //add(newPwButton);  

        
       // newPwButton.addActionListener(this);
    }
   
    
   
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
}
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
