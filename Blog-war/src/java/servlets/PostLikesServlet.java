/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbeans.PostLikesRetrieverLocal;

/**
 *
 * @author Marek
 */
@WebServlet(name = "PostLikes", urlPatterns = {"/PostLikes"})
public class PostLikesServlet extends HttpServlet {

    @EJB
    private PostLikesRetrieverLocal postLikesRetriever;
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PostLikesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            Integer count = postLikesRetriever.countOfLikesForPost(Integer.parseInt(request.getParameter("postId")));
            if (count == null) {
                out.println("Post not found");
            } else {
                out.println(count);
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

}
