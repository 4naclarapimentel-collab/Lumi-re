// ==============================
// Classe SistemaLumiere
// ==============================
import java.util.ArrayList;

public class SistemaLumiere {

    private ArrayList<Filme> filmes = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Avaliacao> avaliacoes = new ArrayList<>();


    // ==========================
    // Cadastro de Filmes
    // ==========================
    public void cadastrarFilme(Filme filme) {

        for (Filme f : filmes) {
            if (f.getTitulo().equalsIgnoreCase(filme.getTitulo())
                    && f.getAnoLancamento() == filme.getAnoLancamento()) {

                System.out.println("Filme já cadastrado.");
                return;
            }
        }

        filmes.add(filme);
        System.out.println("Filme cadastrado com sucesso!");
    }


    // ==========================
    // Cadastro de Usuários
    // ==========================
    public void cadastrarUsuario(Usuario usuario) {

        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(usuario.getEmail())) {
                System.out.println("E-mail já cadastrado.");
                return;
            }
        }

        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }


    // ==========================
    // Avaliação de Filmes
    // ==========================
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
        System.out.println("Avaliação adicionada!");
    }


    // ==========================
    // Pesquisa de Filmes
    // ==========================
    public void pesquisarFilme(String titulo) {

        boolean encontrado = false;

        for (Filme filme : filmes) {

            if (filme.getTitulo().toLowerCase()
                    .contains(titulo.toLowerCase())) {

                filme.exibirFilme();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum filme encontrado.");
        }
    }
}
