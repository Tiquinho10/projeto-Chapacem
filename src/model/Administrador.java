/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ELITEBOOK
 */
public class Administrador extends Pessoa{
     public Administrador(){
         
     }

    public Administrador(String nome, String apelido, int idade, String contacto, String nomeUsuario, String palavraPasse) {
        super(nome, apelido, idade, contacto, nomeUsuario, palavraPasse);
    }
     
     
    @Override
    public String toString() {
        return super.toString() + "Administrador{" + '}';
    }
    
    
    
}
