/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author ALCIOMAR
 */
public class UsuarioDAO {

    Session sessao;
    Transaction transacao;

    public void iniciarSessao() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
    }

    public void salvarUsuario(Usuario usuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.save(usuario);
        transacao.commit();
        sessao.close();
    }

    public void editarUsuario(Usuario usuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.update(usuario);
        transacao.commit();
        sessao.close();
    }

    public void excluirUsuario(Usuario usuario) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.delete(usuario);
        transacao.commit();
        sessao.close();
    }

    public List<Usuario> listarUsuario() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        List<Usuario> usuarios = sessao.createCriteria(Usuario.class).list();
        sessao.close();
        return usuarios;
    }

    public Usuario pesquisarUsuarioId(int id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Usuario usuario = (Usuario) sessao.createCriteria(Usuario.class).add(Restrictions.eq("id", id)).uniqueResult();
        sessao.close();
        return usuario;
    }

    public Usuario autenticarUsuario(String login, String senha, String cargo) {
        iniciarSessao();
        Usuario usuario = (Usuario) sessao.createCriteria(Usuario.class)
                .add(Restrictions.eq("login", login))
                .add(Restrictions.eq("senha", senha))
                .add(Restrictions.eq("cargo", cargo)).uniqueResult();
        sessao.close();
        return usuario;
    }

}
