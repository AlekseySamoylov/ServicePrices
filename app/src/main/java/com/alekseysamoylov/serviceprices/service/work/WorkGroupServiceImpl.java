package com.alekseysamoylov.serviceprices.service.work;

import com.alekseysamoylov.serviceprices.model.work.WorkGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alekseysamoylov on 11/26/16.
 */

public class WorkGroupServiceImpl implements WorkGroupService{
    @Override
    public List<WorkGroup> parseAll(String jsonData) {
        System.out.println("hi " + jsonData);
        List<WorkGroup> workGroupList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject jsonWorkObject = jsonArray.getJSONObject(i);
                Long id = jsonWorkObject.getLong("id");
                String title = jsonWorkObject.getString("title");

                System.out.println("hello " + id + title);
                WorkGroup workGroup = new WorkGroup();
                workGroup.setId(id);
                workGroup.setTitle(title);
                workGroupList.add(workGroup);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return workGroupList;
    }
}
