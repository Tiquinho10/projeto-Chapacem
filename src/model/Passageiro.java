package model;

public class Passageiro extends Pessoa{
        private double contaSaldo;
        
        public Passageiro(){
            
        }

    public Passageiro(double contaSaldo, String nome, String apelido, int idade, String contacto, String nomeUsuario, String palavraPasse) {
        super(nome, apelido, idade, contacto, nomeUsuario, palavraPasse);
        this.contaSaldo = contaSaldo;
    }

        

    public double getContaSaldo() {
        return contaSaldo;
    }

    public void setContaSaldo(double contaSaldo) {
        this.contaSaldo = contaSaldo;
    }

    @Override
    public String toString() {
        return "Nome: " + super.getNome() + " || Nome do Usuario: " + super.getNomeUsuario() +  "  || Saldo atual: " + contaSaldo;
    }
        
        
        
}
