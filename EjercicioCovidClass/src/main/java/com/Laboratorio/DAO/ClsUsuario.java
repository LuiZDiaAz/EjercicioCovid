/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Laboratorio.DAO;

import com.Laboratorio.Conexion.ConexionBd;
import com.Laboratorio.Entidades.Usuarios;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class ClsUsuario {

	ConexionBd cn = new ConexionBd();
    Connection conexion = cn.RetornarConexion();
    
    public Usuarios BuscarDui(String dui) {
    	Usuarios usu = new Usuarios();
    	try {
    		CallableStatement statement = conexion.prepareCall("Call sp_s_usuario(?);");
    		statement.setString("pdui", dui);
    		ResultSet res = statement.executeQuery();
    		while(res.next()) {
    			usu.setIdUsuario(res.getInt("idUsuario"));
    			usu.setNombre(res.getString("nombre"));
    			usu.setDui(res.getString("dui"));
    			usu.setBeneficio(res.getString("beneficio"));
    		}
    	}catch(Exception e){
    		System.out.println("No se encontro el usuario" + e);
    	}
		return usu;
    }
}
