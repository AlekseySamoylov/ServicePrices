package com.alekseysamoylov.serviceprices.service.work;

import com.alekseysamoylov.serviceprices.model.work.Work;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alekseysamoylov on 11/27/16.
 */

public class WorkServiceImpl implements WorkService {
    @Override
    public List<Work> parseJsonToWorkList(String jsonData) {
        List<Work> workList = new ArrayList<>();
        if (jsonData == null) {
            Work work = new Work.Builder().title("No internet connection").build();
            workList.add(work);
            return workList;
        }
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonWorkObject = jsonArray.getJSONObject(i);
                Long id = jsonWorkObject.getLong("id");
                String title = jsonWorkObject.getString("title");
                BigDecimal price = BigDecimal.valueOf(jsonWorkObject.getDouble("price"));
                String details = jsonWorkObject.getString("details");
                System.out.println("hello " + id + title + price + details);
                Work work = new Work.Builder()
                        .id(id)
                        .title(title)
                        .price(price)
                        .details(details)
                        .build();
                workList.add(work);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return workList;
    }
}
