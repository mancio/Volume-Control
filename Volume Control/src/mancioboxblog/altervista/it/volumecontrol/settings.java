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

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;



public class settings extends Activity {
	
	public void onCreate(Bundle icicle)
	   {
		
	      super.onCreate(icicle);
	      
	      //take under control settings layout
	      setContentView(R.layout.settings);
	      
	      //control radioGroup
	      buttonlistener();   
	      
	      //join button "close" with "button1"
	      Button close = (Button) findViewById(R.id.button1);
	      
	      close.setOnClickListener(new View.OnClickListener() {
	          public void onClick(View arg0) {
	          setResult(RESULT_OK);
	          finish();
	          }
	       });
	      
	   } 
	
	public void buttonlistener(){
		
		RadioGroup stream_buttons = (RadioGroup) findViewById(R.id.radio_buttons);
		
		
		
		stream_buttons.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			//take the object called "stream_control" and set it to 0 as default value
			SharedPreferences sharedPreferences = getSharedPreferences("stream_control", 0);
			//start "stream_control" object editing
			SharedPreferences.Editor editor = sharedPreferences.edit();	
			@Override
			public void onCheckedChanged(RadioGroup stream_buttons, int button) {
				switch(button){
				
				    /* save the right "stream" integer value of the depending by 
				     * stream that has to be changed
				     * "999999" is an invented stream. It's so bizarre to avoid
				     * using an API stream integer (every stream have a flag that 
				     * correspond to a particular integer in API)
				     */
					case R.id.radioButton1:
						
					    editor.putInt("stream", 3); // music stream (API integer)
					    editor.commit();
						break;
					case R.id.radioButton2:
						
					    editor.putInt("stream", 2); // phone ring stream (API integer)
					    editor.commit();
						break;
						
					case R.id.radioButton3:
						editor.putInt("stream", 999999); // all stream type (invented integer)
					    editor.commit();
						break;
				}	
			}
			
		});
		
	
	}
	
}



