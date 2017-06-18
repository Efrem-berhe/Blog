/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog_client_application;

/**
 *
 * @author Vadim Janovskij
 */
public class Blog_Client_Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int postID = 3;
        try{         
            int result = countOfLikesForPost(postID);
            System.out.println("Number of likes: " + result);
        }catch (NullPointerException ex) {
            System.out.println("Post with ID=" + postID + " does not exist!");
        }catch (Exception ex){
            System.out.println("Exception: " + ex);
        }
    }

    private static Integer countOfLikesForPost(int postId) {
        webservices.PostLikesRetriever_Service service = new webservices.PostLikesRetriever_Service();
        webservices.PostLikesRetriever port = service.getPostLikesRetrieverPort();
        return port.countOfLikesForPost(postId);
    }
    
}
