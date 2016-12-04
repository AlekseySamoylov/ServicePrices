package com.alekseysamoylov.serviceprices.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alekseysamoylov.serviceprices.R;
import com.alekseysamoylov.serviceprices.activities.work.WorkListViewActivity;
import com.alekseysamoylov.serviceprices.model.async.AsyncResponse;
import com.alekseysamoylov.serviceprices.service.async.HttpAsyncTask;


public class MainActivity extends AppCompatActivity implements AsyncResponse {

    HttpAsyncTask asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asyncTask  = new HttpAsyncTask(this);

    }

    //TODO: (asamoylov) Create Enum for it!!!
    public void goWorkToList(View view) {
        Intent workListIntent = new Intent(this, WorkListViewActivity.class);
        switch (view.getId()) {
            case R.id.engineButton:
                workListIntent.putExtra("groupId", 1L);
                startActivity(workListIntent);
                break;
            case R.id.suspensionButton:
                workListIntent.putExtra("groupId", 2L);
                startActivity(workListIntent);
                break;
            case R.id.electricButton:
                workListIntent.putExtra("groupId", 3L);
                startActivity(workListIntent);
                break;
            case R.id.tireButton:
                workListIntent.putExtra("groupId", 4L);
                startActivity(workListIntent);
                break;
            case R.id.diagnosticsButton:
                workListIntent.putExtra("groupId", 5L);
                startActivity(workListIntent);
                break;
            default:
                workListIntent.putExtra("groupId", 6L);
                startActivity(workListIntent);
        }
    }

    @Override
    public void processFinish(String output) {
    }
}
