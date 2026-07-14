// ==============================
// Classe Filme
// ==============================

    package br.edu.ifrn.lumiere.modelo;

/**
 * Entidade que representa um Filme do catálogo Lumière.
 * Mapeia diretamente os dados da tabela 'filme' e abrange o requisito RF.001.
 */
public class Filme {

    private Long id; // Identificador correspondente à Chave Primária do MySQL
    private String titulo;
    private String genero;
    private int duracaoMin;
    private int anoLancamento;

    public Filme() {}

    public Filme(String titulo, String genero, int duracaoMin, int anoLancamento) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracaoMin = duracaoMin;
        this.anoLancamento = anoLancamento;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public int getDuracaoMin() { return duracaoMin; }
    public void setDuracaoMin(int duracaoMin) { this.duracaoMin = duracaoMin; }

    public int getAnoLancamento() { return anoLancamento; }
    public void setAnoLancamento(int anoLancamento) { this.anoLancamento = anoLancamento; }

    @Override
    public String toString() {
        return "Filme{id=" + id + ", titulo='" + titulo + "', genero='" + genero +
               "', duracaoMin=" + duracaoMin + ", anoLancamento=" + anoLancamento + "}";
    }
}
    

