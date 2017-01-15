package com.alekseysamoylov.serviceprices.activities.work;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import com.alekseysamoylov.serviceprices.R;
import com.alekseysamoylov.serviceprices.model.async.AsyncResponse;
import com.alekseysamoylov.serviceprices.model.widget.WorkListViewAdapter;
import com.alekseysamoylov.serviceprices.model.work.Work;
import com.alekseysamoylov.serviceprices.service.async.HttpAsyncTask;
import com.alekseysamoylov.serviceprices.service.work.WorkService;
import com.alekseysamoylov.serviceprices.service.work.WorkServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.alekseysamoylov.serviceprices.util.RestConstants.WORKS_BY_GROUP_URL;

/**
 * Activity for Works list view
 */
public class WorkListViewActivity extends Activity implements AsyncResponse {
    // Declare Variables
    ListView list;
    WorkListViewAdapter adapter;
    EditText editsearch;
    List<Work> workList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.work_list_view_activity);


        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);


        Work work = new Work.Builder().title("Loading...").build();

        workList.add(work);
        // Pass results to ListViewAdapter Class
        adapter = new WorkListViewAdapter(this, workList);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (EditText) findViewById(R.id.search);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });

        HttpAsyncTask httpAsyncTask = new HttpAsyncTask(this);
        Bundle bundle = getIntent().getExtras();
        Long groupId = bundle.getLong("groupId");
        System.out.println("hello id " + groupId);
        httpAsyncTask.execute(String.format(WORKS_BY_GROUP_URL, groupId));
    }

    @Override
    public void processFinish(String output) {
        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        WorkService workService = new WorkServiceImpl();
        workList = workService.parseJsonToWorkList(output);
        // Pass results to ListViewAdapter Class
        adapter = new WorkListViewAdapter(this, workList);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (EditText) findViewById(R.id.search);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });
    }
}
