
// Classe Avaliacao
// ==============================
public class Avaliacao {
    private Usuario usuario;
    private Filme filme;
    private int nota;
    private String comentario;

    public Avaliacao(Usuario usuario, Filme filme, int nota, String comentario) {

        if (nota < 1 || nota > 5) {
            throw new IllegalArgumentException("A nota deve ser entre 1 e 5.");
        }

        if (comentario.isEmpty()) {
            throw new IllegalArgumentException("O comentário não pode ser vazio.");
        }

        this.usuario = usuario;
        this.filme = filme;
        this.nota = nota;
        this.comentario = comentario;
    }

    public void exibirAvaliacao() {
        System.out.println(usuario.getEmail() + " avaliou " +
                filme.getTitulo() + " com nota " + nota);

        System.out.println("Comentário: " + comentario);
    }
}
