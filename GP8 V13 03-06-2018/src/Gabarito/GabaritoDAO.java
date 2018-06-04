/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gabarito;

import java.util.List;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ALCIOMAR
 */
public class GabaritoDAO {

    Session sessao;
    Transaction transacao;

    public void iniciarSessao() {

        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

    }

    public void salvarGabarito(Gabarito gabarito) {
        iniciarSessao();
        sessao.save(gabarito);
        transacao.commit();
        sessao.close();
    }

    public void editarUsuario(Gabarito gabarito) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.update(gabarito);
        transacao.commit();
        sessao.close();
    }

    public void excluirUsuario(Gabarito gabarito) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.delete(gabarito);
        transacao.commit();
        sessao.close();
    }

    public List<Gabarito> listarGabarito() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        List<Gabarito> gabarito = sessao.createCriteria(Gabarito.class).list();
        sessao.close();
        return gabarito;
    }

    public Gabarito pesquisarGabarito(int id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Gabarito gabarito = (Gabarito) sessao.createCriteria(Gabarito.class).add(Restrictions.eq("id", id)).uniqueResult();
        sessao.close();
        return gabarito;
    }

}
