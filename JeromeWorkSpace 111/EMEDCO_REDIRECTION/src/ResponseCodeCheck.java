import java.net.HttpURLConnection;
import java.net.URL;

public class ResponseCodeCheck {
	
	
		public static String URLChecker (String URLPASS) throws Exception {
    	URL url = new URL(URLPASS);
    	HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        try {
        connection.connect();
        
        int code = connection.getResponseCode();
        URL FinalURL = connection.getURL();
        
        if (code==200)
        {
            //System.out.println("OK");
        	
        	return FinalURL+","+code;
        	
        }else if (code==404) {
        	return FinalURL+","+code;
		}
        else {
        	return FinalURL+","+code;
        }
        
        }
        catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
        	URL FinalURL = connection.getURL();
        	return FinalURL+","+e;
        			
        }
    }
}