/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author ELITEBOOK
 */
public class validarCaracteres extends PlainDocument {

    public enum TipoEntrada {
        NUMEROINTEIRO, NUMERODECIMAL, NOME, USUARIO, CONTACTO;
    };

    private int qtdCaracteres;
    private TipoEntrada tipoEntrada;

    public validarCaracteres(int qtdCaracteres, TipoEntrada tipoEntrada) {
        this.qtdCaracteres = qtdCaracteres;
        this.tipoEntrada = tipoEntrada;
    }

    @Override
    public void insertString(int offs, String string, AttributeSet a) throws BadLocationException {

        if (string == null || getLength() == qtdCaracteres) {
            return;
        }
        int totalCarac = getLength() + string.length();
        //filtros de caracteres
        String regex = "";

        switch (tipoEntrada) {
            case NUMEROINTEIRO:
                regex = "[^0-9]";
                break;
            case NUMERODECIMAL:
                regex = "[^0-9,.]";
                break;
            case NOME:
                regex = "[^\\p{IsLatin} ]";
                break;
            case USUARIO:
                regex = "[^0-9\\p{IsLatin}\\-_]";
                break;
            case CONTACTO:
                regex = "[^0-9]";
                break;    
        }
        
        //fazendo a sub
        string = string.replaceAll(regex, "");
        
        if(totalCarac <= qtdCaracteres){
             super.insertString(offs, string, a); //To change body of generated methods, choose Tools | Templates.
        }else{
            String nova = string.substring(0, qtdCaracteres);
            super.insertString(offs, nova, a);
        }
           
        
             
    }

}
