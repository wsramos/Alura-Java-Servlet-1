package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlteraEmpresaServlet
 */
@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Banco banco = new Banco();

		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");
		Integer id = Integer.parseInt(request.getParameter("id"));

		Empresa empresa = banco.buscaEmpresapeloId(id);
		System.out.println("Empresa " + empresa.getNome() + " localizada pelo ID " + empresa.getId());

		empresa.setNome(nomeEmpresa);
		System.out.println("Alterado Nome da empresa para " + empresa.getNome());

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			empresa.setDataAbertura(sdf.parse(dataEmpresa));
			System.out.println("Alterada dataAbertura para " + empresa.getDataAbertura());

		} catch (ParseException e) {
			throw new ServletException(e);

		}

		response.sendRedirect("listaEmpresas");
	}

}
