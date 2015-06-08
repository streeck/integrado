/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SubDominio;
import persistence.DAOException;
import persistence.SubDominioDAO;

/**
 *
 * @author charles
 */
public class ConsultaRelativa extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConsultaRelativa</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaRelativa at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String entrada = request.getParameter("entrada");
        String mes = request.getParameter("value");

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        try {
            SubDominioDAO subDAO = new SubDominioDAO();
            List<SubDominio> subs = subDAO.consultaRelativa(entrada, mes);
            PrintWriter writer = response.getWriter();

            String json = "[";
            if(subs.size() != 0) {
                for (SubDominio temp : subs) {
                    json+= "{\"descricao\":\"" + temp.getDescricao().trim() + "\",";
                    json+= "\"soma\":\"" + temp.getFormattedValor() + "\"},";
                }
                json = json.substring(0, json.length() - 1);
            }
            json += "]";

            writer.print(json);
            writer.close();

        } catch (SQLException | DAOException exception) {
            throw new ServletException(exception.getMessage());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
