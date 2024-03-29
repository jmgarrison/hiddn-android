package com.hiddn.app;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import android.support.test.runner.AndroidJUnitRunner;

import static android.content.Context.KEYGUARD_SERVICE;
import static android.content.Context.POWER_SERVICE;
import static android.os.PowerManager.ACQUIRE_CAUSES_WAKEUP;
import static android.os.PowerManager.FULL_WAKE_LOCK;
import static android.os.PowerManager.ON_AFTER_RELEASE;

public final class HiddnTestRunner extends AndroidJUnitRunner {

    @Override public void onStart() {
        DebugHiddnModule.instrumentationTest = true;

        runOnMainSync(new Runnable() {
            @SuppressWarnings("deprecation") // We don't care about deprecation here.
            @Override public void run() {
                Context app = getTargetContext().getApplicationContext();

                String name = HiddnTestRunner.class.getSimpleName();
                // Unlock the device so that the tests can input keystrokes.
                KeyguardManager keyguard = (KeyguardManager) app.getSystemService(KEYGUARD_SERVICE);
                keyguard.newKeyguardLock(name).disableKeyguard();
                // Wake up the screen.
                PowerManager power = (PowerManager) app.getSystemService(POWER_SERVICE);
                power.newWakeLock(FULL_WAKE_LOCK | ACQUIRE_CAUSES_WAKEUP | ON_AFTER_RELEASE, name)
                        .acquire();
            }
        });

        super.onStart();
    }

}