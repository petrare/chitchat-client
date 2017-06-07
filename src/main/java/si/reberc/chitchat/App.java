package si.reberc.chitchat;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Hello ChitChat!
 */
public class App {
    public static void main(String[] args) {
        try {
            String hello = Request.Get("http://chitchat.andrej.com")
                                  .execute()
                                  .returnContent().asString();
            System.out.println(hello);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void seznamUporabnikov() {
        try {
            String uporabniki = Request.Get("http://chitchat.andrej.com/users")
                                  .execute()
                                  .returnContent().asString();
            System.out.println(uporabniki);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   



    public static void prijava() {
        try {
            URI uri = new URIBuilder("http://chitchat.andrej.com/users").addParameter("username", "Petra").build();
            String responseBody = Request.Post(uri).execute().returnContent().asString();
            System.out.println(responseBody);

        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    public static void odjava() {
        try {
            URI uri = new URIBuilder("http://chitchat.andrej.com/users").addParameter("username", "Petra").build();
            String responseBody = Request.Delete(uri).execute().returnContent().asString();
            System.out.println(responseBody);

        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
    

