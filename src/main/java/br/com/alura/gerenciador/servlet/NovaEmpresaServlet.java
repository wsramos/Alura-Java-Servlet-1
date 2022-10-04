package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");

		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			empresa.setDataAbertura(sdf.parse(dataEmpresa));
		} catch (ParseException e) {
			throw new ServletException(e);

		}

		Banco banco = new Banco();
		banco.adiciona(empresa);

		response.sendRedirect("listaEmpresas");

		/*
		 * request.setAttribute("Empresa", empresa.getNome());
		 * request.setAttribute("dataAbertura", empresa.getDataAbertura());
		 * RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
		 * rd.forward(request, response);
		 */

	}

}
