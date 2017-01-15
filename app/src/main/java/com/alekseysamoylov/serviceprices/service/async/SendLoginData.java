package com.alekseysamoylov.serviceprices.service.async;

import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by alekseysamoylov on 1/15/17.
 */

public class SendLoginData extends AsyncTask<Void, Void, Void> {
    String resultString = null;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            String myURL = "http://site.ru/";
            String parammetrs = "param1=1&param2=XXX";
            byte[] data = null;
            InputStream is = null;

            try {
                URL url = new URL(myURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setDoInput(true);

                conn.setRequestProperty("Content-Length", "" + Integer.toString(parammetrs.getBytes().length));
                OutputStream os = conn.getOutputStream();
                data = parammetrs.getBytes("UTF-8");
                os.write(data);
                data = null;

                conn.connect();
                int responseCode = conn.getResponseCode();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                if (responseCode == 200) {
                    is = conn.getInputStream();

                    byte[] buffer = new byte[8192]; // Такого вот размера буфер
                    // Далее, например, вот так читаем ответ
                    int bytesRead;
                    while ((bytesRead = is.read(buffer)) != -1) {
                        baos.write(buffer, 0, bytesRead);
                    }
                    data = baos.toByteArray();
                    resultString = new String(data, "UTF-8");
                } else {
                }


            } catch (MalformedURLException e) {

                //resultString = "MalformedURLException:" + e.getMessage();
            } catch (IOException e) {

                //resultString = "IOException:" + e.getMessage();
            } catch (Exception e) {

                //resultString = "Exception:" + e.getMessage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
