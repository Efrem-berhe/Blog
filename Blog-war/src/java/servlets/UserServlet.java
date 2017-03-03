/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.Post;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbeans.PostFacade;
import sessionbeans.PostFacadeLocal;

/**
 *
 * @author Avatar
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
//this is url path
public class UserServlet extends HttpServlet {

    
    
    
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
        
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/add_user.jsp");
        //we are going to forward to Jsp , we ask the request that comes to the servlet the servlet in turn is asking the 
        //request dispatcher to forward our request to web-inf/views/add_user.jsp
        
        view.forward(request, response);
        
        String firstName = request.getParameter("firstName");
        System.out.println(firstName);
        //response is what is sent back to the browser as html, the jsp is going to write html to the response
//        response.setContentType("text/html;charset=UTF-8");
//        //telles the type of text we are sending is html
//        try (PrintWriter out = response.getWriter()) {
        
            //response is what we are sending to the web-browser 
            //using getWrite we can write html to the http response
            
            /* TODO output your page here. You may use following sample code. */
                        
           // Post post = new Post();
            //post.setText("some text");
           // postFacade.create(post);
            
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>JavaEE7 Blog</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Welcome to Our JavaEE Blog " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
            
  //      }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
