package com.example.leon.videocodec;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class CameraView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder surfaceHolder;
    private Canvas canvas;
    private boolean isRunning;

    public CameraView(Context context) {
        super(context);
        init();
    }

    private void init() {
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isRunning = true;
        new Thread((Runnable) this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void run()
    {
        long start = System.currentTimeMillis();
        while (isRunning)
        {
            draw();
        }
    }

    public void draw()
    {
        canvas = surfaceHolder.lockCanvas();
        if (canvas != null)
        {
            canvas.drawARGB(10,10,10,10);
        }
    }
}
