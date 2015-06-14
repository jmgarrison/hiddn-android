package com.hiddn.app;

import dagger.Module;

@Module(
    addsTo = HiddnModule.class,
    includes = {},
    overrides = true
)
public final class InternalReleaseHiddnModule {
}