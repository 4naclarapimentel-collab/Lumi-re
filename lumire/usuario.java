
    package br.edu.ifrn.lumiere.modelo;

/**
 * Entidade que representa um Usuário da plataforma Lumière.
 * Mapeia diretamente os dados da tabela 'usuario' e abrange o requisito RF.002.
 */
public class Usuario {

    private Long id; // Identificador correspondente à Chave Primária do MySQL
    private String nome;
    private String email;
    private String senha; // Deve armazenar o HASH da senha, nunca texto puro

    public Usuario() {}

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    @Override
    public String toString() {
        // Nunca exibir a senha no toString, mesmo em logs
        return "Usuario{id=" + id + ", nome='" + nome + "', email='" + email + "'}";
    }
}

