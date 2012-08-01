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
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class help extends Activity {
	public void onCreate(Bundle icicle)
	   {
	      super.onCreate(icicle);
	      setContentView(R.layout.help);
	      
	      Button b22 = (Button) findViewById(R.id.button22);
	      Button b11 = (Button) findViewById(R.id.button11);
	      
	      
	      //close the help page and return to the widget 
	      b22.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View arg0) {
	         setResult(RESULT_OK);
	         finish();
	         }
	      });
	      
	      // enter into my site
	      b11.setOnClickListener(new View.OnClickListener() {
	    	  public void onClick(View arg0) {
	    		  Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mancioboxblog.altervista.it"));
	    		  startActivity(browserIntent);
	 	         }
	 	      });
			
			

	   }
}
