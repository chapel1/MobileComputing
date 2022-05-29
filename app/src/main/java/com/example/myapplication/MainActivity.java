package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    String msg = "Activity lifecycle sq: \n";
    TextView myTextView;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = (TextView) findViewById(R.id.textView);
        mButton = (Button) findViewById(R.id.btn_add);
        //mButton.setOnClickListener(v -> {Toast.makeText(MainActivity.this, "Lambda Toast message to the user", Toast.LENGTH_SHORT).show();});
        //mButton.setOnClickListener(this::doSomething);
        mButton.setOnClickListener(new MyListenerForEventHandling());
        msg += "onCreate is called \n";
        Log.i(TAG, "onCreate is called");
    }

    class MyListenerForEventHandling implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Class Implementes OnClickLstnr Toast message to the user", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        msg += "onStart is called \n";
        Log.i(TAG, "onStart is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        msg += "onStop is called \n";
        Log.i(TAG, "onStop is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        msg += "onPause is called \n";
        Log.i(TAG, "onPause is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        msg += "onResume is called \n";
        Log.i(TAG, "onResume is called");
    }

    public void doSomething(View view) {
        myTextView.setText(msg);
        //Toast.makeText(this, "Toast message to the user", Toast.LENGTH_SHORT).show();
        Snackbar.make(view, "Snackbar msg", Snackbar.LENGTH_SHORT).
                setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "Toast message to the user", Toast.LENGTH_SHORT).show();
                            }
                        }
                ).show();
    }
}