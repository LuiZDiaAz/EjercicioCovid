package com.Laboratorio.Controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Laboratorio.Entidades.Usuarios;
import com.Laboratorio.Negocio.clsLoguin;

/**
 * Servlet implementation class ControllerAcces
 */
public class ControllerAcces extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerAcces() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		HttpSession sesion = request.getSession(true);

		String btnCerrar = request.getParameter("btncerrar");
		if (btnCerrar!=null) {
			response.sendRedirect("index.jsp");
			sesion.invalidate();
		} else {
			String dui = request.getParameter("dui");
			
			clsLoguin clslog = new clsLoguin();
			Usuarios usu = new Usuarios();
			usu = clslog.Verificar(dui);

			if (usu.getBeneficio()!=null) {
				System.out.println(usu.getBeneficio());
				if (usu.getBeneficio().equals("1")) {
					System.out.println("Con beneficio");

					String nombre = usu.getNombre();

					sesion.setAttribute("benefi", nombre);

					response.sendRedirect("Accesouser.jsp");
				} else if (usu.getBeneficio().equals("0")) {
					System.out.println("Sin beneficio");
					response.sendRedirect("noesbeneficiario.jsp");
				}
			} else {
				response.sendRedirect("Error.jsp");
			}
		}
	}
}
