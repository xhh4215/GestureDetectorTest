package com.example.xiaoheihei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{
    Button button;
    private GestureDetector mGestureDetetor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.buttonid);
        mGestureDetetor = new GestureDetector(new MyGestureListener());
        //mGestureDetetor = new GestureDetector(new MySimpleGestureListener());
        mGestureDetetor.setOnDoubleTapListener(new MyDoubleTapListener());
        button.setOnTouchListener(this);
        button.setClickable(true);
        button.setLongClickable(true);
        button.setFocusable(true);


    }
    /*
    * 在onTouch()方法中，我们调用GestureDetector的onTouchEvent()方法，将捕捉到的MotionEvent交给GestureDetector
    * 来分析是否有合适的callback函数来处理用户的手势
    */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return mGestureDetetor.onTouchEvent(motionEvent);
    }
    class MyGestureListener implements GestureDetector.OnGestureListener{

        @Override
        public boolean onDown(MotionEvent motionEvent) {
            Toast.makeText(MainActivity.this, "onDown", Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {
            Toast.makeText(MainActivity.this, "onShowPress", Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Toast.makeText(MainActivity.this, "onSingleTapUp", Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Toast.makeText(MainActivity.this, "onScroll", Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {
            Toast.makeText(MainActivity.this, "onLongPress", Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            Toast.makeText(MainActivity.this, "onFling", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    class MyDoubleTapListener implements GestureDetector.OnDoubleTapListener{

        @Override
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Toast.makeText(MainActivity.this, "onSingleTapConfirmed", Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent motionEvent) {
            Toast.makeText(MainActivity.this, "onDoubleTap", Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            Toast.makeText(MainActivity.this, "onDoubleTapEvent", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    class MySimpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        /*****OnGestureListener的函数*****/
        public boolean onDown(MotionEvent e) {
            Log.i("MyGesture", "onDown");
            Toast.makeText(MainActivity.this, "onDown", Toast.LENGTH_SHORT)
                    .show();
            return false;
        }

        public void onShowPress(MotionEvent e) {
            Log.i("MyGesture", "onShowPress");
            Toast.makeText(MainActivity.this, "onShowPress", Toast.LENGTH_SHORT)
                    .show();
        }

        public boolean onSingleTapUp(MotionEvent e) {
            Log.i("MyGesture", "onSingleTapUp");
            Toast.makeText(MainActivity.this, "onSingleTapUp",
                    Toast.LENGTH_SHORT).show();
            return true;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            Log.i("MyGesture", "onScroll:" + (e2.getX() - e1.getX()) + "   "
                    + distanceX);
            Toast.makeText(MainActivity.this, "onScroll", Toast.LENGTH_LONG)
                    .show();

            return true;
        }

        public void onLongPress(MotionEvent e) {
            Log.i("MyGesture", "onLongPress");
            Toast.makeText(MainActivity.this, "onLongPress", Toast.LENGTH_LONG)
                    .show();
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            Log.i("MyGesture", "onFling");
            Toast.makeText(MainActivity.this, "onFling", Toast.LENGTH_LONG)
                    .show();
            return true;
        }

        /*****OnDoubleTapListener的函数*****/
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.i("MyGesture", "onSingleTapConfirmed");
            Toast.makeText(MainActivity.this, "onSingleTapConfirmed",
                    Toast.LENGTH_LONG).show();
            return true;
        }

        public boolean onDoubleTap(MotionEvent e) {
            Log.i("MyGesture", "onDoubleTap");
            Toast.makeText(MainActivity.this, "onDoubleTap", Toast.LENGTH_LONG)
                    .show();
            return true;
        }

        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.i("MyGesture", "onDoubleTapEvent");
            Toast.makeText(MainActivity.this, "onDoubleTapEvent",
                    Toast.LENGTH_LONG).show();
            return true;
        }

    }
}
