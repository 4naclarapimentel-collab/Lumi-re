// ==============================
// Classe Usuario
// ==============================
public class usuario {
    private String nome;
    private String email;
    private String senha;

    public usuario(String nome, String email, String senha) {

        if (senha.length() < 8) {
            throw new IllegalArgumentException("A senha deve possuir no mínimo 8 caracteres.");
        }

        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void exibirUsuario() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
    }
}
