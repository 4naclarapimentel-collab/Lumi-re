package br.edu.ifrn.lumiere.servico;

import java.util.List;

import br.edu.ifrn.lumiere.modelo.Usuario;
import br.edu.ifrn.lumiere.repositorio.UsuarioRepositorio;

/**
 * Classe responsável pelas regras de negócio relacionadas aos Usuários.
 * Implementa as validações descritas nos Critérios de Aceitação da RF.002.
 */
public class UsuarioService {

    private final UsuarioRepositorio repositorio = new UsuarioRepositorio();

    public void cadastrarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro de Regra: O nome é obrigatório.");
        }
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro de Regra: O e-mail é obrigatório.");
        }
        if (usuario.getSenha() == null || usuario.getSenha().length() < 8) {
            throw new IllegalArgumentException("Erro de Regra: A senha deve possuir no mínimo 8 caracteres.");
        }
        // Verifica ANTES de tentar inserir, para dar uma mensagem clara ao usuário
        // (a UNIQUE do banco também protege isso, como segunda barreira de defesa)
        if (repositorio.selecionarPorEmail(usuario.getEmail()) != null) {
            throw new IllegalArgumentException("Erro de Regra: Este e-mail já está cadastrado.");
        }
        repositorio.inserir(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return repositorio.selecionarTodos();
    }

    public void alterarDadosUsuario(Usuario usuario) {
        if (usuario.getId() == null) {
            throw new IllegalArgumentException("Erro de Regra: Não é possível atualizar um registro sem ID.");
        }
        if (usuario.getSenha() == null || usuario.getSenha().length() < 8) {
            throw new IllegalArgumentException("Erro de Regra: A senha deve possuir no mínimo 8 caracteres.");
        }
        repositorio.atualizar(usuario);
    }

    public void removerUsuario(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Erro de Regra: ID inválido para exclusão.");
        }
        repositorio.excluir(id);
    }

}