package ut01.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParseTest {

	private static final String URL = "http://itvocationalteacher.blogspot.com/feeds/posts/default?alt=json";

	public static void main(String[] args) {

		try {
			URL url = new URL(URL);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.connect();

			InputStream stream = connection.getInputStream();
			Reader reader = new InputStreamReader(stream);

			int contentLength = connection.getContentLength();
			char[] charArray = new char[contentLength];
			reader.read(charArray);
			String reponseData = new String(charArray);

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reponseData);

			JSONObject root = (JSONObject) jsonObject.get("feed");
			JSONArray posts = (JSONArray) root.get("entry");

			for (int i = 0; i < posts.size(); i++) {
				JSONObject jsonPost = (JSONObject) posts.get(i);
				JSONObject title = (JSONObject) jsonPost.get("title");
				System.out.println(title.get("$t"));
			}

		} catch (FileNotFoundException ex) {

		} catch (IOException ex) {

		} catch (NullPointerException ex) {

		} catch (ParseException e) {
			
		}

	}

}