import webservices.*;
public class PostLikesRetrieverInvoker {
    public static void main(String[] arg) {

		PostLikesRetriever_Service service = new PostLikesRetriever_Service();

        PostLikesRetriever port = service.getPostLikesRetrieverPort();

        int result = port.countOfLikesForPost(3);

        System.out.println("Result: " + result);
    }
}
