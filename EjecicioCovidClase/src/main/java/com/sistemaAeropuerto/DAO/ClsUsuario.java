package com.sistemaAeropuerto.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sistemaAeropuerto.Conexion.ConexionBd;
import com.sistemaAeropuerto.Entidades.Usuario;

public class ClsUsuario {
	
	ConexionBd cn = new ConexionBd();
    Connection conexion = cn.RetornarConexion();

	public ArrayList<Usuario> mostrar(Usuario p) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {

			CallableStatement call = conexion.prepareCall("call sp_s_usuario(?)");
			call.setString("pdui", p.getDui());
			ResultSet resultado = call.executeQuery();
			while(resultado.next()) {
				Usuario usu = new Usuario();
				usu.setIdUsuario(resultado.getInt("idUsuario"));
				usu.setNombre(resultado.getString("nombre"));
				usu.setDui(resultado.getString("dui"));
				
				lista.add(usu);
				
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return lista;

	}
}
