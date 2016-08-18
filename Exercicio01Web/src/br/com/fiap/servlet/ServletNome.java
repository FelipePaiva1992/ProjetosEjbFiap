package br.com.fiap.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.interfaces.INome;

@WebServlet("/nome")
public class ServletNome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	INome nm;

	public ServletNome() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try{
			out.print("<ul>");
			for(String nome:nm.buscarNomes()){
				out.println("<li>" + nome + "</li>");
			}			
			out.print("</ul>");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		try {
			String nome = request.getParameter("nome");
			nm.incluirNome(nome);
			out.println("Nome " + nome + " incluido com sucesso!");
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}
}