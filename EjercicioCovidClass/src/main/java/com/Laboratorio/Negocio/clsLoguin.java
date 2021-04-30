package com.Laboratorio.Negocio;

import com.Laboratorio.Entidades.Usuarios;
import com.Laboratorio.DAO.ClsUsuario;

public class clsLoguin {
	
	public Usuarios Verificar(String dui) {
		
		Usuarios usu = new Usuarios();
		usu=null;
		ClsUsuario clsusu = new ClsUsuario();
		
		usu=clsusu.BuscarDui(dui);
		if(usu== null) {
			System.out.println("Usuario vacio");
		}
		return usu;
	}
}
