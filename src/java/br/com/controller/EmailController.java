/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.bean.Mensagem;
import br.com.util.EmailUtils;
import br.com.util.ValidaEmail;
import java.security.NoSuchAlgorithmException;
import javax.faces.application.FacesMessage;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author Karina
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

@ManagedBean(name="emailController")
@SessionScoped
@ViewScoped 
public class EmailController {
    
 
 private Mensagem mensagem = new Mensagem();
 
 public Mensagem getMensagem() {
 return mensagem;
 }
 public void setMensagem(Mensagem mensagem) {
 this.mensagem = mensagem;
 }
 
 public void enviaEmail() throws EmailException, NoSuchAlgorithmException {
 //try {
     String resultado = "falha";
     if(ValidaEmail.validaEmail(mensagem.getEmailFulano().toString()) == false) {
           resultado = "contato";
          FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Email", "Email inválido!");            
        RequestContext.getCurrentInstance().showMessageInDialog(message);
       
     }else{
        EmailUtils.enviaEmail(mensagem);
 }
 }
 
 public void limpaCampos() {
 mensagem = new Mensagem();
 }
 


    
}
