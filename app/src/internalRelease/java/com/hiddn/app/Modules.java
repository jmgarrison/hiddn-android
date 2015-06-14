package com.hiddn.app;

final class Modules {
    static Object[] list(HiddnApp app) {
        return new Object[] {
            new HiddnModule(app),
            new InternalReleaseHiddnModule()
        };
    }

    private Modules() {
        // No instances.
    }
}