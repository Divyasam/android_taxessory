package com.example.android.taxassory.webservice;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

//import android.app.ProgressDialog;

public class Constant_method
{


	public static int TYPE_WIFI = 1;
	public static int TYPE_MOBILE = 2;
	public static int TYPE_NOT_CONNECTED = 0;
	public static final int  imageSize = 1024;

	public static String Get_id(Context c)
	{
		TelephonyManager telephonyManager = (TelephonyManager)c.getSystemService(Context.TELEPHONY_SERVICE);

		//String IMEI =telephonyManager.getDeviceId();
		//String id = Secure.getString(c.getContentResolver(),Secure.ANDROID_ID);
		//System.out.println(" Ud id " + id);
		return "";//IMEI;
	}
	public static void display_dialog(Activity a,String title,String message)
	{
		final AlertDialog alertDialog = new AlertDialog.Builder(a).create();

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage(message);

        alertDialog.setButton("OK", new DialogInterface.OnClickListener()
        {
                public void onClick(DialogInterface dialog, int which)
                {
                // Write your code here to execute after dialog closed
                //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                }
        });
		//onPostExecute("");
		 alertDialog.show();
	}
//	public static int getConnectivityStatus(Context context) {
//		ConnectivityManager cm = (ConnectivityManager) context
//				.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//		if (null != activeNetwork) {
//			if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
//				return TYPE_WIFI;
//
//			if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
//				return TYPE_MOBILE;
//		}
//		return TYPE_NOT_CONNECTED;
//	}

//	public static boolean checkConn(Context ctx)
//	{
//		 ConnectivityManager connectivity = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
//         if (connectivity != null)
//         {
//             NetworkInfo[] info = connectivity.getAllNetworkInfo();
//             if (info != null)
//                 for (int i = 0; i < info.length; i++)
//                     if (info[i].getState() == NetworkInfo.State.CONNECTED)
//                     {
//                         return true;
//                     }
//
//         }
//         return false;
//	}

	public static JSONObject Errer_jsonobject()
	{
		//return null;
		JSONObject json=null;
		try {
			String s = "{\"status\":\"faliar\",\"error\":\"Please Contact your Service Provide Or please Check your internet Connection\"}";
			 json= new JSONObject(s);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	public static JSONArray Errer_jsonarray()
	{
		JSONArray json=null;
		try {
			 json= new JSONArray("[]");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;

		//return null;
	}
	public static boolean inetAddr()
	{
	    boolean x1 = false;
	    try
	    {
	        Socket s = new Socket("utcnist.colorado.edu", 37);
	        InputStream i = s.getInputStream();
	        Scanner scan = new Scanner(i);
	        while(scan.hasNextLine())
	        {
	            System.out.println(scan.nextLine());
	            x1 = true;
	        }
	    }
	    catch (Exception e)
	    {
	            x1 = false;
	    }
	    return x1;
	}
	public String cu_time()
	{
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
	}
//	public static String get_mobile(Context c)
//	{
//		TelephonyManager tm = (TelephonyManager)c.getSystemService(Context.TELEPHONY_SERVICE);
//		 return tm.getLine1Number();
//	}
//
//	public static String get_UDID(Context c)
//	{
//		TelephonyManager telephonyManager = (TelephonyManager)c.getSystemService(Context.TELEPHONY_SERVICE);
//		return telephonyManager.getDeviceId();
//	}


//	public static boolean checkPermission(Activity context) {
//
//		if (Build.VERSION.SDK_INT >= 23) {
//			List<String> permissionsNeeded = new ArrayList<String>();
//
//			final List<String> permissionsList = new ArrayList<String>();
//			if (!addPermission(permissionsList, Manifest.permission.ACCESS_FINE_LOCATION, context))
//				permissionsNeeded.add("GPS");
//			if (!addPermission(permissionsList, Manifest.permission.READ_PHONE_STATE, context))
//				permissionsNeeded.add("Read Phone State");
//			if (!addPermission(permissionsList, Manifest.permission.CAMERA, context))
//				permissionsNeeded.add("Write Camera");
//			if (!addPermission(permissionsList, Manifest.permission.WRITE_EXTERNAL_STORAGE, context))
//				permissionsNeeded.add("Write External Storage");
//			if (permissionsList.size() > 0) {
//				if (permissionsNeeded.size() > 0) {
//					context.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
//							1234);
//					return false;
//				}
//				context.requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),
//						1234);
//				return false;
//			}
//			return true;
//		}
//		return true;
//	}
//	private static boolean addPermission(List<String> permissionsList, String permission, Context context) {
//		if (context.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
//			permissionsList.add(permission);
//		}
//		return true;
//	}


	public static String get_Time()
	{
		//2016-04-05 11:03:51
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		return  sdf.format(cal.getTime());
	}

//	public static String getCurrentLocation(Context context)
//	{
//		String job = "";
//
//		LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
//		List<String> providers = lm.getProviders(true);
//		Location l = null;
//
//		for (int i = 0; i < providers.size(); i++) {
//			l = lm.getLastKnownLocation(providers.get(i));
//			if (l != null) {
//				job = "{\\\"lat\\\":\\\""+l.getLatitude()+"\\\",\\\"lng\\\":\\\""+l.getLongitude()+"\\\"}";
//			}
//		}
//		return job;
//	}


	/*public String getLocation(Context mContext) {
		try {
			LocationManager locationManager = (LocationManager) mContext
					.getSystemService(Context.LOCATION_SERVICE);

			boolean isGPSEnabled = false;
			boolean isNetworkEnabled = false;
			boolean canGetLocation = false;
			Location location;

			// getting GPS status
			isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
			Log.v("isGPSEnabled", "=" + isGPSEnabled);
			// getting network status
			isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
			Log.v("isNetworkEnabled", "=" + isNetworkEnabled);

			if (isGPSEnabled == false && isNetworkEnabled == false) {
				// no network provider is enabled
			} else {
				canGetLocation = true;
				if (isNetworkEnabled) {
					location=null;
					locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1,1, this);
					Log.d("Network", "Network");
					if (locationManager != null) {
						location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
						if (location != null) {
							*//*latitude = location.getLatitude();
							longitude = location.getLongitude();*//*
						}
					}
				}
				// if GPS Enabled get lat/long using GPS Services
				if (isGPSEnabled) {
					location=null;
					if (location == null) {
						locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1,1, this);
						Log.d("GPS Enabled", "GPS Enabled");
						if (locationManager != null) {
							location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
							if (location != null) {
								*//*latitude = location.getLatitude();
								longitude = location.getLongitude();*//*
							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}*/

	/*public static JSONObject getCurrentLocation(Context context)
	{
		JSONObject job = new JSONObject();

		LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		List<String> providers = lm.getProviders(true);
		Location l = null;

		for (int i = 0; i < providers.size(); i++) {
			l = lm.getLastKnownLocation(providers.get(i));
			if (l != null) {
				try {
					job.put("lat",l.getLatitude());
					job.put("lng",l.getLongitude());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		return job;
	}*/

}
