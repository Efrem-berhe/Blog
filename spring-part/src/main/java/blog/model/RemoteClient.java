package blog.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.commons.io.IOUtils;

import javax.inject.Named;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * @author Marek Turis
 */
@Named
public class RemoteClient {

	public <T> List<T> getMore(String urlString, Class objectClass) throws IOException {
		String json = getJson("http://localhost:8081/blog/quote");

		ObjectMapper mapper = new ObjectMapper();
		List<T> list = mapper.readValue(json,
				TypeFactory.defaultInstance().constructCollectionType(List.class,
						objectClass));

		return list;
	}

	public boolean doPost(String urlString, Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(object);

		return sendPost(urlString, jsonString);
	}

	private String getJson(String urlString) throws IOException {
		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
		String json = IOUtils.toString(is, "UTF-8");
		return json;
	}

	private boolean sendPost(String urlString, String json) throws IOException {
		URL obj = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");


		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(json);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		return responseCode < 300;
	}
}
