package br.edu.ifsp.dsw1.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/rapida.do")
public class VisitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Define o tipo de conteúdo e a codificação */
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        /*
         * Pode-se simplificar as configurações acima, usando 
         * apenas o setContentType().
         */
//        response.setContentType("text/html;charset=UTF-8");
        
        /*
         * O PrintWriter para enviar a resposta HTML é obtido 
         * do response, ou seja, editamos a referência do objeto
         * que já existe no response.
         */
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Obrigado por visitar a página!</h1>");
        out.println("<p>Você será redirecionado em 5 segundos...</p>");
        out.println("</body></html>");

        /* Configura o cabeçalho HTTP, o atributo Refresh com o valor do
         * tempo (segundos) e o destino.
         */
        response.setHeader("Refresh", "5; URL=https://jakarta.ee/");
	}
}
