package br.edu.ifsp.dsw1.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String messages[];
	private int lastPosition;
	
    public HelloServlet() {
    	lastPosition = -1;
        messages = new String[] {
    			"Hello, World!",
    			"Olá, Mundo!",
    			"¡Hola, Mundo!",
    			"Bonjour, le Monde!",
    			"Hallo, Welt!"
    	};
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			out.println("<html>");
			out.println("	<head>");
			out.println("		<title>Olá Servlet!</title>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("		<h1>" + messages[usePosition()] + "</h1>");
			out.println("	</body>");
			out.println("</html>");
		} finally {
			out.close();	
		} // Sugere-se o uso do try-with-resources
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private int usePosition() {
		lastPosition += 1;
		if (lastPosition >= 5) {
			lastPosition = 0;
		}
		return lastPosition;
	}
}
