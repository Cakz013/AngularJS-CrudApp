package com.example.cesar.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cesar.core.dao.RegistroPescaDao;
import com.example.cesar.core.model.RegistroPesca;



@Service("registroPescaService")
@Transactional
public class RegistroPescaServiceImpl implements RegistroPescaService {
	@Autowired
	private RegistroPescaDao dao;

	public List<RegistroPesca> listarTodos() {
		return dao.listarTodos();
	}

	public RegistroPesca getById(long id) {
		return dao.getById((int) id);
	}

	public RegistroPesca getByRegistroPesca(String perfil) {
		return dao.getByRegistroPesca(perfil);
	}

	public void guardarRegistroPesca(RegistroPesca perfil) {
		if (perfil.getId() != null)
			dao.insertar(perfil);
		else
			dao.actualizar(perfil);
	}

	public void eliminarRegistroPescaById(int id) {
		dao.borrarPorId(id);
	}

	public void eliminarTodos() {
		dao.borrarTodos();
	}

	@Override
	public boolean isExisteRegistroPesca(RegistroPesca perfil) {
		return getByRegistroPesca(perfil.getNombre_responsable()) != null;
	}




}
