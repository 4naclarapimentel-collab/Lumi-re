package br.edu.ifrn.lumiere.servico;

import java.util.List;

import br.edu.ifrn.lumiere.modelo.Filme;
import br.edu.ifrn.lumiere.repositorio.FilmeRepositorio;

/**
 * Classe responsável pelas regras de negócio relacionadas aos Filmes.
 * Implementa as validações descritas nos Critérios de Aceitação da RF.001.
 */
public class FilmeService {

    private final FilmeRepositorio repositorio = new FilmeRepositorio();

    public void cadastrarFilme(Filme filme) {
        if (filme.getTitulo() == null || filme.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro de Regra: O título do filme é obrigatório.");
        }
        if (filme.getGenero() == null || filme.getGenero().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro de Regra: O gênero do filme é obrigatório.");
        }
        if (filme.getDuracaoMin() <= 0) {
            throw new IllegalArgumentException("Erro de Regra: A duração deve ser maior que zero.");
        }
        // Duplicidade de (titulo, anoLancamento) é barrada pela UNIQUE do banco;
        // o FilmeRepositorio traduz esse erro em mensagem legível.
        repositorio.inserir(filme);
    }

    public List<Filme> listarCatalogo() {
        return repositorio.selecionarTodos();
    }

    public void alterarDadosFilme(Filme filme) {
        if (filme.getId() == null) {
            throw new IllegalArgumentException("Erro de Regra: Não é possível atualizar um registro sem ID.");
        }
        if (filme.getDuracaoMin() <= 0) {
            throw new IllegalArgumentException("Erro de Regra: A duração deve ser maior que zero.");
        }
        repositorio.atualizar(filme);
    }

    public void removerFilmeDoCatalogo(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Erro de Regra: ID inválido para exclusão.");
        }
        repositorio.excluir(id);
    }

}