package com.example.cesar.core.dao.impl;


import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.example.cesar.core.dao.AbstractDao;
import com.example.cesar.core.dao.RegistroPescaDao;
import com.example.cesar.core.model.RegistroPesca;

@Repository("registroPescaDao")
public class RegistroPescaDaoImpl extends AbstractDao<Integer, RegistroPesca> implements RegistroPescaDao {
	@Override
	public RegistroPesca getById(int id) {
		RegistroPesca p = super.getById(id);
		return p;
	}

	@Override
	public void borrarPorId(int id) {
		RegistroPesca p = (RegistroPesca) getEntityManager().createQuery("SELECT p FROM RegistroPesca p WHERE p.id = :id")
				.setParameter("id", id).getSingleResult();
		eliminar(p);
	}
	

	@Override
	public void borrarTodos() {
		getEntityManager().createQuery("DELETE FROM RegistroPesca ").executeUpdate();
	}

	@Override
	public RegistroPesca getByRegistroPesca(String registroPesca) {
		logger.debug("RegistroPesca: " + registroPesca);
		try {
			RegistroPesca p = (RegistroPesca) getEntityManager().createQuery("SELECT p FROM RegistroPesca p WHERE p.nombre_responsable  = :registroPesca")
					.setParameter("registroPesca", registroPesca).getSingleResult();
			return p;
		} catch (NoResultException ex) {
			return null;
		}
	}
	

	@Override
	@SuppressWarnings("unchecked")
	public List<RegistroPesca> listarTodos() {
		List<RegistroPesca> registro = getEntityManager().createQuery("SELECT p FROM RegistroPesca p ORDER BY p.nombre_responsable ASC")
				.getResultList();
		return registro;
	}

	@Override
	public void insertar(RegistroPesca registro) {
		super.persistir(registro);
	}

	@Override
	public void actualizar(RegistroPesca registro) {
		super.actualizar(registro);
	}

	// Una alternativa a Hibernate.initialize()
	protected void initializeCollection(Collection<?> collection) {
		if (collection == null) {
			return;
		}
		collection.iterator().hasNext();
	}
}