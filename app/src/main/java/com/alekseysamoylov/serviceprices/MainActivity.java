package com.alekseysamoylov.serviceprices;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;

import com.alekseysamoylov.serviceprices.model.AsyncResponse;
import com.alekseysamoylov.serviceprices.service.HttpAsyncTask;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements AsyncResponse {

    private TextView workText;
    HttpAsyncTask asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workText = (TextView) findViewById(R.id.workText);
        asyncTask  = new HttpAsyncTask(this);

    }

    public void getWorks(View view) throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        asyncTask.execute("buy");

        workText.setText("hello!!!");
    }

    @Override
    public void processFinish(String output) {
        workText.setText(output);
    }
}
