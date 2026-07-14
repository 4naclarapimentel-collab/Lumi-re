package br.edu.ifrn;

import br.edu.ifrn.lumiere.modelo.Filme;
import br.edu.ifrn.lumiere.modelo.Usuario;
import br.edu.ifrn.lumiere.servico.FilmeService;
import br.edu.ifrn.lumiere.servico.UsuarioService;

public class Main {
    public static void main(String[] args) {
        FilmeService filmeService = new FilmeService();
        UsuarioService usuarioService = new UsuarioService();

        System.out.println("\n--- [C] - CADASTRANDO Filmes no MySQL (RF.001) ---");
        Filme filme1 = new Filme("Matrix", "Ficção Científica", 136, 1999);
        Filme filme2 = new Filme("Cidade de Deus", "Drama", 130, 2002);

        filmeService.cadastrarFilme(filme1);
        filmeService.cadastrarFilme(filme2);

        System.out.println("\n--- [R] - LISTANDO Catálogo de Filmes ---");
        filmeService.listarCatalogo().forEach(System.out::println);

        System.out.println("\n--- [U] - ATUALIZANDO Filme ---");
        filme1.setGenero("Ficção Científica / Ação");
        filmeService.alterarDadosFilme(filme1);
        filmeService.listarCatalogo().forEach(System.out::println);

        System.out.println("\n--- [D] - EXCLUINDO Filme ---");
        filmeService.removerFilmeDoCatalogo(filme2.getId());
        filmeService.listarCatalogo().forEach(System.out::println);

        System.out.println("\n--- [C] - CADASTRANDO Usuário no MySQL (RF.002) ---");
        Usuario usuario1 = new Usuario("Maria Silva", "maria@email.com", "senha1234");
        usuarioService.cadastrarUsuario(usuario1);

        System.out.println("\n--- [R] - LISTANDO Usuários ---");
        usuarioService.listarUsuarios().forEach(System.out::println);

        System.out.println("\n--- [Regra] - Tentando cadastrar e-mail duplicado (deve falhar) ---");
        try {
            Usuario usuario2 = new Usuario("Outra Pessoa", "maria@email.com", "outrasenha1");
            usuarioService.cadastrarUsuario(usuario2);
        } catch (IllegalArgumentException e) {
            System.out.println("Bloqueado com sucesso: " + e.getMessage());
        }
    }
}