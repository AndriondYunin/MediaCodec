package com.example.leon.videocodec;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

public class CameraActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    //视图内部类
    class MyView extends SurfaceView implements SurfaceHolder.Callback,Runnable{
        private SurfaceHolder holder;
        private boolean isRunning = true;
        private Canvas canvas = null;

        public MyView(Context context) {
            super(context);
            holder = this.getHolder();
            holder.addCallback(this);
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {

        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            new Thread(this).start();
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            isRunning = false;
        }

        @Override
        public void run() {
            int count = 0;
            int x = 0,y = 0;
            while (isRunning)
            {
                try {
                    canvas = holder.lockCanvas();
                    //draw something
                    canvas.drawColor(Color.BLACK);
                    Paint p = new Paint();
                    p.setColor(Color.CYAN);
                    p.setTextSize(100);
                    canvas.drawText("定时器: " + (count++) + "秒", x, ((y++)%18+1)*100, p);
                    // 睡眠时间为1秒
                    Thread.sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (null != canvas) {
                        holder.unlockCanvasAndPost(canvas);
                    }
                }
            }
        }
    }

}
