/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fonte;
import persistence.DAOException;
import persistence.FonteDAO;

/**
 *
 * @author charles
 */
public class ConsultaFonte extends HttpServlet {

    private int offset;

    public void ConsultaFonte() {
        offset = 0;
    }

    public void setOffset() {
        this.offset += 10;
    }

    public int getOffset() {
        return this.offset;
    }

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
            out.println("<title>Servlet ConsultaFonte</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaFonte at " + request.getContextPath() + "</h1>");
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
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        try {
            FonteDAO fonDAO = new FonteDAO();
            int offset = Integer.parseInt(request.getParameter("offset"));
            List<Fonte> fontes = fonDAO.consultaFonte(offset);
            int paginas = fonDAO.pagFonte();
            PrintWriter writer = response.getWriter();
            
            String json = "{\"count\":\"" + paginas + "\",";
            json += "\"data\":\"[";
            if (!fontes.isEmpty()) {
                for (Fonte temp : fontes) {
                    json += "{\"descricao\":\"" + temp.getFonte().trim() + "\",";
                    json += "\"licitacao\":\"" + temp.getTipoLicitacao() + "\",";
                    json += "\"soma\":\"" + temp.getFormattedValor() + "\"},";
                }
                json = json.substring(0, json.length() - 1);
            }
            json += "]\"}";
            
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
