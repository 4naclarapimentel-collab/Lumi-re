// ==============================
// Classe Filme
// ==============================
public class Filme {
    private String titulo;
    private String genero;
    private int duracao;
    private int anoLancamento;

    public Filme(String titulo, String genero, int duracao, int anoLancamento) {
        if (duracao <= 0) {
            throw new IllegalArgumentException("A duração deve ser maior que zero.");
        }

        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void exibirFilme() {
        System.out.println("Título: " + titulo);
        System.out.println("Gênero: " + genero);
        System.out.println("Duração: " + duracao + " min");
        System.out.println("Ano: " + anoLancamento);
    }
}
    

