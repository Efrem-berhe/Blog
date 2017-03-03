/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.Category;
import entities.Comment;
import entities.Post;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbeans.CategoryFacadeLocal;
import sessionbeans.CommentFacadeLocal;
import sessionbeans.PostFacadeLocal;

/**
 *
 * @author Marek
 */
@WebServlet(name = "Posts", urlPatterns = {"/Posts"})
public class PostsServlet extends HttpServlet {

    @EJB
    private PostFacadeLocal postFacade;
    
    @EJB
    private CommentFacadeLocal commentFacade;
    
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
        String categoryId = request.getParameter("category");
        
        List<Post> posts = postFacade.findAll();
        posts = filterPosts(posts, categoryId);
        request.setAttribute("posts", posts);
        
        List<Category> categories = categoryFacade.findAll();
        request.setAttribute("categories", categories);
        
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/posts.jsp");
        view.forward(request, response);
    }
    
    private List<Post> filterPosts(List<Post> posts, String stringCategoryId) {
        Long categoryId;
        try  
        {  
            categoryId = Long.parseLong(stringCategoryId);  
        }  
        catch(NumberFormatException nfe)  
        {  
            return posts; 
        }  
        
        List<Post> filteredPosts = new ArrayList<>();
        for (Post post : posts) {
            if (post.hasCategory(categoryId)) {
                filteredPosts.add(post);
            }
        }
        
        return filteredPosts;
    }

}
