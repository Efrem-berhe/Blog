/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.Category;
import entities.Importance;
import entities.Post;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbeans.CategoryFacadeLocal;
import sessionbeans.PostFacadeLocal;

/**
 *
 * @author Marek
 */
@WebServlet(name = "CreatePost", urlPatterns = {"/CreatePost"})
public class CreatePostServlet extends HttpServlet {

    @EJB
    PostFacadeLocal postFacade;
    
    @EJB
    private CategoryFacadeLocal categoryFacade;

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
        List<Category> categories = categoryFacade.findAll();
        request.setAttribute("categories", categories);
        System.out.println(categories.size());
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/create-post.jsp");
        view.forward(request, response);
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
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String text = request.getParameter("text");
        Importance importance = Importance.valueOf(request.getParameter("importance"));
        Date date = new Date();
        
        User user = new User(firstName, lastName);
        Post post = new Post();
        post.setUser(user);
        post.setText(text);
        post.setPublishedDate(date);
        post.setImportance(importance);
        
        List<Category> categories = new ArrayList<>();
        String[] categoryIds = request.getParameterValues("categories");
        if (categoryIds != null && categoryIds.length > 0) {
            categories = getCategories(categoryIds);
        }
        
        post.setCategories(categories);
        
        postFacade.create(post);
        
        response.sendRedirect("Posts");
    }
    
    private List<Category> getCategories(String[] categoryIds) {
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < categoryIds.length; i++) {
            categories.add(categoryFacade.find(Long.parseLong(categoryIds[i])));
        }
        
        return categories;
    }

}
