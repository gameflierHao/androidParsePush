package org.apache.cordova.core;

import android.content.Intent;
import android.content.Context;

import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;
import com.parse.ParsePushBroadcastReceiver;
import com.parse.ParsePush;



public class Receiver extends ParsePushBroadcastReceiver {
	public static String pushInfo;
    @Override
    public void onPushOpen(Context context, Intent intent) {
		if (intent.hasExtra("com.parse.Data")) {
			try {
				final JSONObject jsonData = new JSONObject(intent.getExtras().getString(
						"com.parse.Data"));
				this.pushInfo = jsonData.getString("info");
				if(this.pushInfo == null || this.pushInfo.isEmpty()){
					this.pushInfo = "";
				}
			} catch (final JSONException e) {
				
			}
		}
		else{
			this.pushInfo = "";
		}

		if(myMainActivity.activityVisible==true){
			Intent i = new Intent(context, myMainActivity.class);
			i.putExtras(intent.getExtras());
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(i);
		}
		else{
			super.onPushOpen(context, intent);
		}
		
    }
	
}

