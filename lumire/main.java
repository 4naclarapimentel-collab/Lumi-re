// ==============================
// Classe Main
// ==============================
public class Main {

    public static void main(String[] args) {

        SistemaLumiere sistema = new SistemaLumiere();

        // Cadastro de filmes
        Filme filme1 = new Filme(
                "Interestelar",
                "Ficção Científica",
                169,
                2014
        );

        sistema.cadastrarFilme(filme1);

        // Cadastro de usuário
        Usuario usuario1 = new Usuario(
                "Carlos",
                "carlos@email.com",
                "12345678"
        );

        sistema.cadastrarUsuario(usuario1);

        // Avaliação
        Avaliacao avaliacao1 = new Avaliacao(
                usuario1,
                filme1,
                5,
                "Excelente filme!"
        );

        sistema.adicionarAvaliacao(avaliacao1);

        // Pesquisa
        sistema.pesquisarFilme("Interestelar");
    }
}
