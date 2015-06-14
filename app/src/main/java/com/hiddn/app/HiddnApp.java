package com.hiddn.app;

import android.app.Application;

import dagger.ObjectGraph;

public final class HiddnApp extends Application {

    private ObjectGraph objectGraph;

    @Override public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(Modules.list(this));
        objectGraph.inject(this);
    }

}
