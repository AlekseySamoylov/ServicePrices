package com.alekseysamoylov.serviceprices.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alekseysamoylov.serviceprices.R;
import com.alekseysamoylov.serviceprices.model.AsyncResponse;
import com.alekseysamoylov.serviceprices.service.HttpAsyncTask;

import static com.alekseysamoylov.serviceprices.util.RestConstants.WORKS_BY_GROUP;

/**
 * Список работ определенной группы
 */

public class WorkListActivity extends AppCompatActivity implements AsyncResponse {

    private TextView workInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.work_list_activity);
        workInfo = (TextView) findViewById(R.id.workInfo);


        HttpAsyncTask httpAsyncTask = new HttpAsyncTask(this);
        Bundle bundle = getIntent().getExtras();
        Long groupId = bundle.getLong("groupId");
        System.out.println("hello id" + groupId);
        httpAsyncTask.execute(String.format(WORKS_BY_GROUP, groupId));
    }

    @Override
    public void processFinish(String output) {
        workInfo.setText(output);
    }
}
