/*  
    Created by Andrea Mancini 
    mail: mancio@alice.it
    date: 08/01/2012
    
	This file is part of Volume Control.

    Volume Control is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Volume Control is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Volume Control.  If not, see <http://www.gnu.org/licenses/>.
*/


package mancioboxblog.altervista.it.volumecontrol;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.widget.RemoteViews;

public class volumecontrol extends AppWidgetProvider {
	

	//intent action names
	public static String BUTTON_1 = "mancioboxblog.altervista.it.volumecontrol.volup";
	public static String BUTTON_2 = "mancioboxblog.altervista.it.volumecontrol.voldown";
	public static String BUTTON_3 = "mancioboxblog.altervista.it.volumecontrol.set";
	public static String BUTTON_4 = "mancioboxblog.altervista.it.volumecontrol.help";
	public static String BUTTON_5 = "mancioboxblog.altervista.it.volumecontrol.mute";
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		
		
		//take the right views
		RemoteViews rm = new RemoteViews(context.getPackageName(), R.layout.volumecontrol);
		
		
		// manage intent for button 1 (volume up)
		Intent  int_b1 = new Intent(context, volumecontrol.class);
		int_b1.setAction(BUTTON_1);
		PendingIntent pi_b1 = PendingIntent.getBroadcast(context, 0, int_b1, 0);
		rm.setOnClickPendingIntent(R.id.button1, pi_b1);
		////////////////////////////////
		
		// manage intent for button 2 (volume down)
		Intent  int_b2 = new Intent(context, volumecontrol.class);
		int_b2.setAction(BUTTON_2);
		PendingIntent pi_b2 = PendingIntent.getBroadcast(context, 0, int_b2, 0);
		rm.setOnClickPendingIntent(R.id.button2, pi_b2);
		////////////////////////////////
		
		// manage intent for button 3 (set)
		Intent  int_b3 = new Intent(context, volumecontrol.class);
		int_b3.setAction(BUTTON_3);
		PendingIntent pi_b3 = PendingIntent.getBroadcast(context, 0, int_b3, 0);
		rm.setOnClickPendingIntent(R.id.button3, pi_b3);
		////////////////////////////////
		
		// manage intent for button 4 (help)
		Intent  int_b4 = new Intent(context, volumecontrol.class);
		int_b4.setAction(BUTTON_4);
		PendingIntent pi_b4 = PendingIntent.getBroadcast(context, 0, int_b4, 0);
		rm.setOnClickPendingIntent(R.id.button4, pi_b4);
		////////////////////////////////
		
		// manage intent for imageButton1 (mute button)
		Intent  int_b5 = new Intent(context, volumecontrol.class);
		int_b5.setAction(BUTTON_5);
		PendingIntent pi_b5 = PendingIntent.getBroadcast(context, 0, int_b5, 0);
		rm.setOnClickPendingIntent(R.id.imageButton1, pi_b5);
		////////////////////////////////
		
		//take the Audioservice and join it to "volman" name to control volume
		AudioManager volman = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		
		//associate every stream type to an integer
	    int s1= volman.getStreamVolume(AudioManager.STREAM_SYSTEM);
		int s2= volman.getStreamVolume(AudioManager.STREAM_RING);
		int s3= volman.getStreamVolume(AudioManager.STREAM_MUSIC);
		int s4= volman.getStreamVolume(AudioManager.STREAM_ALARM);
		
		//if all the stream are muted show the "sound_off" image else "sound_on"
		if((s1+s2+s3+s4 != 0)){
			rm.setImageViewResource(R.id.imageButton1, R.drawable.sound_off);
			
		}else{
			rm.setImageViewResource(R.id.imageButton1, R.drawable.sound_on);
		}
		
