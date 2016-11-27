package com.alekseysamoylov.serviceprices.service;

import com.alekseysamoylov.serviceprices.model.WorkGroup;

import java.util.List;

/**
 * Created by alekseysamoylov on 11/26/16.
 */
public interface WorkGroupService {
    List<WorkGroup> parseAll(String jsonData);
}
