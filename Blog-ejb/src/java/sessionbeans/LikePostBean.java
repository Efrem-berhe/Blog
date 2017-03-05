/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Post;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author Marek
 */
@Stateful
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
