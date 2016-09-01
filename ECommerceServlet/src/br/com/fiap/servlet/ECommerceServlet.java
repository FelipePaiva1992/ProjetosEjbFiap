package br.com.fiap.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.webservice.Comentario;
import br.com.fiap.webservice.IComentarioEndpointProxy;

@WebServlet("/comentario")
public class ECommerceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ECommerceServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Calendar cal = Calendar.getInstance();
		try {
			String data = request.getParameter("data");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");			
			cal.setTime(sdf.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String titulo = request.getParameter("titulo");
		String assunto = request.getParameter("assunto");
		String c = request.getParameter("comentario");
		int avaliacao = Integer.parseInt(request.getParameter("avaliacao"));

		PrintWriter out = response.getWriter();
		try {
			Comentario comentario = new Comentario();
			comentario.setData(cal);
			comentario.setTitulo(titulo);
			comentario.setAssunto(assunto);
			comentario.setComentario(c);
			comentario.setAvaliacao(avaliacao);

			IComentarioEndpointProxy proxy = new IComentarioEndpointProxy();
			proxy.inserirComentario(comentario);

			request.setAttribute("lista", proxy.listaComentarios());
			request.getRequestDispatcher("lista.jsp").forward(request, response);
		} catch (Exception e) {
			out.print(e.getMessage());
		}
	}

}
