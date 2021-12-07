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
public class Bilhete {
      private Integer id;
      private Passageiro passageiro;
      private float precoD1;
      private float precoD2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public float getPrecoD1() {
        return precoD1;
    }

    public void setPrecoD1(float precoD1) {
        this.precoD1 = precoD1;
    }

    public float getPrecoD2() {
        return precoD2;
    }

    public void setPrecoD2(float precoD2) {
        this.precoD2 = precoD2;
    }

    @Override
    public String toString() {
        return "Bilhete{" + "precoD1=" + precoD1 + ", precoD2=" + precoD2 + '}';
    }
      
      
}
