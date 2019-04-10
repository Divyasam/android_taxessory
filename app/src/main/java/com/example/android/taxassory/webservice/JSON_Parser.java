package com.example.android.taxassory.webservice;
//package com.json.limofusion;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;

public class JSON_Parser {

	static InputStream is = null;
	static JSONObject jObj = null;
	static JSONArray Jarray = null;
	static String json = "";
	String res = null;

	public JSON_Parser() {

	}

	// JSONArray
	public JSONObject makeHTTPPOST(String url, String method, String param,String authentication) // with
																			// Encrypted
																			// Class
	{
		try {

			HttpClient client = new DefaultHttpClient();
			Log.d("Rqe Url ", url);
			Log.d("Req ", param);

			HttpPost post = null;
			try
			{
				post = new HttpPost(new URI(url));
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return Constant_method.Errer_jsonobject();
			}
			// String encryp=Get_Encrypted(param);
			// param="{\""+Constant_value.LimoRequest+"\":\""+encryp.replaceAll("\n",
			// "")+"\"}";

			Log.d("Rqe encrypted ", param);

			StringEntity stringEntity = new StringEntity(param);

			//stringEntity.setContentType("application/json");
			//String basicAuth = "Basic " + new String(Base64.encode("tomcat:tomcat".getBytes(),Base64.NO_WRAP ));
			//String basicAuth = "Basic "+authentication;
			//post.setRequestProperty ("Authorization", "Basic "+"YWRtaW4xMDFAZ21haWwuY29tOnBhc3N3b3Jk");
			//post.setHeader("Authorization", basicAuth);
			//conn.setRequestProperty
			stringEntity.setContentType("application/json");

			post.setHeader("Content-Type", "application/json");
			post.setHeader("Content-Type", "application/json");

			post.setEntity(stringEntity);

			BasicHttpResponse httpResponse = (BasicHttpResponse) client
					.execute(post);

			// res = EntityUtils.toString(httpResponse.getEntity());
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();
			// is=EntityUtils.To
			// System.out.println("data Prints ok "+res);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonobject();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonobject();
		} catch (IOException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonobject();
		} catch (Exception e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonobject();
		}

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "UTF-8"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
			Log.d("data prints of ", json);
		} catch (Exception e) {
			Log.e("Buffer Error", "Error converting result " + e.toString());
			return Constant_method.Errer_jsonobject();
		}
		// JSONArray Jarray_1=null;
		try {
			// jObj = new JSONObject(res);
			System.out.println("Convert data...");
			jObj = new JSONObject(json);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("Gt Error");
			e.printStackTrace();
		}
		return jObj;

	}
	//HttpPut httpPut = new HttpPut(url);

	public JSONObject makeHTTPGET(String url, String method, String param,String authentication) // with
	// Encrypted
	// Class
	{
		try
		{

			HttpClient client = new DefaultHttpClient();
			Log.d("Rqe Url ", url);
			//Log.d("Req ", param);
			//String paramString = URLEncodedUtils.format(param, "utf-8");
			if(param.toString().trim().length()==0)
			{}
			else
			url += "?" + param;

			Log.d("Rqe encrypted ", url);
			HttpGet post = null;
			try
			{
				post = new HttpGet(new URI(url));
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return Constant_method.Errer_jsonobject();
			}
			// String encryp=Get_Encrypted(param);
			// param="{\""+Constant_value.LimoRequest+"\":\""+encryp.replaceAll("\n",
			// "")+"\"}";

			//

			//StringEntity stringEntity = new StringEntity(param);

			//stringEntity.setContentType("application/json");
			//String basicAuth = "Basic " + new String(Base64.encode("tomcat:tomcat".getBytes(),Base64.NO_WRAP ));
			String basicAuth = "Basic "+authentication;
			//post.setRequestProperty ("Authorization", "Basic "+"YWRtaW4xMDFAZ21haWwuY29tOnBhc3N3b3Jk");
			post.setHeader("Authorization", basicAuth);
			//conn.setRequestProperty
			//post.setHeader("Content-Type", "application/json");

			//post.setEntity(stringEntity);

			BasicHttpResponse httpResponse = (BasicHttpResponse) client
					.execute(post);

			// res = EntityUtils.toString(httpResponse.getEntity());
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();
			// is=EntityUtils.To
			// System.out.println("data Prints ok "+res);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonobject();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonobject();
		} catch (IOException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonobject();
		} catch (Exception e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonobject();
		}

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "UTF-8"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null)
			{
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
			Log.e("data prints of ", json);
		}
		catch (Exception e)
		{
			Log.e("Buffer Error", "Error converting result " + e.toString());
			return Constant_method.Errer_jsonobject();
		}
		// JSONArray Jarray_1=null;
		try {
			// jObj = new JSONObject(res);
			System.out.println("Convert data...");
			jObj = new JSONObject(json);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("Gt Error");
			Log.e("error","Conversation error "+json);
			e.printStackTrace();
		}
		return jObj;

	}

	public JSONObject makeHTTPPUT(String url, String method, String param,String authentication) // with
	// Encrypted
	// Class
	{
		try {

			HttpClient client = new DefaultHttpClient();
			Log.d("Rqe Url ", url);
			Log.d("Req ", param);

			HttpPut post = null;
			try
			{
				post = new HttpPut(new URI(url));
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return Constant_method.Errer_jsonobject();
			}
			// String encryp=Get_Encrypted(param);
			// param="{\""+Constant_value.LimoRequest+"\":\""+encryp.replaceAll("\n",
			// "")+"\"}";

			Log.d("Rqe encrypted ", param);

			StringEntity stringEntity = new StringEntity(param);

			//stringEntity.setContentType("application/json");
			//String basicAuth = "Basic " + new String(Base64.encode("tomcat:tomcat".getBytes(),Base64.NO_WRAP ));
			//post.setRequestProperty ("Authorization", "Basic "+"YWRtaW4xMDFAZ21haWwuY29tOnBhc3N3b3Jk");
			String basicAuth = "Basic "+authentication;
			post.setHeader("Authorization", basicAuth);
			//conn.setRequestProperty
			//post.setHeader("Content-Type", "application/json");

			post.setEntity(stringEntity);

			BasicHttpResponse httpResponse = (BasicHttpResponse) client
					.execute(post);

			// res = EntityUtils.toString(httpResponse.getEntity());
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();
			// is=EntityUtils.To
			// System.out.println("data Prints ok "+res);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonobject();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonobject();
		} catch (IOException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonobject();
		} catch (Exception e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonobject();
		}

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "UTF-8"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
			Log.d("data prints of ", json);
		} catch (Exception e) {
			Log.e("Buffer Error", "Error converting result " + e.toString());
			return Constant_method.Errer_jsonobject();
		}
		// JSONArray Jarray_1=null;
		try {
			// jObj = new JSONObject(res);
			System.out.println("Convert data...");
			jObj = new JSONObject(json);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("Gt Error");
			e.printStackTrace();
		}
		return jObj;

	}

	public JSONArray makeHTTPPOST_array(String url, String method, String param) // with
																					// Encrypted
																					// Class
	{
		try {

			HttpClient client = new DefaultHttpClient();
			Log.d("Rqe Url ", url);
			Log.d("Req ", param);

			HttpPost post = new HttpPost(url);
			// String encryp=Get_Encrypted(param);
			// param="{\""+Constant_value.LimoRequest+"\":\""+encryp.replaceAll("\n",
			// "")+"\"}";

			Log.d("Rqe encrypted ", param);

			StringEntity stringEntity = new StringEntity(param);

			stringEntity.setContentType("application/json");

			post.setHeader("Content-Type", "application/json");

			post.setEntity(stringEntity);

			BasicHttpResponse httpResponse = (BasicHttpResponse) client
					.execute(post);

			// res = EntityUtils.toString(httpResponse.getEntity());
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();
			// is=EntityUtils.To
			// System.out.println("data Prints ok "+res);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonarray();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonarray();
		} catch (IOException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonarray();
		}
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
			Log.d("data prints of ", json);
		} catch (Exception e) {
			Log.e("Buffer Error", "Error converting result " + e.toString());
		}
		// JSONArray Jarray_1=null;
		try {
			// jObj = new JSONObject(res);
			System.out.println("Convert data...");
			// jObj = new JSONObject(json);
			Jarray = new JSONArray(json);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("Gt Error");
			e.printStackTrace();
			return Constant_method.Errer_jsonarray();
		}
		return Jarray;

	}
	
	public JSONObject makeHttpRequest(String url, String method,List<NameValuePair> param)
	{
		// TODO Auto-generated method stub
		try {
			// check for request method
			if (method == "POST") {
				System.out.println(" In post Method");
				DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(url);
				httpPost.setEntity(new UrlEncodedFormEntity(param));
				//httpPost.setS
				
				HttpResponse httpResponse = httpClient.execute(httpPost);
				HttpEntity httpEntity = httpResponse.getEntity();
				is = httpEntity.getContent();
				System.out.println(" In post Method");
			} 
			else if (method == "GET")
			{
				// request method is GET
				DefaultHttpClient httpClient = new DefaultHttpClient();
				String paramString = URLEncodedUtils.format(param, "utf-8");
				url += "?" + paramString;
				HttpGet httpGet = new HttpGet(url);
				Log.e("Service call","service call --"+url);
				//String basicAuth = "Basic " + new String(Base64.encode("tomcat:tomcat".getBytes(),Base64.NO_WRAP ));
				//post.setRequestProperty ("Authorization", basicAuth);
				//httpGet.setHeader("Authorization", basicAuth);
				HttpResponse httpResponse = httpClient.execute(httpGet);
				HttpEntity httpEntity = httpResponse.getEntity();
				is = httpEntity.getContent();
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonobject();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonobject();
		} catch (IOException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonobject();
		}

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			System.out.println(" In post Method");
			json = sb.toString();
			Log.e("data prints", json);
		} catch (Exception e) {
			Log.e("Buffer Error", "Error converting result " + e.toString());
			return Constant_method.Errer_jsonobject();
		}

		// try parse the string to a JSON object
		try {
			jObj = new JSONObject(json);
			// Jarray = new JSONArray(json);
		} catch (JSONException e) {
			Log.e("JSON Parser", "Error parsing data " + e.toString());
			return Constant_method.Errer_jsonobject();
		}

		// return JSON String
		// return jObj;
		return jObj;

	}
	
	public JSONArray makeHttpRequest_array(String url, String method,List<NameValuePair> param)
	{
		// TODO Auto-generated method stub
		try {
			// check for request method
			if (method == "POST") {
				System.out.println(" In post Method");
				DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(url);
				httpPost.setEntity(new UrlEncodedFormEntity(param));
				//httpPost.setS
				
				HttpResponse httpResponse = httpClient.execute(httpPost);
				HttpEntity httpEntity = httpResponse.getEntity();
				is = httpEntity.getContent();
				System.out.println(" In post Method");
			} 
			else if (method == "GET")
			{
				// request method is GET
				DefaultHttpClient httpClient = new DefaultHttpClient();
				String paramString = URLEncodedUtils.format(param, "utf-8");
				url += "?" + paramString;
				HttpGet httpGet = new HttpGet(url);

				HttpResponse httpResponse = httpClient.execute(httpGet);
				HttpEntity httpEntity = httpResponse.getEntity();
				is = httpEntity.getContent();
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonarray();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonarray();
		} catch (IOException e) {
			e.printStackTrace();
			return Constant_method.Errer_jsonarray();
		}

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			System.out.println(" In post Method");
			json = sb.toString();
			Log.e("data prints", json);
		} catch (Exception e) {
			Log.e("Buffer Error", "Error converting result " + e.toString());
			return Constant_method.Errer_jsonarray();
		}

		// try parse the string to a JSON object
		try {
			Jarray = new JSONArray(json);
			// Jarray = new JSONArray(json);
		} catch (JSONException e) {
			Log.e("JSON Parser", "Error parsing data " + e.toString());
			return Constant_method.Errer_jsonarray();
		}

		// return JSON String
		// return jObj;
		return Jarray;

	}
	
	 /* public String Get_Encrypted(String s) { try { Cipher cipher =
	 * Cipher.getInstance("AES/ECB/PKCS5Padding"); final SecretKeySpec secretKey
	 * = new SecretKeySpec(JSON_constant.key, "AES");
	 * cipher.init(Cipher.ENCRYPT_MODE, secretKey); final String encryptedString
	 * = Base64.encodeToString(cipher.doFinal(s.getBytes()),Base64.DEFAULT);//
	 * encodeBase64String(cipher.doFinal(s.getBytes())); return encryptedString;
	 * } catch (Exception e) { // TODO: handle exception
	 * System.out.println("GetErrer At Get_Encrypted(String s) in JSON_PARSER /"
	 * +e); return null; } return encrypt(s); }
	 

	
	 * public static String encrypt(String strToEncrypt) { try { Cipher cipher =
	 * Cipher.getInstance("AES/ECB/PKCS5Padding"); final SecretKeySpec secretKey
	 * = new SecretKeySpec(Constant_value.Key, "AES");
	 * cipher.init(Cipher.ENCRYPT_MODE, secretKey); byte[] inBytes =
	 * cipher.doFinal(strToEncrypt.getBytes()); String encryptedString =
	 * Base64.encodeToString(inBytes, 0, inBytes.length, Base64.DEFAULT); String
	 * s =encryptedString.replaceAll("\n",""); String p=encryptedString.trim();
	 * return p; } catch (Exception e) {
	 * System.out.printf("Error while encrypting", e); } return null;
	 * 
	 * }
	 
	//
	// public static String decrypt(String strToDecrypt)
	// {
	// try
	// {
	// Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	// final SecretKeySpec secretKey = new SecretKeySpec(ContentValues.key,
	// "AES");
	// cipher.init(Cipher.DECRYPT_MODE, secretKey);
	// final String decryptedString = new
	// String(cipher.doFinal(Base64.decode(strToDecrypt, Base64.DEFAULT)));
	// return decryptedString;
	// }
	// catch (Exception e)
	// {
	// System.out.printf("Error while decrypting", e);
	// }
	// return null;
	// }

	
	 * public JSONArray makeHttpRequest(String url, String
	 * method,List<NameValuePair> param) { // TODO Auto-generated method stub
	 * try { // check for request method if(method == "POST") {
	 * System.out.println(" In post Method"); DefaultHttpClient httpClient = new
	 * DefaultHttpClient(); HttpPost httpPost = new HttpPost(url);
	 * httpPost.setEntity(new UrlEncodedFormEntity(param));
	 * 
	 * HttpResponse httpResponse = httpClient.execute(httpPost); HttpEntity
	 * httpEntity = httpResponse.getEntity(); is = httpEntity.getContent();
	 * System.out.println(" In post Method"); } else if(method == "GET"){ //
	 * request method is GET DefaultHttpClient httpClient = new
	 * DefaultHttpClient(); String paramString = URLEncodedUtils.format(param,
	 * "utf-8"); url += "?" + paramString; HttpGet httpGet = new HttpGet(url);
	 * 
	 * HttpResponse httpResponse = httpClient.execute(httpGet); HttpEntity
	 * httpEntity = httpResponse.getEntity(); is = httpEntity.getContent(); }
	 * 
	 * 
	 * } catch (UnsupportedEncodingException e) { e.printStackTrace(); } catch
	 * (ClientProtocolException e) { e.printStackTrace(); } catch (IOException
	 * e) { e.printStackTrace(); }
	 * 
	 * try { BufferedReader reader = new BufferedReader(new
	 * InputStreamReader(is, "iso-8859-1"), 8); StringBuilder sb = new
	 * StringBuilder(); String line = null; while ((line = reader.readLine()) !=
	 * null) { sb.append(line + "\n"); } is.close();
	 * System.out.println(" In post Method"); json = sb.toString();
	 * Log.d("data prints", json); } catch (Exception e) { Log.e("Buffer Error",
	 * "Error converting result " + e.toString()); }
	 * 
	 * // try parse the string to a JSON object try { //jObj = new
	 * JSONObject(json); Jarray = new JSONArray(json); } catch (JSONException e)
	 * { Log.e("JSON Parser", "Error parsing data " + e.toString()); }
	 * 
	 * // return JSON String //return jObj; return Jarray;
	 * 
	 * }
	 */
	 
}
