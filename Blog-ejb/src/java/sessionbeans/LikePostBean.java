/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Post;
import interceptors.LoggingInterceptor;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

/**
 *
 * @author Marek
 */
@Stateful
@Interceptors ({LoggingInterceptor.class})
public class LikePostBean implements LikePostBeanLocal {

    private boolean alreadyLiked = false;
    
    @EJB
    private PostFacadeLocal postFacade;
    
    public void likePostWithId(long postId) {
        if (alreadyLiked) {
            return;
        }
        
        Post post = postFacade.find(postId);
        if (post == null) {
            return;
        }
        
        post.incrementLikes();
        
        alreadyLiked = true;
    }
}
