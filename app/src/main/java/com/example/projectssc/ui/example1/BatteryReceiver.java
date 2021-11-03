package com.example.projectssc.ui.example1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.BatteryManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.projectssc.MainActivity;
import com.example.projectssc.R;

public class BatteryReceiver extends BroadcastReceiver {

    private String percentageLabel;
    private String statusLabel;

    public String getPercentageLabel() {
        return percentageLabel;
    }

    public String getStatusLabel() {
        return statusLabel;
    }

    public Drawable getBatteryImage() {
        return batteryImage;
    }

    private Drawable batteryImage;
    @Override
    public void onReceive(Context context, Intent intent) {



        String action = intent.getAction();
        if (action != null && action.equals(Intent.ACTION_BATTERY_CHANGED)) {

            // Status
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            String message = "";

            switch (status) {
                case BatteryManager.BATTERY_STATUS_FULL:
                    message = "Full";
                    break;
                case BatteryManager.BATTERY_STATUS_CHARGING:
                    message = "Încărcare";
                    break;
                case BatteryManager.BATTERY_STATUS_DISCHARGING:
                    message = "Descărcare";
                    break;
                case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                    message = "Nu se încarcă";
                    break;
                case BatteryManager.BATTERY_STATUS_UNKNOWN:
                    message = "Unknown";
                    break;
            }
            statusLabel=message;


            // Percentage
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int percentage = level * 100 / scale;
            percentageLabel=percentage + "%";


            // Image
            Resources res = context.getResources();
            batteryImage = res.getDrawable(R.drawable.b100);
            if (percentage >= 90) {
                batteryImage=res.getDrawable(R.drawable.b100);

            } else if (90 > percentage && percentage >= 65) {
                batteryImage=res.getDrawable(R.drawable.b75);

            } else if (65 > percentage && percentage >= 40) {
                batteryImage=res.getDrawable(R.drawable.b50);

            } else if (40 > percentage && percentage >= 15) {
                batteryImage=res.getDrawable(R.drawable.b25);

            } else {
                batteryImage=res.getDrawable(R.drawable.b0);

            }

        }
    }


}
