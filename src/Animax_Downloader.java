import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class Animax_Downloader {

	public static String[] getLinks(String resBody) throws FileNotFoundException, IOException
	{
		JSONParser parser;
		JSONArray jsonArray = null;
		String[] links=null;
		try {
			parser = (JSONParser) new JSONParser();

			Object obj = parser.parse(resBody);

			JSONObject json = (JSONObject) obj;
			jsonArray = (JSONArray) json.get("data");
			links=new String[jsonArray.size()];
			for(int i =0;i<jsonArray.size();i++)
			{

				JSONObject object=(JSONObject)jsonArray.get(i);
				if(object.get("vid2")!=null)
				{
					
					links[i]=object.get("vid2").toString();
				}
				else
				{
					links[i]=object.get("vid1").toString();
				}
				
				
					
				
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return links;
	}
	
	public static String getRes(String url) throws Exception
	{
		
		String downloadURL="https://m.animax.mn/api/m/episodes/paginate/"+url+"?page=1";
		URL uri = new URL(downloadURL);
		URLConnection con = uri.openConnection();
		con.addRequestProperty("User-Agent", 
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(in, encoding);
		return body;
		
	}
	public static String id(String url)
	{
		//TUhain anime-n id-g awch baina
		String[] comps=url.split("/");
		return comps[comps.length-1];
	}

}
