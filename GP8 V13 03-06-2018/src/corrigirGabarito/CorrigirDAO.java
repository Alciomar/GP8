/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corrigirGabarito;

import java.util.List;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ALCIOMAR
 */
public class CorrigirDAO {

    Session sessao;
    Transaction transacao;

    public void iniciarSessao() {

        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();

    }

    public void salvarCorrigirGabarito(CorrigirGabarito corrigir) {
        iniciarSessao();
        sessao.save(corrigir);
        transacao.commit();
        sessao.close();
    }

    public void editarCorrigirGabarito(CorrigirGabarito corrigir) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.update(corrigir);
        transacao.commit();
        sessao.close();
    }

    public void excluirCorrigirGabarito(CorrigirGabarito corrigir) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.delete(corrigir);
        transacao.commit();
        sessao.close();
    }

    public List<CorrigirGabarito> listarCorrigirGabarito() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        List<CorrigirGabarito> corrigirGabaritos = sessao.createCriteria(CorrigirGabarito.class).list();
        sessao.close();
        return corrigirGabaritos;
    }

    public CorrigirGabarito pesquisarCorrigirGabarito(int id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        CorrigirGabarito corrigir = (CorrigirGabarito) sessao.createCriteria(CorrigirGabarito.class).add(Restrictions.eq("id", id)).uniqueResult();
        sessao.close();
        return corrigir;
    }

    public List<CorrigirGabarito> listarTodosOsGabaritosDigitados(int id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        List<CorrigirGabarito> corrigir = sessao.createCriteria(CorrigirGabarito.class).add(Restrictions.eq("gabarito.id", id)).list();
        sessao.close();
        return corrigir;
    }

}
