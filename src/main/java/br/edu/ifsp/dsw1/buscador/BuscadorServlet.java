package br.edu.ifsp.dsw1.buscador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/busca.do")
public class BuscadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String query = request.getParameter("text_search");
		
		if (query != null && !query.trim().isEmpty()) {
			String engine = request.getParameter("engine");
			String engineUrl;
			if (engine.equals("google")) {
				engineUrl = "https://www.google.com/search?q=";
			} else if (engine.equals("duckduckgo")) {
				engineUrl = "https://duckduckgo.com/?q=";
			} else if (engine.equals("bing")) {
				engineUrl = "https://www.bing.com/search?q=";
			} else if (engine.equals("yahoo")) {
				engineUrl = "https://search.yahoo.com/search?p=";
			} else {
				engineUrl = "https://www.ecosia.org/search?q=";
			}
			engineUrl += query;
			/* Redireciona a busca para o motor escolhido. */
			response.sendRedirect(engineUrl);
		} else {
			/* Apresenta um erro caso não seja informado termo de busca. */
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, 
					"Termo de busca não encontrado.");
		}
	}

}
