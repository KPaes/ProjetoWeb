/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import br.com.bean.Mensagem;
import java.security.NoSuchAlgorithmException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.primefaces.context.RequestContext;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

import org.apache.commons.mail.EmailException;

/**
 *
 * @author Karina
 */
public class EmailUtils {

        
 private static final String HOSTNAME = "smtp.gmail.com";
 private static final String USERNAME = "kbyte.tcc";
 private static final String PASSWORD = "empresaTCC";
 private static final String EMAILORIGEM = "kbyte.tcc@gmail.com";
 
 public static Email conectaEmail() throws EmailException {
 Email email = new SimpleEmail();
 email.setHostName(HOSTNAME);
 email.setSmtpPort(587); //465
 email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
 email.setTLS(true);
 email.setFrom(EMAILORIGEM);
 return email;
 }
 
 public static void enviaEmail(Mensagem mensagem) throws EmailException, NoSuchAlgorithmException {
      SSLContext ctx = null;
		try {
			ctx = SSLContext.getInstance("TLS");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			ctx.init(new KeyManager[0], new TrustManager[] {new DefaultTrustManager()}, new SecureRandom());
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SSLContext.setDefault(ctx);
        
 Email email = new SimpleEmail();
 email = conectaEmail();
 email.setSubject(mensagem.getTitulo());
 email.setMsg(mensagem.getMensagemEnviar());
 email.addTo(mensagem.getDestino());
 String resposta = email.send();
 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "E-mail enviado com sucesso para: " + mensagem.getDestino(), "Informação"));
 
 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Email", "Email enviado!");            
        RequestContext.getCurrentInstance().showMessageInDialog(message);
       
 }
   private static class DefaultTrustManager implements X509TrustManager {
 
        @Override
        public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
        }
 
        @Override
        public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
        }
 
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
 
    }
}