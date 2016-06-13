import java.net.HttpURLConnection;
import java.net.URL;

public class InternetReachable {
	public boolean isInternetReachable()
    {
        try {
            //make a URL to a known source
            URL url = new URL("http://www.google.com");

            //open a connection to that source
            HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();

            //trying to retrieve data from the source. If there
            //is no connection, this line will fail
            Object objData = urlConnect.getContent();

        } catch (Exception e) {              
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
