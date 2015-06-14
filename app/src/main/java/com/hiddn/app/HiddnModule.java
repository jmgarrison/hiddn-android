package com.hiddn.app;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
    library = true, // TODO: Remove once Application injection is in use
    includes = {},
    injects = {
        HiddnApp.class
    }
)
public class HiddnModule {
    private final HiddnApp app;

    public HiddnModule(HiddnApp app) {
        this.app = app;
    }

    @Provides @Singleton Application provideApplication() {
        return app;
    }
}
