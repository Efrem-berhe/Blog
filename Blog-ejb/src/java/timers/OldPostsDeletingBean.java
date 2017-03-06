/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timers;

import entities.Post;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import sessionbeans.PostFacadeLocal;

/**
 *
 * @author Marek
 */
@Stateless
public class OldPostsDeletingBean implements OldPostsDeletingBeanLocal {

    @EJB
    private PostFacadeLocal postFacade;
    
    /**
     * Posts older than one month will be deleted at the start of each month
     */
    @Schedule(dayOfMonth = "1", hour = "1", minute = "1")
    @Override
    public void deleteOldPosts() {
        List<Post> posts = postFacade.findAll();
        
        for (Post post : posts) {
            Date lastMonth = getLastMonth();
            if (post.getPublishedDate().before(lastMonth)) {
                postFacade.remove(post);
            }
        }
    }
    
    private Date getLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }
}
