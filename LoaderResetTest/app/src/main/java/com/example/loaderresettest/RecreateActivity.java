package com.example.loaderresettest;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class RecreateActivity extends AppCompatActivity {

    private static final String TAG = "RecreateActivity";

    private static boolean FINISH_ON_CREATE = false;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getLoaderManager().initLoader(0, null, new LoaderCallbacks<Object>() {
            @Override
            public Loader<Object> onCreateLoader(final int i, final Bundle bundle) {
                return new ExampleLoader(RecreateActivity.this);
            }

            @Override
            public void onLoadFinished(final Loader<Object> loader, final Object o) {
                Log.d(TAG, "Callback: loader finished");
            }

            @Override
            public void onLoaderReset(final Loader<Object> loader) {
                Log.d(TAG, "Callback: loader reset");
            }
        });

        if (FINISH_ON_CREATE) {
            finish();
        }

        findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View view) {
                FINISH_ON_CREATE = true;
                recreate();
            }
        });
    }
}
