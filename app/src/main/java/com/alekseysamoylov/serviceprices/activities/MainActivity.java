package com.alekseysamoylov.serviceprices.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alekseysamoylov.serviceprices.R;
import com.alekseysamoylov.serviceprices.activities.bonus.BonusActivity;
import com.alekseysamoylov.serviceprices.activities.security.LoginActivity;
import com.alekseysamoylov.serviceprices.activities.security.RegistrationActivity;
import com.alekseysamoylov.serviceprices.activities.work.WorkListViewActivity;
import com.alekseysamoylov.serviceprices.model.async.AsyncResponse;
import com.alekseysamoylov.serviceprices.service.async.HttpAsyncTask;
import com.alekseysamoylov.serviceprices.util.CustomerInformation;


public class MainActivity extends AppCompatActivity implements AsyncResponse {

    HttpAsyncTask asyncTask;

    Button loginButton;
    Button registrationButton;
    Button logOutButton;
    Button bonusesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        asyncTask  = new HttpAsyncTask(this);

        loginButton = (Button) findViewById(R.id.login);
        registrationButton = (Button) findViewById(R.id.registration);
        logOutButton = (Button) findViewById(R.id.logOut);
        bonusesButton = (Button) findViewById(R.id.bonuses);
        if (CustomerInformation.userIsAuthenticated()) {
            registrationButton.setVisibility(View.GONE);
            loginButton.setVisibility(View.GONE);

        } else {
            bonusesButton.setVisibility(View.GONE);
            logOutButton.setVisibility(View.GONE);
        }

    }

    public void goToBonuses(View view) {
        Intent bonusIntent = new Intent(this, BonusActivity.class);
        startActivity(bonusIntent);
    }

    public void goToSecurity(View view) {
        Intent loginIntent = new Intent(this, LoginActivity.class);
        Intent registrationIntent = new Intent(this, RegistrationActivity.class);
        switch (view.getId()) {
            case R.id.login:
                startActivity(loginIntent);
                break;
            case R.id.registration:
                startActivity(registrationIntent);
                break;
            case R.id.logOut:
                CustomerInformation.logOut();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                break;
            default:
                startActivity(getIntent());
        }
    }

    //TODO: (asamoylov) Create Enum for it!!!
    public void goWorkToList(View view) {
        Intent workListIntent = new Intent(this, WorkListViewActivity.class);
        Intent loginIntent = new Intent(this, LoginActivity.class);
        Intent registrationIntent = new Intent(this, RegistrationActivity.class);
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
