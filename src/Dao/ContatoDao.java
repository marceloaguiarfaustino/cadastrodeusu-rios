package Dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Util.JPAUtil;
import entidades.Contato;

public class ContatoDao {
	
	public static void salvar(Contato c) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Contato c) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void excluir(Contato c) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		c = em.find(Contato.class, c.getId());
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Contato> listar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select c from Contato c");
		List<Contato> lista = q.getResultList();
		em.close();
		return lista;
	}
	
	
}
