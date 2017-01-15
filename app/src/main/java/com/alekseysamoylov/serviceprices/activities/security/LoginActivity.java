package com.alekseysamoylov.serviceprices.activities.security;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alekseysamoylov.serviceprices.R;
import com.alekseysamoylov.serviceprices.activities.MainActivity;
import com.alekseysamoylov.serviceprices.model.async.AsyncResponse;
import com.alekseysamoylov.serviceprices.service.async.HttpAsyncTask;
import com.alekseysamoylov.serviceprices.util.CustomerInformation;

import static com.alekseysamoylov.serviceprices.util.RestConstants.WORKS_BY_GROUP_URL;

/**
 * Created by alekseysamoylov on 1/8/17.
 */

public class LoginActivity extends Activity implements AsyncResponse {
    Button loginButton;
    EditText userName, password;

    //    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginButton = (Button) findViewById(R.id.loginButton);
        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

//        tx1 = (TextView)findViewById(R.id.textView3);
//        tx1.setVisibility(View.GONE);

        final Intent mainActivity = new Intent(this, MainActivity.class);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (userName.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();

                    CustomerInformation.logIn(4L);
                    startActivity(mainActivity);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();


                    if (counter == 0) {
                        loginButton.setEnabled(false);
                    }
                }
            }
        });


    }

    private void loginRequest() {
        HttpAsyncTask httpAsyncTask = new HttpAsyncTask(this);
        Bundle bundle = getIntent().getExtras();
        Long groupId = bundle.getLong("groupId");
        System.out.println("hello id " + groupId);
        httpAsyncTask.execute(String.format(WORKS_BY_GROUP_URL, groupId));
    }

    @Override
    public void processFinish(String output) {

    }
}