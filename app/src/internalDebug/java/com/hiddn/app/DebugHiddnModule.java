package com.hiddn.app;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
    addsTo = HiddnModule.class,
    library = true,
    includes = {},
    overrides = true
)
public class DebugHiddnModule {

    // Low-tech flag to force certain debug build behaviors when running in an instrumentation test.
    // This value is used in the creation of singletons so it must be set before the graph is created.
    static boolean instrumentationTest = false;

    @Provides  @Singleton @IsInstrumentationTest boolean provideIsInstrumentationTest() {
        return instrumentationTest;
    }

}
