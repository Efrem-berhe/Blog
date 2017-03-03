/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Post;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Avatar
 */
@Stateless
public class PostFacade {

    @PersistenceContext(unitName = "Blog-ejbPU")
    private EntityManager em;
    
    protected EntityManager getEntityManager() {
        return em;
    }

    public void create(Post entity) {
        getEntityManager().persist(entity);
    }

    public void edit(Post entity) {
        getEntityManager().merge(entity);
    }

    public void remove(Post entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public Post find(Object id) {
        return getEntityManager().find(Post.class, id);
    }

    public List<Post> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Post.class));
        return getEntityManager().createQuery(cq).getResultList();
    }
}
