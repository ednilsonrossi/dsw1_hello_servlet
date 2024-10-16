package br.edu.ifsp.dsw1.eco;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;


@WebServlet(name = "EchoServlet", urlPatterns = {"/echoservlet", "/eco"})
public class EchoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=ISO-8859-1");
		try (PrintWriter out = response.getWriter()) {
			out.println("<html>");
			out.println("	<head>");
			out.println("		<title>Echo</title>");
			out.println("	</head>");
			out.println("<body>");
			out.println("	<h1>Echo Servlet em " + request.getContextPath() + "</h1>");
			out.println("	<h2>Dados da requisição</h2>");
			
			out.println("	<h3>Dados gerais</h3>");
			out.println("	<p>ContextPath: " + request.getContextPath() + "</p>");
			out.println("	<p>LocalAddr: " + request.getLocalAddr() + "</p>");
			out.println("	<p>LocalName: " + request.getLocalName() + "</p>");
			out.println("	<p>LocalPort: " + request.getLocalPort() + "</p>");
			out.println("	<p>Method: " + request.getMethod() + "</p>");
			out.println("	<p>Protocol: " + request.getProtocol() + "</p>");
			out.println("	<p>RemoteAddr: " + request.getRemoteAddr() + "</p>");
			out.println("	<p>RemoteHost: " + request.getRemoteHost() + "</p>");
			out.println("	<p>RequestURI: " + request.getRequestURI() + "</p>");
			out.println("	<p>ServerName: " + request.getServerName() + "</p>");
			out.println("	<p>ServletPath: " + request.getServletPath() + "</p>");
			out.println("	<p>ServerPort: " + request.getServerPort() + "</p>");
			
			out.println("	<h3>Cabeçalhos</h3>");
			Enumeration<String> cabecalhos = request.getHeaderNames();
			while (cabecalhos.hasMoreElements()) {
				String nomeCabecalho = cabecalhos.nextElement();
				String valorCabecalho = request.getHeader(nomeCabecalho);
				out.println("	<p>   " + nomeCabecalho + ": " + valorCabecalho + "</p>");
			}
			
			out.println("	<h2>Parâmetros</h2>");
			Map<String, String[]> parametrosMap = request.getParameterMap();
			for (Map.Entry<String, String[]> parametro : parametrosMap.entrySet()) {
				String parametroNome = parametro.getKey();
				String parametroValores[] = parametro.getValue();
				
				out.println("	<p>Parâmetro (nome): " + parametroNome + "</p>");
				out.println("	<ul>");
				for (String str : parametroValores) {
					out.println("	<li>Valor: " + str + "</li>");
				}
				out.println("	</ul> ");
			}
			
			out.println("	<h2>Dados do Contexto</h2>");
			out.println("	<p>ContextPath: " + request.getServletContext().getContextPath() + "</p>");
			out.println("	<p>EffectiveMajorVersion: " + request.getServletContext().getEffectiveMajorVersion() + "</p>");
			out.println("	<p>EffectiveMinorVersion: " + request.getServletContext().getEffectiveMinorVersion() + "</p>");
			out.println("	<p>MajorVersion: " + request.getServletContext().getMajorVersion() + "</p>");
			out.println("	<p>MinorVersion: " + request.getServletContext().getMinorVersion() + "</p>");
	
			
			out.println("	<p><a href=\"" + request.getRequestURI() + "\">Recarregar</a></p>");
			out.println("</body>");
			out.println("</html>");
		}
	}

}
