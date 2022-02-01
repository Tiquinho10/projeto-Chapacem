package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Passageiro;
import view.TelaPrincipalApp;



public class PassageiroDao {

    private DataSource dataSource;

    public PassageiroDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void inserir(Passageiro c) {
        String url = "INSERT INTO passageiro(id, nome, apelido, idade, contacto, contaSaldo, nomeUsuario, palavraPasse) values(null, ?, ?, ?,  ?, ?, ?, ? )";
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(url);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getApelido());
            ps.setInt(3, c.getIdade());
            ps.setString(4, c.getContacto());
            ps.setDouble(5, c.getContaSaldo());
            ps.setString(6, c.getNomeUsuario());
            ps.setString(7, c.getPalavraPasse());

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException e) {
            System.err.println("erro ao inserir " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro geral" + e.getMessage());
        }

    }

    public void inserirRemovido(Passageiro c) {
        String url = "INSERT INTO removidos(id, nome, apelido, idade, contacto, contaSaldo, nomeUsuario, palavraPasse) values(null, ?, ?, ?,  ?, ?, ?, ? )";
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(url);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getApelido());
            ps.setInt(3, c.getIdade());
            ps.setString(4, c.getContacto());
            ps.setDouble(5, c.getContaSaldo());
            ps.setString(6, c.getNomeUsuario());
            ps.setString(7, c.getPalavraPasse());

            ps.executeUpdate();
            ps.close();

            //JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException e) {
            System.err.println("erro ao inserir " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro geral" + e.getMessage());
        }

    }

    public void atualizar(Passageiro c) {
        String url = "UPDATE passageiro SET nome = ?, apelido = ? , idade = ? ,  contacto = ? ,  nomeUsuario = ?, palavraPasse = ? WHERE id = ?";
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(url);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getApelido());
            ps.setInt(3, c.getIdade());
            ps.setString(4, c.getContacto());
            ps.setString(5, c.getNomeUsuario());
            ps.setString(6, c.getPalavraPasse());
            ps.setInt(7, c.getId());

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException e) {
            System.err.println("erro ao atualizar " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro geral" + e.getMessage());
        }

    }

    public void Depositar(Passageiro c) {
        String url = "UPDATE passageiro SET contaSaldo = ? WHERE id = ?";
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(url);

            ps.setDouble(1, c.getContaSaldo());
            ps.setInt(2, c.getId());

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Depositado com sucesso");
        } catch (SQLException e) {
            System.err.println("erro ao depositar " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro geral" + e.getMessage());
        }

    }

    public void comprar(Passageiro c) {
        String url = "UPDATE passageiro SET contaSaldo = ? WHERE id = ?";
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(url);

            ps.setDouble(1, c.getContaSaldo());
            ps.setInt(2, c.getId());

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "compra do bilhete efectuada com sucesso");
        } catch (SQLException e) {
            System.err.println("erro ao comprar " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro geral" + e.getMessage());
        }

    }

    public void remover(Passageiro c) {
        String url = "DELETE FROM passageiro  WHERE id = ?";
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(url);
            ps.setInt(1, c.getId());

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "removido com sucesso");
        } catch (SQLException e) {
            System.err.println("erro ao remover " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro geral" + e.getMessage());
        }

    }

    public ArrayList<Passageiro> readAll() {
        String url = "SELECT * FROM passageiro";
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(url);
            ResultSet rs = ps.executeQuery();

            ArrayList<Passageiro> lista = new ArrayList<Passageiro>();

            while (rs.next()) {
                Passageiro passageiro = new Passageiro();
                passageiro.setId(rs.getInt("id"));
                passageiro.setNome(rs.getString("nome"));
                passageiro.setApelido(rs.getString("apelido"));
                passageiro.setIdade(rs.getInt("idade"));
                passageiro.setContacto(rs.getString("contacto"));
                passageiro.setContaSaldo(rs.getFloat("contaSaldo"));
                passageiro.setNomeUsuario(rs.getString("nomeUsuario"));
                passageiro.setPalavraPasse(rs.getString("palavraPasse"));

                lista.add(passageiro);

            }

            ps.close();

            return lista;

        } catch (SQLException e) {
            System.err.println("erro ao listar " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro geral" + e.getMessage());
        }

        return null;
    }
    
    public ArrayList<Passageiro> readAllRemovidos() {
        String url = "SELECT * FROM removidos";
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(url);
            ResultSet rs = ps.executeQuery();

            ArrayList<Passageiro> lista = new ArrayList<>();

            while (rs.next()) {
                Passageiro passageiro = new Passageiro();
                passageiro.setId(rs.getInt("id"));
                passageiro.setNome(rs.getString("nome"));
                passageiro.setApelido(rs.getString("apelido"));
                passageiro.setIdade(rs.getInt("idade"));
                passageiro.setContacto(rs.getString("contacto"));
                passageiro.setContaSaldo(rs.getFloat("contaSaldo"));
                passageiro.setNomeUsuario(rs.getString("nomeUsuario"));
                passageiro.setPalavraPasse(rs.getString("palavraPasse"));

                lista.add(passageiro);

            }

            ps.close();

            return lista;

        } catch (SQLException e) {
            System.err.println("erro ao listar " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro geral" + e.getMessage());
        }

        return null;
    }
    
     public ArrayList<Passageiro> readbyNomeUsuario(String usuario) {
        String url = "SELECT * FROM passageiro WHERE nomeUsuario LIKE ?";
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(url);
             ps.setString(1, "%"+usuario+"%");
            ResultSet rs = ps.executeQuery();

            ArrayList<Passageiro> lista = new ArrayList<Passageiro>();

            while (rs.next()) {
                Passageiro passageiro = new Passageiro();
                passageiro.setId(rs.getInt("id"));
                passageiro.setNome(rs.getString("nome"));
                passageiro.setApelido(rs.getString("apelido"));
                passageiro.setIdade(rs.getInt("idade"));
                passageiro.setContacto(rs.getString("contacto"));
                passageiro.setContaSaldo(rs.getFloat("contaSaldo"));
                passageiro.setNomeUsuario(rs.getString("nomeUsuario"));
                passageiro.setPalavraPasse(rs.getString("palavraPasse"));

                lista.add(passageiro);

            }

            ps.close();

            return lista;

        } catch (SQLException e) {
            System.err.println("erro ao listar " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro geral" + e.getMessage());
        }

        return null;
    }

      public Integer totPassageiros() {
          int i = 0;
        String url = "SELECT count(*) as qtd_passageiros from passageiro;";
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(url);
            ResultSet rs = ps.executeQuery();

           

            while (rs.next()) {
             
               i = rs.getInt("qtd_passageiros");

             
            }

            ps.close();

            
     return i;
        } catch (SQLException e) {
            System.err.println("erro ao listar " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro geral" + e.getMessage());
        }

       return null;
    }
     
    public boolean verificarUsuario(String nome) {
        String url = "select nomeUsuario from passageiro where nomeUsuario = ?";
        boolean encontrou = false;
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement(url);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Passageiro passageiro = new Passageiro();

                passageiro.setNomeUsuario(rs.getString("nomeUsuario"));

                encontrou = true;

            }

            ps.close();

        } catch (SQLException e) {
            System.err.println("erro ao listar " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro geral" + e.getMessage());
        }

        return encontrou;

    }

    public boolean checkLogin(String login, String senha) {

        boolean check = false;
        try {

            String SQL = "SELECT * FROM passageiro WHERE nomeUsuario = ? and palavraPasse = ? ";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);

            ps.setString(1, login);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Passageiro passageiro = new Passageiro();
                passageiro.setId(rs.getInt("id"));
                passageiro.setNome(rs.getString("nome"));
                passageiro.setApelido(rs.getString("apelido"));
                passageiro.setIdade(rs.getInt("idade"));
                passageiro.setContacto(rs.getString("contacto"));
                passageiro.setContaSaldo(rs.getFloat("contaSaldo"));
                passageiro.setNomeUsuario(rs.getString("nomeUsuario"));
                passageiro.setPalavraPasse(rs.getString("palavraPasse"));

                check = true;

                new TelaPrincipalApp(passageiro).setVisible(true);
            }

            ps.close();

        } catch (SQLException e) {
            System.err.println("erro de conexao " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro de geral " + e.getMessage());
        }

        return check;
    }

    public void mudarSenha(int id, String senhaAtual, String senhaNova, String senhaConfirmada) {

        
        try {

            String SQL = "SELECT * FROM passageiro WHERE id ='" + id + "'";

            String SQL1 = "UPDATE passageiro SET palavraPasse ='" + senhaNova + "' WHERE id ='" + id + "'";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                if (rs.getString("palavraPasse").equals(senhaAtual)) {

                    if (senhaNova.equals(senhaConfirmada)) {

                        ps.executeUpdate(SQL1);
                        JOptionPane.showMessageDialog(null, "Palavra passe alterada cpom sucesso");

                    } else {
                        JOptionPane.showMessageDialog(null, "Palavra Passe nova incorrecta");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Palavra Passe atual  incorrecta");
                }

            }

            ps.close();

        } catch (SQLException e) {
            System.err.println("erro de conexao " + e.getMessage());
        } catch (Exception e) {
            System.err.println("erro de geral " + e.getMessage());
        }

        // return check;
    }

}
