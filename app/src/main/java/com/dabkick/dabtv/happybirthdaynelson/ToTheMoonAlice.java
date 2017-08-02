package com.dabkick.dabtv.happybirthdaynelson;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ToTheMoonAlice extends Activity {
    private static final int uiFlags = 0
	| View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
	| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
	| View.SYSTEM_UI_FLAG_IMMERSIVE
	| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
	| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
	| View.SYSTEM_UI_FLAG_LAYOUT_STABLE
	| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
	| View.SYSTEM_UI_FLAG_LOW_PROFILE;
    private View decorView;

    /* sys UI. This is to prevent the jarring behavior of controls going away
     */
    private final View.OnTouchListener mHideUITouchListener =
	new View.OnTouchListener() {
	    @Override
	    public boolean onTouch(View view, MotionEvent motionEvent) {
		decorView.setSystemUiVisibility(uiFlags);
            return false;
        }
    };

    // bg mgr looks like it's in the v17 leanback lib
    // private void prepareBackgroundManager() {
    //     mBgMgr = BackgroundManager.getInstance(getActivity());
    // }

    @Override
    public void onResume() {
    	super.onResume();
	    decorView.setSystemUiVisibility(uiFlags);
    }

    @Override   public void onPause() { super.onPause(); }
    @Override   public void onStop() { super.onStop(); }
    @Override   public void onStart() { super.onStart(); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //eLog
        // lockOrientation//

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(uiFlags);
        setContentView(R.layout.activity_to_the_moon_alice);
    }

    //private HwManager hwmgr;
    private List<HdmiStuff.HdmiSrcInfo> sources;

    public void findSrcs() {
        //hwmgr = getHwManager();
        // blah blah blah
    }


    private ListView list;
    private void loadListView() {
        list = (ListView) findViewById(R.id.ins_list);
        // more blah blah blah
        ArrayAdapter<HdmiStuff.HdmiSrcInfo> adapter = new ArrayAdapter<HdmiStuff.HdmiSrcInfo>(this, R.layout.src_button, sources);
    }

}
