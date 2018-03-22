package com.uki.kp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import io.saeid.fabloading.LoadingView;

/**
 * Created by uki408 on 18. 3. 22.
 */

public class LoadingActivity extends Activity {

    private LoadingView mLoadingView;
    private LoadingView mLoadViewLong;
    private LoadingView mLoadViewNoRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_view);

        /* uki::fab-loading */
        mLoadingView = (LoadingView) findViewById(R.id.loading_view_repeat);

        int loading_1 = R.drawable.loading_1;
        int loading_2 = R.drawable.loading_2;
        int loading_3 = R.drawable.loading_3;
        int loading_4 = R.drawable.loading_4;

        mLoadingView.addAnimation(Color.parseColor("#FFD200"), loading_1,
                LoadingView.FROM_LEFT);
        mLoadingView.addAnimation(Color.parseColor("#2F5DA9"), loading_2,
                LoadingView.FROM_TOP);
        mLoadingView.addAnimation(Color.parseColor("#FF4218"), loading_3,
                LoadingView.FROM_RIGHT);
        mLoadingView.addAnimation(Color.parseColor("#C7E7FB"), loading_4,
                LoadingView.FROM_BOTTOM);

        mLoadingView.addListener(new LoadingView.LoadingListener() {
            @Override
            public void onAnimationStart(int currentItemPosition) {

            }

            @Override
            public void onAnimationRepeat(int nextItemPosition) {

            }

            @Override
            public void onAnimationEnd(int nextItemPosition) {

            }
        });
        mLoadViewNoRepeat = (LoadingView) findViewById(R.id.loading_view);
        mLoadViewNoRepeat.addAnimation(Color.parseColor("#2F5DA9"), loading_2, LoadingView.FROM_LEFT);
        mLoadViewNoRepeat.addAnimation(Color.parseColor("#FF4218"), loading_3, LoadingView.FROM_LEFT);
        mLoadViewNoRepeat.addAnimation(Color.parseColor("#FFD200"), loading_1, LoadingView.FROM_RIGHT);
        mLoadViewNoRepeat.addAnimation(Color.parseColor("#C7E7FB"), loading_4, LoadingView.FROM_RIGHT);

        mLoadViewLong = (LoadingView) findViewById(R.id.loading_view_long);
        mLoadViewLong.addAnimation(Color.parseColor("#FF4218"), loading_3, LoadingView.FROM_TOP);
        mLoadViewLong.addAnimation(Color.parseColor("#C7E7FB"), loading_4, LoadingView.FROM_BOTTOM);
        mLoadViewLong.addAnimation(Color.parseColor("#FF4218"), loading_3, LoadingView.FROM_TOP);
        mLoadViewLong.addAnimation(Color.parseColor("#C7E7FB"), loading_4, LoadingView.FROM_BOTTOM);
        startLoading();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    public void pause(View v) {
        mLoadingView.pauseAnimation();
        startLoading();
        mLoadViewLong.pauseAnimation();
        mLoadViewNoRepeat.pauseAnimation();
    }

    public void start(View v) {
        mLoadingView.startAnimation();
        mLoadViewLong.startAnimation();
        mLoadViewNoRepeat.startAnimation();
    }

    public void resume(View v) {
        mLoadingView.resumeAnimation();
        mLoadViewLong.resumeAnimation();
        mLoadViewNoRepeat.resumeAnimation();
    }

    private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

}