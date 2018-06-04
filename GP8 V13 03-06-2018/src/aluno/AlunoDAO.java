/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aluno;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author ALCIOMAR
 */
public class AlunoDAO {

    Session sessao;
    Transaction transacao;

    public void iniciarSessao() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
    }

    public void salvarAluno(Aluno aluno) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.save(aluno);
        transacao.commit();
        sessao.close();
    }

    public void editarAluno(Aluno aluno) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.update(aluno);
        transacao.commit();
        sessao.close();
    }

    public void excluirAluno(Aluno aluno) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.delete(aluno);
        transacao.commit();
        sessao.close();
    }

    public List<Aluno> listarAluno() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        List<Aluno> alunos = sessao.createCriteria(Aluno.class).list();
        sessao.close();
        return alunos;
    }

    public Aluno pesquisarAlunoId(int id) {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Aluno aluno = (Aluno) sessao.createCriteria(Aluno.class).add(Restrictions.eq("id", id)).uniqueResult();
        sessao.close();
        return aluno;
    }

}
