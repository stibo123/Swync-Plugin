import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.*;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Main {

	static String email = "stibo123@gmail.com";
	static String passwort = "bartosPWDStage"; //Verschlüsseln in Hash-512
	static String url = "https://s1.mogree.com/swync/api/v2/companyapi/auth?mail=";
	static String salt = "";
	public static void main(String[] args) {

	String newurl = url + email + "&password=" + Decrypt(passwort, salt);
	System.out.println("URL: " + newurl);
	String auth = Auth(newurl);
	System.out.println("JSON: "+auth);
	}

	private static String Decrypt(String passwort, String salt) {
		String generatedPassword = null;
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-512");
         md.update(salt.getBytes("UTF-8"));
			byte[] bytes = md.digest(passwort.getBytes("UTF-8"));
	         StringBuilder sb = new StringBuilder();
	         for(int i=0; i< bytes.length ;i++){
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	         }
	         generatedPassword = sb.toString();
	        }
	       catch (NoSuchAlgorithmException | UnsupportedEncodingException e){
	        e.printStackTrace();
				}
				return generatedPassword;
	}

	public static String Auth(String url)
	{

			try {
				URL oracle = new URL(url);

			HttpURLConnection httpconnection = (HttpURLConnection) oracle.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(
			httpconnection.getInputStream()));
			String inputLine;
			String data = "";
			while ((inputLine = in.readLine()) != null)
					data += inputLine;
			in.close();

			return data;

			} catch (MalformedURLException e) {

				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
	}

	public static void parseAuth(String data){
		JSONParser parser = new JSONParser();
		try {
			
			Object obj = parser.parse(data);
			
			JSONObject jsonObject = (JSONObject) obj;


            String itemid = (String) jsonObject.get("itemid");
            int type = (int) jsonObject.get("type");
            int itemproviderid = (int) jsonObject.get("itemproviderid");
            
            //int detail
            //https://www.mkyong.com/java/json-simple-example-read-and-write-json/
            
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
