/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import java.util.regex.*; 
/**
 *
 * @author Karina
 */
public class ValidaEmail {
    
public static boolean validaEmail(String email) {
//    System.out.println("Metodo de validacao de email");
    Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
    Matcher m = p.matcher(email); 
    if (m.find()){
//      System.out.println("O email "+email+" e valido");
      return true;
    }
    else{
//      System.out.println("O E-mail "+email+" é inválido!");
      return false;
    }  
 }
}
