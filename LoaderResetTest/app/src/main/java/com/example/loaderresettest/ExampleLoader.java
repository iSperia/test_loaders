package com.example.loaderresettest;

import android.content.Context;
import android.content.Loader;
import android.util.Log;

public class ExampleLoader extends Loader {

    private static final String TAG = "ExampleLoader";

    /**
     * Stores away the application context associated with context.
     * Since Loaders can be used across multiple activities it's dangerous to
     * store the context directly; always use {@link #getContext()} to retrieve
     * the Loader's Context, don't use the constructor argument directly.
     * The Context returned by {@link #getContext} is safe to use across
     * Activity instances.
     *
     * @param context used to retrieve the application context.
     */
    public ExampleLoader(final Context context) {
        super(context);
    }

    @Override
    public void reset() {
        Log.d(TAG, "Loader is reset");
        super.reset();
    }
}
