package com.example.cesar.core.dao;



import java.util.List;

import com.example.cesar.core.model.RegistroPesca;


public interface RegistroPescaDao {
	RegistroPesca getById(int id);
	RegistroPesca getByRegistroPesca(String registro);
	void insertar(RegistroPesca registro);
	void actualizar(RegistroPesca registro);
	void borrarPorId(int id);
	void borrarTodos();
	List<RegistroPesca> listarTodos();

}

