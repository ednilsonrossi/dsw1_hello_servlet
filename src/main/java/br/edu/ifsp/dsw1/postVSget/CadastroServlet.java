package br.edu.ifsp.dsw1.postVSget;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;


@WebServlet("/cadastro.do")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Aluno> alunos;
       

    public CadastroServlet() {
        alunos = new LinkedList<Aluno>();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
	    out.println("<html lang='pt-br'>");
	    out.println("<head>");
	    out.println("<meta>");
	    out.println("<link href=\"css/style.css\" rel=\"stylesheet\">");
	    out.println("<title>Mensagem Enviada</title>");
	    out.println("</meta>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<div class='container'>");
	    out.println("<h1>Alunos Cadastrados</h1>");
	    out.println("<ul>");
	    for(var aluno: alunos) {
	    	out.println("<li>" + aluno.toString() + "</li>");
	    }
	    out.println("</ul>");
	    out.println("<a href='input.html'>Voltar para a página inicial</a>");
	    out.println("</div>");
	    out.println("</body>");
	    out.println("</html>");
		out.close();
	}


    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("text_dados");
		String mensagem;
		
		if (str != null && !str.isEmpty()) {
			String alunoInfo[] = str.split(";");
			
			if (alunoInfo.length == 3) {
				Aluno aluno = new Aluno(alunoInfo[0].trim(), alunoInfo[1].trim(), alunoInfo[2].trim());
				alunos.add(aluno);
				mensagem = "Aluno cadastrado com sucesso.";
			} else {
				mensagem = "Formato de dados inválido.";
			}
		} else {
			mensagem = "Não foi possível recuperar os dados de entrada.";
		}
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
	    out.println("<html lang='pt-br'>");
	    out.println("<head>");
	    out.println("<meta>");
	    out.println("<link href=\"css/style.css\" rel=\"stylesheet\">");
	    out.println("<title>Mensagem Enviada</title>");
	    out.println("</meta>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<div class='container'>");
	    out.println("<h1>" + mensagem + "</h1>");
	    out.println("<a href='input.html'>Voltar para a página inicial</a>");
	    out.println("</div>");
	    out.println("</body>");
	    out.println("</html>");
		out.close();
	}

}
