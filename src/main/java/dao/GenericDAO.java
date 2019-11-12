package dao;

import java.util.*;

import javax.persistence.*;

public abstract class GenericDAO<T> {

	private Class klass;
	
	
	public GenericDAO (Class <T> klass) {
		this.klass = klass;
	}
	
	public List<T> find(Class klass, T t) {
		EntityManager em = DatabaseHelper.createEntityManager();
		
		List<T> findT = new ArrayList<>();
		
//		em.find(klass.class, t.getId());
		em.close();
		
		return findT;
	}
	
	public void persist(T t ) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		em.persist(t);
		DatabaseHelper.commitTxAndClose(em);
	}
	
	public void merge(T t ) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		em.merge(t);
		DatabaseHelper.commitTxAndClose(em);
	}
}
