/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Marek
 */
@WebFilter(filterName = "ProtectFilter", urlPatterns = {"/DeletePost"})
public class ProtectFilter implements Filter {
    
    
    public ProtectFilter() {
    }    
    
   

    /**
     *
     * @param r The servlet request we are processing
     * @param s The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest r, ServletResponse s,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) r;
        HttpServletResponse response = (HttpServletResponse) s;

        String auth = request.getHeader("Authorization");
        if (auth == null) {
            response401(response);
            return;
        }
        String[] creds = parseAuthHeader(auth);
        String logname = creds[0];
        String password = creds[1];

        
        if(!"admin".equals(logname) || !"password".equals(password)) {
            response401(response);
            return;
        }
        
        chain.doFilter(request, response);
    }

    
    private String[] parseAuthHeader(String auth) {
        return new String(DatatypeConverter.parseBase64Binary(auth.split(" ")[1])).split(":", 2);
    }

    private void response401(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setHeader("WWW-Authenticate", "Basic realm=\"type email and password\"");
        response.getWriter().println("<html><body><h1>401 Unauthorized</h1> You are not authorized to delete post ...</body></html>");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    
    }

    @Override
    public void destroy() {
    
    }
}
