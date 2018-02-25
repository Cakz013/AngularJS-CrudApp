package com.example.cesar.core.services;

import java.util.List;

import com.example.cesar.core.model.RegistroPesca;

public interface RegistroPescaService {
	RegistroPesca getById(long id);
	RegistroPesca getByRegistroPesca(String registro);
	void guardarRegistroPesca(RegistroPesca registro);
	void eliminarRegistroPescaById(int id);
	List<RegistroPesca> listarTodos();
	void eliminarTodos();
	boolean isExisteRegistroPesca(RegistroPesca registro);
}
