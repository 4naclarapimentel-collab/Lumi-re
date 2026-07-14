package br.edu.ifrn.lumiere.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de Infraestrutura responsável pela gerência da conexão com o serviço MySQL.
 * Única responsabilidade: abrir e entregar uma conexão ativa com o banco lumiere_db.
 */
public class GerenciadorDeConexao {

    // URL apontando diretamente para o banco de dados já existente chamado lumiere_db
    private static final String URL = "jdbc:mysql://localhost:3306/lumiere_db?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";     // Substitua pelo usuário do seu MySQL local
    private static final String PASSWORD = "root"; // Substitua pela senha do seu MySQL local

    /**
     * Abre e retorna uma conexão ativa com o banco de dados.
     * @return java.sql.Connection
     * @throws SQLException Caso o serviço do MySQL esteja desligado ou as credenciais estejam erradas
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}