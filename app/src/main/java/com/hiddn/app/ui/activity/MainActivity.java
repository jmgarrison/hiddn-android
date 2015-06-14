package com.hiddn.app.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.hiddn.R;
import com.hiddn.app.ui.fragment.MainFragment;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            setContentView(R.layout.activity_main);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_fragment, new MainFragment())
                    .commit();
        }
    }
}
