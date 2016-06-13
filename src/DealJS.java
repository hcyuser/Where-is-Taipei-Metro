import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import org.json.*;
public class DealJS {
	DealJS() throws IOException, JSONException ,ArrayIndexOutOfBoundsException{
	}
	//set variables
	public JSONObject jsonofweather = readJsonFromUrl("http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=8ee2166f-7b71-4be3-b6f4-6db1f8d0e570");
	public JSONObject json = readJsonFromUrl("http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=55ec6d6e-dc5c-4268-a725-d04cc262172b");
	public Object numbersofMRT = json.getJSONObject("result").getJSONArray("results").length();
	public Object thefirstinfo = json.getJSONObject("result").getJSONArray("results").get(0);
	public Object theweather = jsonofweather.getJSONObject("result").getJSONArray("results").get(0);
	public String station;
	public String destination;
	public String id;
	public String time;
	public String weatherdescription;
	public ArrayList<String> corrdestination = new ArrayList<>(); 
	public ArrayList<String> corrtime = new ArrayList<>(); 
	public ArrayList<JSONObject> Arrli01 = new ArrayList<>();
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	//set json method 
	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
	//set the information from the index of the json
	public void theinfofromindex(int a){
		Object theinfofromindex = json.getJSONObject("result").getJSONArray("results").get(a);
		String[] token = theinfofromindex.toString().split(",");
		String lostation =  token[0].substring(12,token[0].length()-1);
		String lodestination = token[1].substring(15,token[1].length()-1);
		String lotime = token[2].substring(14,token[2].length()-1);
		String loid = token[3].substring(7,token[3].length()-2);
		station = lostation;
		destination = lodestination;
		id = loid;
		time = lotime;
		//System.out.println(lostation);
		//System.out.println(lodestination);
		//System.out.println(lotime);
		//System.out.println(loid);
		//for(int i=0;i<=token.length;i++){System.out.println(token[i]);}
	}
	//get method
	public String getStation(){
		return station;
	}
	public String getTime(){
		return time;
	}
	public String getId(){
		return id;
	}
	public String getDestination(){
		return destination;
	}
	public String getNumberOfMRT(){
		return String.valueOf(numbersofMRT);
	}
	//set the  destination
	public void setCorrDestination(String aaa){
		corrdestination.clear();
		for(int i=0;i<=Integer.parseInt(getNumberOfMRT())-1;i++){
			theinfofromindex(i);
			if(aaa.equals(getDestination())){
				corrdestination.add(getStation());
				corrtime.add(getTime());
			}
		}
	}
	//set the weather
	public void setWeather(){
		String[] token = theweather.toString().split(",");
		weatherdescription = token[6].substring(9,token[6].length()-1);
	}
	//get the description from API 
	public String getWeatherdescription(){
		return weatherdescription;
	}
	public String getWeatherlocation(){
		return "Á`²Î©²";
	}
}