		// update the widget
		appWidgetManager.updateAppWidget(appWidgetIds, rm);
		
		
		/* call onUpdate method in superclass to make an update
		 * and be sure of having right values
		 */
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		//this takes care of managing the widget
		// v1.5 fix that doesn't call onDelete Action
		final String action = intent.getAction();
		if (AppWidgetManager.ACTION_APPWIDGET_DELETED.equals(action)) {
			final int appWidgetId = intent.getExtras().getInt(
					AppWidgetManager.EXTRA_APPWIDGET_ID,
					AppWidgetManager.INVALID_APPWIDGET_ID);
			if (appWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
				this.onDeleted(context, new int[] { appWidgetId });
			}
			
		} else {
			
			/* intent setting clone. The new intent has to be reset
			 * to avoid malfunction after display rotation
			 */
			
			//---- cloned area -----//
			
			//take the right views
			RemoteViews rm = new RemoteViews(context.getPackageName(), R.layout.volumecontrol);
			
			
			// manage intent for button 1 (volume up)
			Intent  int_b1 = new Intent(context, volumecontrol.class);
			int_b1.setAction(BUTTON_1);
			PendingIntent pi_b1 = PendingIntent.getBroadcast(context, 0, int_b1, 0);
			rm.setOnClickPendingIntent(R.id.button1, pi_b1);
			////////////////////////////////
			
			// manage intent for button 2 (volume down)
			Intent  int_b2 = new Intent(context, volumecontrol.class);
			int_b2.setAction(BUTTON_2);
			PendingIntent pi_b2 = PendingIntent.getBroadcast(context, 0, int_b2, 0);
			rm.setOnClickPendingIntent(R.id.button2, pi_b2);
			////////////////////////////////
			
			// manage intent for button 3 (set)
			Intent  int_b3 = new Intent(context, volumecontrol.class);
			int_b3.setAction(BUTTON_3);
			PendingIntent pi_b3 = PendingIntent.getBroadcast(context, 0, int_b3, 0);
			rm.setOnClickPendingIntent(R.id.button3, pi_b3);
			////////////////////////////////
			
			// manage intent for button 4 (help)
			Intent  int_b4 = new Intent(context, volumecontrol.class);
			int_b4.setAction(BUTTON_4);
			PendingIntent pi_b4 = PendingIntent.getBroadcast(context, 0, int_b4, 0);
			rm.setOnClickPendingIntent(R.id.button4, pi_b4);
			////////////////////////////////
			
			// manage intent for imageButton1 (mute button)
			Intent  int_b5 = new Intent(context, volumecontrol.class);
			int_b5.setAction(BUTTON_5);
			PendingIntent pi_b5 = PendingIntent.getBroadcast(context, 0, int_b5, 0);
			rm.setOnClickPendingIntent(R.id.imageButton1, pi_b5);
			////////////////////////////////
			
			//--- finish cloned area ---//
			
			
			// call Audiomanager and assign it to volman variable
			AudioManager volman = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
			
			
			
			if(intent.getAction().equals(BUTTON_1)){
				
				//SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
			    
				//call the saved object called "stream_control" and name it "prefs"
				SharedPreferences prefs = context.getSharedPreferences("stream_control",0);
				
				/* get the value saved in "stream" voice of "prefs" object and save the
				 * integer in "stream" variable
				 */
				int stream = prefs.getInt("stream",3); // default is 3 = music stream
				
				/* if the stream value is set as "999999" change all streams else change
				 * the stream set in "stream" is it is not set by using settings panel
				 * the default value is 3 (music stream) 
				 */
				if(stream == 999999){
					volman.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_RAISE, 1);
					volman.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_RAISE, 1);
					volman.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, 1);
					volman.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_RAISE, 1);
				}else{
					volman.adjustStreamVolume(stream, AudioManager.ADJUST_RAISE, 1);
				}
				
				//associate every stream type to an integer
			    int s1= volman.getStreamVolume(AudioManager.STREAM_SYSTEM);
				int s2= volman.getStreamVolume(AudioManager.STREAM_RING);
				int s3= volman.getStreamVolume(AudioManager.STREAM_MUSIC);
				int s4= volman.getStreamVolume(AudioManager.STREAM_ALARM);
				
				
				/* if all the stream are muted after volume adjusting 
				 * show the "sound_off" image else "sound_on"
				 */
				if((s1+s2+s3+s4 != 0)){
					
				    rm.setImageViewResource(R.id.imageButton1, R.drawable.sound_off);
				    
				    
				}else{
					
				    rm.setImageViewResource(R.id.imageButton1, R.drawable.sound_on);
				    
				    
				}
				
				// widget update to change the button icon image
				ComponentName thisWidget = new ComponentName(context, volumecontrol.class);
			    AppWidgetManager manager = AppWidgetManager.getInstance(context);
			    manager.updateAppWidget(thisWidget, rm);
				
			
			}
			if(intent.getAction().equals(BUTTON_2)){
				
				SharedPreferences prefs = context.getSharedPreferences("stream_control",0);
				int stream = prefs.getInt("stream",3); // default is 3 = music stream
				
				/* if the stream value is set as "999999" change all streams else change
				 * the stream set in "stream" is it is not set by using settings panel
				 * the default value is 3 (music stream) 
				 */
				if(stream == 999999){
					volman.adjustStreamVolume(AudioManager.STREAM_SYSTEM, AudioManager.ADJUST_LOWER, 1);
					volman.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_LOWER, 1);
					volman.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, 1);
					volman.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_LOWER, 1);
				}else{
				
					volman.adjustStreamVolume(stream, AudioManager.ADJUST_LOWER, 1);
				}
				
				//associate every stream type to an integer
			    int s1= volman.getStreamVolume(AudioManager.STREAM_SYSTEM);
				int s2= volman.getStreamVolume(AudioManager.STREAM_RING);
				int s3= volman.getStreamVolume(AudioManager.STREAM_MUSIC);
				int s4= volman.getStreamVolume(AudioManager.STREAM_ALARM);
				
				/* if all the stream are muted after volume adjusting 
				 * show the "sound_off" image else "sound_on"
				 */				
				if((s1+s2+s3+s4 != 0)){
					
				    rm.setImageViewResource(R.id.imageButton1, R.drawable.sound_off);
				    
				    
				}else{
					
				    rm.setImageViewResource(R.id.imageButton1, R.drawable.sound_on);
				    
				    
				}
				
				// widget update to change the button icon image
				ComponentName thisWidget = new ComponentName(context, volumecontrol.class);
			    AppWidgetManager manager = AppWidgetManager.getInstance(context);
			    manager.updateAppWidget(thisWidget, rm);
				
			}
			
			// open settings panel 
			if(intent.getAction().equals(BUTTON_3)){
				Intent b3 = new Intent();
		        b3.setClassName("mancioboxblog.altervista.it.volumecontrol", "mancioboxblog.altervista.it.volumecontrol.settings");
		        b3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		        context.startActivity(b3);
			}
			
			// open help panel
			if(intent.getAction().equals(BUTTON_4)){
				
		        Intent b4 = new Intent();
		        b4.setClassName("mancioboxblog.altervista.it.volumecontrol", "mancioboxblog.altervista.it.volumecontrol.help");
		        b4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		        context.startActivity(b4);

			}
			
			
			
			if(intent.getAction().equals(BUTTON_5)){
				
				//associate every stream type to an integer
			    int s1= volman.getStreamVolume(AudioManager.STREAM_SYSTEM);
				int s2= volman.getStreamVolume(AudioManager.STREAM_RING);
				int s3= volman.getStreamVolume(AudioManager.STREAM_MUSIC);
				int s4= volman.getStreamVolume(AudioManager.STREAM_ALARM);
				
				//start "stream_control" object editing
				SharedPreferences prefs = context.getSharedPreferences("stream_control",0);
				SharedPreferences.Editor editor = prefs.edit();
				
				/* if all channels are not mute save previous stream volume values,
				 * set volume values to zero and change the icon image else get saved
				 * volume values and reset the volume channels
				 */
				if(s1+s2+s3+s4 != 0){
					
					
					
					editor.putInt("STREAM_SYSTEM", s1);
					editor.putInt("STREAM_RING", s2);
					editor.putInt("STREAM_MUSIC", s3);
					editor.putInt("STREAM_ALARM", s4);
				    editor.commit();
					
				    volman.setStreamVolume(AudioManager.STREAM_SYSTEM, 0, AudioManager.FLAG_SHOW_UI);
				    volman.setStreamVolume(AudioManager.STREAM_RING, 0, AudioManager.FLAG_SHOW_UI);
				    volman.setStreamVolume(AudioManager.STREAM_MUSIC, 0, AudioManager.FLAG_SHOW_UI);
				    volman.setStreamVolume(AudioManager.STREAM_ALARM, 0, AudioManager.FLAG_SHOW_UI);
				    
				    rm.setImageViewResource(R.id.imageButton1, R.drawable.sound_on);
				    
				    ComponentName thisWidget = new ComponentName(context, volumecontrol.class);
				    AppWidgetManager manager = AppWidgetManager.getInstance(context);
				    manager.updateAppWidget(thisWidget, rm);
				}else{
					
					int stream_sys = prefs.getInt("STREAM_SYSTEM",3);
					int stream_r = prefs.getInt("STREAM_RING",3);
					int stream_m = prefs.getInt("STREAM_MUSIC",3);
					int stream_a = prefs.getInt("STREAM_ALARM",3);
					
					volman.setStreamVolume(AudioManager.STREAM_SYSTEM, stream_sys, AudioManager.FLAG_SHOW_UI);
				    volman.setStreamVolume(AudioManager.STREAM_RING, stream_r, AudioManager.FLAG_SHOW_UI);
				    volman.setStreamVolume(AudioManager.STREAM_MUSIC, stream_m, AudioManager.FLAG_SHOW_UI);
				    volman.setStreamVolume(AudioManager.STREAM_ALARM, stream_a, AudioManager.FLAG_SHOW_UI);
				    
				    
				    rm.setImageViewResource(R.id.imageButton1, R.drawable.sound_off);
				    
				    ComponentName thisWidget = new ComponentName(context, volumecontrol.class);
				    AppWidgetManager manager = AppWidgetManager.getInstance(context);
				    manager.updateAppWidget(thisWidget, rm);

				    				    
				    
				}
				
			}
			

		}
		
		super.onReceive(context, intent);
	}
}

