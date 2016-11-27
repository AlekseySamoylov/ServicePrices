package com.alekseysamoylov.serviceprices.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alekseysamoylov.serviceprices.R;
import com.alekseysamoylov.serviceprices.model.AsyncResponse;
import com.alekseysamoylov.serviceprices.service.HttpAsyncTask;

import java.io.IOException;

import static com.alekseysamoylov.serviceprices.util.RestConstants.WORKS_BY_GROUP;


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

    /**
     * go to work
     *
     * @param view
     */
    public void goWorkList(View view) {
        Intent workListIntent = new Intent(MainActivity.this, WorkListActivity.class);
        workListIntent.putExtra("groupId", 2L);
        startActivity(workListIntent);
    }

    public void goTestList(View view) {
        Intent workListIntent = new Intent(this, WorksActivity.class);
        startActivity(workListIntent);
    }

    public void getWorks(View view) throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        Long groupId = Long.valueOf(view.getTag().toString());
        asyncTask.execute(String.format(WORKS_BY_GROUP, groupId));
        view.setVisibility(View.INVISIBLE);

    }

    @Override
    public void processFinish(String output) {
        workText.setText(output);
    }
}
