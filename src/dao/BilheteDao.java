/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Bilhete;
import model.Passageiro;

/**
 *
 * @author ELITEBOOK
 */
public class BilheteDao {
    
       private DataSource dataSource;
       
       public BilheteDao(DataSource dataSource){
           this.dataSource = dataSource;
       }
     public void inserir(Bilhete c) {
        String url = "INSERT INTO bilhete(id, nome_Passageiro) values(null, ?)";
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(url);
            ps.setString(1, c.getPassageiro().getNomeUsuario());
          

            ps.executeUpdate();
            ps.close();

           // JOptionPane.showMessageDialog(null, "bilhete Salvo com sucesso");
        } catch (SQLException e) {
            System.err.println("erro ao inserir " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro geral" + e.getMessage());
        }

    }
     
     //select id from bilhete where id=(select max(id) from bilhete);
     
      public Integer readLastId() {
        String url = "select id from bilhete where id=(select max(id) from bilhete)";
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(url);
            ResultSet rs = ps.executeQuery();

           // ArrayList<Bilhete> lista = new ArrayList<Bilhete>();
            
           int lastId = 0;
           
            while (rs.next()) {
                Bilhete bilhete = new Bilhete();
                bilhete.setId(rs.getInt("id"));
              

                lastId =  bilhete.getId();

            }

            ps.close();

            return lastId;

        } catch (SQLException e) {
            System.err.println("erro ao remover " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro geral" + e.getMessage());
        }

        return null;
    }

     public void atualizarPrecario(Bilhete c) {
        String url = "UPDATE precario SET precoD1 = ?, precoD2 = ? WHERE id = 1";
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(url);
            ps.setFloat(1, c.getPrecoD1());
            ps.setFloat(2, c.getPrecoD2());
         

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Precario atualizado com sucesso");
        } catch (SQLException e) {
            System.err.println("erro ao atualizar " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro geral" + e.getMessage());
        }

    } 
     
      public ArrayList<Bilhete> readPrecario() {
        String url = "SELECT * from precario";
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(url);
            ResultSet rs = ps.executeQuery();

            ArrayList<Bilhete> lista = new ArrayList<Bilhete>();
            
           
           
            while (rs.next()) {
                Bilhete bilhete = new Bilhete();
                bilhete.setPrecoD1(rs.getFloat("precoD1"));
                bilhete.setPrecoD2(rs.getFloat("precoD2"));
              

                lista.add(bilhete);

            }

            ps.close();

            return lista;

        } catch (SQLException e) {
            System.err.println("erro ao remover " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro geral" + e.getMessage());
        }

        return null;
    }
    
}
