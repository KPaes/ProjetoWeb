/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

/**
 *
 * @author Karina
 */
import java.io.InputStream;  
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;  
import javax.servlet.ServletContext;  
  
import org.primefaces.model.DefaultStreamedContent;  
import org.primefaces.model.StreamedContent;  
  
@ManagedBean(name="fileDownloadController")
@SessionScoped
@ViewScoped 
public class FileDownloadController {  
  
    private StreamedContent file;  
      
    public FileDownloadController() {          
        InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/img/Tabela.jpg");  
        file = new DefaultStreamedContent(stream, "image/jpg", "Tabela.jpg");  
    }  
  
    public StreamedContent getFile() {  
        return file;  
    }    
}  