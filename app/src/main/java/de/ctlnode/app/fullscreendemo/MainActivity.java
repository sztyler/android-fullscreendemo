package de.ctlnode.app.fullscreendemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set content view
        this.setContentView(R.layout.activity_main);

        // button click listener
        View button = this.findViewById(R.id.button_fullscreen);
        View.OnClickListener listener = new ButtonClickListener(this);
        button.setOnClickListener(listener);

        // set default value (not necessary)
        View main = this.findViewById(R.id.main_view);
        main.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);

        // set custom appbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        this.setSupportActionBar(toolbar);

        AppBarLayout appbar = this.findViewById(R.id.appbar);
        if (appbar != null && appbar.getLayoutParams() != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) appbar.getLayoutParams();
            AppBarLayout.Behavior appBarLayoutBehaviour = new AppBarLayout.Behavior();
            appBarLayoutBehaviour.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
                @Override
                public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                    return false;
                }
            });
            layoutParams.setBehavior(appBarLayoutBehaviour);
        }
    }
}
