package controller;

import dao.DataSource;
import dao.PassageiroDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Passageiro;

/**
 *
 * @author ELITEBOOK
 */
public class PassageiroController {

    private static DataSource dataSource = new DataSource();
    static Passageiro passageiro;

    public static boolean salvarPassageiro(String nome, String apelido, int idade, String contacto, double saldoConta, String nomeUsuario, String palavraPasse) {
        PassageiroDao dao = new PassageiroDao(dataSource);

        passageiro = new Passageiro(saldoConta, nome, apelido, idade, contacto, nomeUsuario, palavraPasse);
        dao.inserir(passageiro);
        System.out.println("inserir");

        return true;

    }
    
    public static void salvarRemovidos(int id, String nome, String apelido, int idade, String contacto, double saldoConta, String nomeUsuario, String palavraPasse) {
        PassageiroDao dao = new PassageiroDao(dataSource);

        passageiro = new Passageiro(saldoConta, nome, apelido, idade, contacto, nomeUsuario, palavraPasse);
        passageiro.setId(id);
        dao.inserirRemovido(passageiro);
        

       

    }

    public static boolean atualizarPassageiro(String nome, String apelido, int idade, String contacto, double saldoConta, String nomeUsuario, String palavraPasse, int id) {
        PassageiroDao dao = new PassageiroDao(dataSource);

        passageiro = new Passageiro();
        passageiro.setNome(nome);
        passageiro.setApelido(apelido);
        passageiro.setIdade(idade);
        passageiro.setContacto(contacto);
        passageiro.setNomeUsuario(nomeUsuario);
        passageiro.setPalavraPasse(palavraPasse);
        passageiro.setId(id);
        dao.atualizar(passageiro);
        System.out.println("atualizado com sucesso");

        return true;

    }

    
    
    
    public static boolean removerPassageiro(int id) {
        PassageiroDao dao = new PassageiroDao(dataSource);

        passageiro = new Passageiro();
        passageiro.setId(id);

        // dao.inserirRemovido(passageiro);
        dao.remover(passageiro);
        System.out.println("removido...");
        return true;

        
    }

    public static boolean login(String nomeUsuario, String palavraPasse) {
        PassageiroDao dao = new PassageiroDao(dataSource);

        if (dao.checkLogin(nomeUsuario, palavraPasse)) {
            return true;
        }

        return false;
    }

    public static void depositar(Passageiro p, double saldo) {
        PassageiroDao dao = new PassageiroDao(dataSource);
        p.setContaSaldo(p.getContaSaldo() + saldo);

        dao.Depositar(p);

    }

    public static void comprarBilhete(Passageiro p, Float v) {
        PassageiroDao dao = new PassageiroDao(dataSource);
        p.setContaSaldo(p.getContaSaldo() - v);

        dao.comprar(p);

    }

    public static List<Passageiro> listaPassageiro() {
        PassageiroDao dao = new PassageiroDao(dataSource);

        List<Passageiro> lista = dao.readAll();

        return lista;
    }
    
      public static List<Passageiro> listaRemovidos() {
        PassageiroDao dao = new PassageiroDao(dataSource);

        List<Passageiro> lista = dao.readAllRemovidos();

        return lista;
    }

    public static List<Passageiro> listaPorNomeUsuario(String usuario) {
        PassageiroDao dao = new PassageiroDao(dataSource);

        List<Passageiro> lista = dao.readbyNomeUsuario(usuario);

        return lista;
    }

    public static boolean verificarUsuatio(String nome) {
        PassageiroDao dao = new PassageiroDao(dataSource);

        boolean usuario = dao.verificarUsuario(nome);

        if (usuario) {
            JOptionPane.showMessageDialog(null, "nome de usuario existente, por favor escolha outro nome");

            return true;
        } else {
            return false;
        }
    }

    public static void mudarSenha(int id, String senhaAtual, String senhaNova, String senhaConfirmada) {
        PassageiroDao dao = new PassageiroDao(dataSource);

        dao.mudarSenha(id, senhaAtual, senhaNova, senhaConfirmada);

    }
    
      public static Integer totPassageiro(){
        PassageiroDao dao = new PassageiroDao(dataSource);
        
        int x = dao.totPassageiros();
        
        return x;
    }
}
