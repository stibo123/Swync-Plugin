import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.*;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Main {

	static String email = "stibo123@gmail.com";
	static String passwort = "bartosPWDStage";
	static String url = "https://s1.mogree.com/swync/api/v2/companyapi/auth?mail=";
	static String salt = "";
	static LoginData loginData;
	static UserData datafromuser;
	
	public static void main(String[] args) {

	String newurl = url + email + "&password=" + Decrypt(passwort, salt);
	System.out.println("URL: " + newurl);
	String auth = Auth(newurl);
	System.out.println("JSON: "+auth);
	parseAuth(auth);
	
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
			
			JSONObject object = (JSONObject) obj;
			
			JSONObject jsonObject = (JSONObject) object.get("detailresponse");
			
			long userid = (long) jsonObject.get("userid");
			String authtoken = (String)jsonObject.get("auth_token");
			
			JSONObject userdata = (JSONObject) jsonObject.get("userdata");
			String email = (String) userdata.get("email");
			String name = (String) userdata.get("title");
			String street = (String) userdata.get("street");
			String zip = (String) userdata.get("zip");
			String qrlink = (String) userdata.get("qrlink");
			boolean verified = (boolean) userdata.get("verified");
			boolean iscontact = (boolean) userdata.get("iscontact");
			long type_userdata = (long) userdata.get("type");
			long itemproviderid_userdata = (long) userdata.get("itemproviderid");
			long detailtype_userdata = (long) userdata.get("detailtype");
			
            String itemid = (String) jsonObject.get("itemid");
            long type = (long) jsonObject.get("type");
            long itemproviderid = (long) jsonObject.get("itemproviderid");
            long detailtype = (long) jsonObject.get("detailtype");
            
            datafromuser = new UserData(email, name, street, zip, qrlink, verified, iscontact, type_userdata, itemproviderid_userdata, detailtype_userdata);
            loginData = new LoginData(userid, authtoken, datafromuser, itemid, type, itemproviderid, detailtype);
           
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
