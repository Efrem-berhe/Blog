/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Service;
import java.io.StringReader;
import webservices.PostLikesRetriever_Service;

/**
 *
 * @author Marek
 */
@Stateless
public class PostLikesRetrieverLocalImpl implements PostLikesRetrieverLocal {

    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/PostLikesRetriever/PostLikesRetriever.wsdl")
    private PostLikesRetriever_Service service;

    public Integer countOfLikesForPost(int postId) {
        QName portQName = new QName("http://webservices/", "PostLikesRetrieverPort");
        String req = "<countOfLikesForPost  xmlns=\"http://webservices/\"><postId>555</postId></countOfLikesForPost>";
        try {
            // Call Web Service Operation
            Dispatch<Source> sourceDispatch = null;
            sourceDispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);
            Source result = sourceDispatch.invoke(new StreamSource(new StringReader(req)));
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            ex.printStackTrace();
        }
        
        return null;
    }
    
}
