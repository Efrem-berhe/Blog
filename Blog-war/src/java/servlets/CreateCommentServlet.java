/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.Comment;
import entities.Post;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbeans.CommentFacadeLocal;
import sessionbeans.PostFacadeLocal;

/**
 *
 * @author Marek
 */
@WebServlet(name = "CreateComment", urlPatterns = {"/CreateComment"})
public class CreateCommentServlet extends HttpServlet {

    @EJB
    private PostFacadeLocal postFacade;
    
    @EJB
    private CommentFacadeLocal commentFacade;
    

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
        String text = request.getParameter("text");
        Long postId = Long.parseLong(request.getParameter("postId"));
        Comment comment = new Comment();
        comment.setText(text);
        Post post = postFacade.find(postId);
        comment.setPost(post);
        
        commentFacade.create(comment);
        
        response.sendRedirect("Posts");
    }



}
