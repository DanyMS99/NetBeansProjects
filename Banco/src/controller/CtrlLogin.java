/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.corba.se.spi.orbutil.fsm.ActionBase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ventanas.Login;

/**
 *
 * @author danie
 */
public class CtrlLogin implements ActionListener{

    private Login view;

    public CtrlLogin(Login view) {
        this.view = view;
    }
    public void init(){
        this.view.jButton1.addActionListener(this);
        this.view.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if((e.getSource()==this.view.jButton1)){
            
            String  user = this.view.jTextField1.getText();
            String password=  String.valueOf(this.view.jPasswordField1.getPassword());
            
            
        }else if(e.getSource() == this.view.jButton2){
            
        }
    
}
}
