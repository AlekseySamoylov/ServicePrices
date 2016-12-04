package com.alekseysamoylov.serviceprices.service.async;

import android.os.AsyncTask;

import com.alekseysamoylov.serviceprices.model.async.AsyncResponse;
import com.alekseysamoylov.serviceprices.service.work.WorkGroupService;
import com.alekseysamoylov.serviceprices.service.work.WorkGroupServiceImpl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by alekseysamoylov on 11/26/16.
 */

public class HttpAsyncTask extends AsyncTask<String, String, String> {

    public AsyncResponse delegate = null;

    public HttpAsyncTask(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(String... params) {
        System.out.println("Hello run!!");
        try {
            URL url = new URL(params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            System.out.println(urlConnection.getResponseCode());
            String test = "";
            try {
                InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                StringBuilder sBuilder = new StringBuilder();

                String line = null;
                while ((line = bReader.readLine()) != null) {
                    sBuilder.append(line + "\n");
                }
                test = sBuilder.toString();
                System.out.println("hello " + test);
                WorkGroupService workGroupService = new WorkGroupServiceImpl();
                workGroupService.parseAll(test);
                return test;
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {

        }

    return null;
    }

   @Override
    protected void onPostExecute(String result) {
       delegate.processFinish(result);
   }
}
