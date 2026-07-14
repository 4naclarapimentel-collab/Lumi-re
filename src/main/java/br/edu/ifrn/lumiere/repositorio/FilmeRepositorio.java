package br.edu.ifrn.lumiere.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.lumiere.modelo.Filme;

public class FilmeRepositorio {

    private Connection getConnection() throws SQLException {
        return GerenciadorDeConexao.getConnection();
    }

    // [C] - INSERIR (INSERT)
    public void inserir(Filme filme) {
        String sql = "INSERT INTO filme (titulo, genero, duracao_min, ano_lancamento) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, filme.getTitulo());
            stmt.setString(2, filme.getGenero());
            stmt.setInt(3, filme.getDuracaoMin());
            stmt.setInt(4, filme.getAnoLancamento());
            stmt.executeUpdate();

            // Recupera o ID gerado pelo auto_increment do MySQL e guarda no objeto Java
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    filme.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            // Disparada pela UNIQUE (titulo, ano_lancamento) criada no banco -> RF.001
            throw new RuntimeException("Já existe um filme cadastrado com esse título e ano.", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no MySQL", e);
        }
    }

    // [R] - SELECIONAR / LISTAR (SELECT)
    public List<Filme> selecionarTodos() {
        List<Filme> filmes = new ArrayList<>();
        String sql = "SELECT * FROM filme";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Filme filme = new Filme();
                filme.setId(rs.getLong("id"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setGenero(rs.getString("genero"));
                filme.setDuracaoMin(rs.getInt("duracao_min"));
                filme.setAnoLancamento(rs.getInt("ano_lancamento"));
                filmes.add(filme);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao selecionar dados do MySQL", e);
        }
        return filmes;
    }

    // [U] - ATUALIZAR (UPDATE)
    public void atualizar(Filme filme) {
        String sql = "UPDATE filme SET titulo = ?, genero = ?, duracao_min = ?, ano_lancamento = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, filme.getTitulo());
            stmt.setString(2, filme.getGenero());
            stmt.setInt(3, filme.getDuracaoMin());
            stmt.setInt(4, filme.getAnoLancamento());
            stmt.setLong(5, filme.getId());
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("Já existe um filme cadastrado com esse título e ano.", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no MySQL", e);
        }
    }

    // [D] - EXCLUIR (DELETE)
    public void excluir(Long id) {
        String sql = "DELETE FROM filme WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir dados do MySQL", e);
        }
    }

}