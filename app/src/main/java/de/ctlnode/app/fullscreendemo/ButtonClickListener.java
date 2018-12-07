package de.ctlnode.app.fullscreendemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ButtonClickListener implements View.OnClickListener {

    private Context context;

    ButtonClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        View main = ((Activity) this.context).findViewById(R.id.main_view);
        FloatingActionButton button = ((Activity) this.context).findViewById(R.id.button_fullscreen);
        AppBarLayout appbar = ((Activity) this.context).findViewById(R.id.appbar);

        if (main.getSystemUiVisibility() == View.SYSTEM_UI_FLAG_VISIBLE) {
            // hide navigation and status bar
            int visibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            main.setSystemUiVisibility(visibility);
            main.setBackgroundColor(Color.BLACK);

            if (appbar != null) {
                appbar.setExpanded(false, false);
            }

            button.setImageResource(R.drawable.baseline_fullscreen_exit_white_48);
        } else {
            int visibility = View.SYSTEM_UI_FLAG_VISIBLE;
            main.setSystemUiVisibility(visibility);
            main.setBackgroundResource(R.color.colorPrimary);

            if (appbar != null) {
                appbar.setExpanded(true, false);
            }

            button.setImageResource(R.drawable.baseline_fullscreen_white_48);
        }
    }
}
