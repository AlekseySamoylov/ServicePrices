package com.alekseysamoylov.serviceprices.service.work;

import com.alekseysamoylov.serviceprices.model.work.Work;

import java.util.List;

/**
 * Created by alekseysamoylov on 11/27/16.
 */

public interface WorkService {

    /**
     * Возвращает список Работ из Json'a
     *
     * @param jsonData
     * @return
     */
    public List<Work> parseJsonToWorkList(String jsonData);
}
