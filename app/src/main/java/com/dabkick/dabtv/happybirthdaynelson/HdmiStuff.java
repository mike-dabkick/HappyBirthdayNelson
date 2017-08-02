package com.dabkick.dabtv.happybirthdaynelson;


import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import java.io.File;
import java.util.Scanner;
import java.util.List;

public class HdmiStuff {

    public class HdmiSrcTypeDetails { }

    public class HdmiSrcInfo {
        public HdmiSrcInfo(String l, int s, String h) { label = l; srcNo = s; hwPath = h; }
        CharSequence label;
        int srcNo;
        CharSequence hwPath;
        HdmiSrcTypeDetails deets;
    }

    /**
     * Checks device switch files to see if an HDMI device/MHL device is plugged in, returning true if so.
     */
    private static boolean IsHdmiSwitchSet() {
        // The file '/sys/devices/virtual/switch/hdmi/state' holds an int -- if it's 1 then an
        // HDMI device is connected. An alternative file to check is '/sys/class/switch/hdmi/state'
        // which exists instead on certain devices.
        File switchFile = new File("/sys/devices/virtual/switch/hdmi/state");
        //File switchFile = new File(getText(R.string.hdmi_state0));
        if (!switchFile.exists()) {
            switchFile = new File("/sys/class/switch/hdmi/state");
        }
        try {
            Scanner switchFileScanner = new Scanner(switchFile);
            int switchValue = switchFileScanner.nextInt();
            switchFileScanner.close();
            return switchValue > 0;
        } catch (Exception e) {
            return false;
        }
    }


    public class HdmiListener extends BroadcastReceiver {

        //private static final String HDMIINTENT = R.string.hdmi_intent;
        public static final String HDMIINTENT = "android.intent.action.HDMI_PLUGGED";

        @Override
        public void onReceive(Context ctxt, Intent receivedIt) {
            String action = receivedIt.getAction();
            if (action.equals(HDMIINTENT)) {
                boolean state = receivedIt.getBooleanExtra("state", false);
                if (state) {
                    Log.d("HDMIListener", "BroadcastReceiver.onReceive() : Connected HDMI-TV");
                    Toast.makeText(ctxt, "HDMI >> ", Toast.LENGTH_LONG).show();
                } else {
                    Log.d("HDMIListener", "HDMI >>: Disconected HDMI-TV");
                    Toast.makeText(ctxt, "HDMI DisConnected>>", Toast.LENGTH_LONG).show();
                }
            }

        }
    }

}