/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import ventanas.Registro;
import ventanas.Login;

/**
 *
 * @author danie
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Login v1= new Login ();
        Registro v2= new Registro();
        v1.setVisible(true);
    }
    
}
