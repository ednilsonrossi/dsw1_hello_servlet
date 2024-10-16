package br.edu.ifsp.dsw1.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@WebServlet("/hobbies.do")
public class HobbiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//    @Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//    	/*
//    	 * Recupera o valor (String) do parâmetro *nome* que é
//    	 * referente ao input do formulário. 
//    	 */
//    	String nome = request.getParameter("nome");
//		String email = request.getParameter("email");
//		
//		/*
//		 * Recuperar todos os valores selecionados no formulário,
//		 * aqui temos que o formulário permite multiplos valores
//		 * para o mesmo elemento.
//		 */
//		String hobbies[] = request.getParameterValues("hobbies");
//		
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<p>Nome: " + nome + "</p>");
//		out.println("<p>E-mail: " + email + "</p>");
//		if (hobbies != null && hobbies.length > 0) {
//			out.println("<h3>Seus Hobbies:</h3>");
//			out.println("<ul>");
//			for (var hobby : hobbies) {
//				out.println("<li>" + hobby + "</li>");
//			}
//			out.println("</ul>");
//		} else {
//			out.println("<p>Nenhum hobby foi selecionado.</p>");
//		}
//		out.println("<p><a href=\"hobbies.html\">Voltar ao formulário</a></p>");
//		out.close();
//	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	/*
    	 * getParameterMap() retorna um mapa (Map<String. String[]>) onde
    	 * a chave é o nome do parâmetros, de acordo com o formulário, e o 
    	 * valor é um ARRAY de String[] contendo os valores daquele parâmetro.
    	 */
    	Map<String, String[]> parametros = request.getParameterMap();
    	
    	/*
    	 * Para recuperar parametros individuais do Map deve-se informar qual
    	 * a chave desejada, e como o retorno é um array de String, tem-se que
    	 * indicar qual a posição do array se deseja, nesse exemplo, a posição
    	 * zero, visto que existe apenas um valor para o parâmetro.
    	 */
    	String nome = parametros.get("nome")[0];
		String email = parametros.get("email")[0];
		
		/*
		 * No caso de elementos com multiplos valores, recupera-se diretamente
		 * o array de string com os valores.
		 */
		String hobbies[] = parametros.get("hobbies");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<p>Nome: " + nome + "</p>");
		out.println("<p>E-mail: " + email + "</p>");
		if (hobbies != null && hobbies.length > 0) {
			out.println("<h3>Seus Hobbies:</h3>");
			out.println("<ul>");
			for (var hobby : hobbies) {
				out.println("<li>" + hobby + "</li>");
			}
			out.println("</ul>");
		} else {
			out.println("<p>Nenhum hobby foi selecionado.</p>");
		}
		out.println("<p><a href=\"hobbies.html\">Voltar ao formulário</a></p>");
		out.close();
	}

}
