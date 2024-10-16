package br.edu.ifsp.dsw1.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


@WebServlet("/erro")
public class ErroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int number = new Random().nextInt(10) + 1;
		if (number % 2 == 0) {
			/*
			 * Define que o status da resposta é 200 OK.
			 */
			response.setStatus(HttpServletResponse.SC_OK);
			PrintWriter out = response.getWriter();
			out.println(number);
			out.close();
		} else {
			/*
			 * Erro de NOT FOUND é o 404, porém aqui está
			 * sendo personalizada a resposta do usuário.
			 */
			response.sendError(HttpServletResponse.SC_NOT_FOUND, 
					"Página impar (" + number + ") não encontrada.");
		}
	}

}
