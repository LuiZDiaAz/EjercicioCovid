package com.sistemaAeropuerto.Controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistemaAeropuerto.Entidades.Usuario;
import com.sistemaAeropuerto.DAO.ClsUsuario;

/**
 * Servlet implementation class ControllerAcceso
 */
public class ControllerAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAcceso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String dui = request.getParameter("DUI");
		
		if (dui.length() == 10) {
			Usuario usu = new Usuario();
			usu.setDui(dui);
			ClsUsuario cls = new ClsUsuario();
			ArrayList<Usuario> lista = cls.mostrar(usu);
			if (lista.size() == 1) {
				for (var i : lista) {
					request.getSession().setAttribute("Nombre", i.getNombre());
					request.getSession().setAttribute("Dui", i.getDui());
					request.getSession().setAttribute("Consulta","Consulta");
				}
				response.sendRedirect("Beneficiado.jsp");
			
			} else {
				request.getSession().setAttribute("Nombre","Consulta");
				request.getSession().setAttribute("Consulta","Error");	
				response.sendRedirect("Error.jsp");
			}
		} else {

			response.sendRedirect("index.jsp");
		}

	}

}
