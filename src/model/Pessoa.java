package model;

public class Pessoa {
  

        
    private Integer id;
    private String nome;
    private String apelido;
    private int idade;
    private String contacto;
    private String nomeUsuario;
    private String palavraPasse;
    
    public Pessoa(){
        
    }

    public Pessoa(String nome, String apelido, int idade, String contacto, String nomeUsuario, String palavraPasse) {
        this.nome = nome;
        this.apelido = apelido;
        this.idade = idade;
        this.contacto = contacto;
        this.nomeUsuario = nomeUsuario;
        this.palavraPasse = palavraPasse;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getPalavraPasse() {
        return palavraPasse;
    }

    public void setPalavraPasse(String palavraPasse) {
        this.palavraPasse = palavraPasse;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", idade=" + idade + ", contacto=" + contacto + ", nomeUsuario=" + nomeUsuario + ", palavraPasse=" + palavraPasse + '}';
    }
    
    

    
    
}
