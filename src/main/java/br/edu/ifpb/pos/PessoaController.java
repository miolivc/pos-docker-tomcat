/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author miolivc
 */
@WebServlet(name = "PessoaController", urlPatterns = {"/pessoas"})
public class PessoaController extends HttpServlet {

    private PessoaService service = new PessoaService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'/>");
            out.println("<title>Pessoa Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Pessoas</h1>");
            this.imprimePessoas(out);
            out.println("<a href='index.html'>Voltar</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        service.add(new Pessoa(nome));
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
        dispatcher.forward(request, response);
    }

    private void imprimePessoas(PrintWriter out) {
        out.print("<ol>");
        service.todasAsPessoas().forEachRemaining((pessoa) -> {
            out.print(String.format("<li>%s</li>", pessoa));
        });
        out.print("</ol>");
    }
}
