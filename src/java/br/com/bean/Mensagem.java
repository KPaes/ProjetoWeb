package br.com.bean;

/**
 *
 * @author Karina
 */
public class Mensagem {
 
 private String destino="kbyte.tcc@gmail.com";
 private String titulo;
 private String mensagem;
 private String mensagemEnviar;
 private String nome;
 private String emailFulano;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmailFulano() {
        return emailFulano;
    }

    public void setEmailFulano(String emailFulano) {
        this.emailFulano = emailFulano;
    }
 
 
 public String getDestino() {
 return destino;
 }
 
 public void setDestino(String destino) {
 this.destino = destino;
 }
 
 public String getMensagem() {
  // mensagemEnviar = "De: " + nome + "\nEmail: " + emailFulano + "\nAssunto: " + titulo + "\nMensagem: " + mensagem;
 return mensagem;
 }

    public String getMensagemEnviar() {
        return mensagemEnviar = "De: " + nome + "\n\nEmail: " + emailFulano + "\n\nAssunto: " + titulo + "\n\nMensagem: " + mensagem;
    }

    public void setMensagemEnviar(String mensagemEnviar) {
        this.mensagemEnviar = mensagemEnviar;
    }
 
 public void setMensagem(String mensagem) {
 this.mensagem = mensagem;
 }
 
 public String getTitulo() {
 return titulo;
 }
 
 public void setTitulo(String titulo) {
 this.titulo = titulo;
 }
}
