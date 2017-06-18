/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import entities.Post;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import sessionbeans.PostFacadeLocal;

/**
 *
 * @author Marek
 */
@WebService(serviceName = "PostLikesRetriever")
@Stateless()
public class PostLikesRetriever {

    @EJB 
    private PostFacadeLocal postFacade;

    @WebMethod(operationName = "countOfLikesForPost")
    public Integer countOfLikesForPost(@WebParam(name = "postId") int postId) {
        System.out.println(postId);
        Post post = postFacade.find((long) postId);
        if (post == null) {
            return null;
        }
        
        return post.getLikes();
    }
}