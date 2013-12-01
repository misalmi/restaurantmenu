package uni.oulu.hci.restaurantmenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class TabMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menutab);
        @SuppressWarnings("unchecked")
		final ArrayList<HashMap<String,String>> data = (ArrayList<HashMap<String, String>>) getIntent().getSerializableExtra("data");
        populateScrollView(data);
    }
    
    private void populateScrollView(ArrayList<HashMap<String,String>> data) {
    	LinearLayout scrollViewLayout = (LinearLayout)findViewById(R.id.scrollViewLayout);
    	
    	for (HashMap<String, String> map : data) {
    		LinearLayout item = (LinearLayout)getLayoutInflater().inflate(R.layout.smallitem, null);
    		((TextView)item.findViewById(R.id.itemTitleView)).setText(map.get("title"));
    		((TextView)item.findViewById(R.id.itemDietsView)).setText(map.get("diets"));
    		((TextView)item.findViewById(R.id.itemPriceView)).setText(map.get("price"));
    		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    		params.setMargins(0, 0, 0, 10);
    		item.setLayoutParams(params);
        	scrollViewLayout.addView(item);
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first_page, menu);
        return true;
    }
}