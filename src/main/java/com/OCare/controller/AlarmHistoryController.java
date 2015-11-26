package com.OCare.controller;

import com.OCare.entity.AlarmHistory;
import com.OCare.service.AlarmHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ma on 2015/11/10.
 */
@Controller
@RequestMapping("/app/alarm")
public class AlarmHistoryController {

    @Autowired
    private AlarmHistoryService alarmHistoryService;

    /*
       功能：于子涵
     */
    @RequestMapping("/get/set")
    @ResponseBody
    public  Map<String, Object> listAlarmHistoryBySet(int limit,int offset) {
        Map<String, Object> result = new HashMap<String, Object>();
        if(offset<1)
        {
            result.put("error", true);
            result.put("errorMsg", "ＩＮＰＵＴ　ＥＲＲＯＲ");
            return result;
        }
        List<AlarmHistory> re= (List<AlarmHistory>) alarmHistoryService.getAlarmHistory(limit,offset);

        result.put("error", false);
        result.put("re", re);
        return result;
    }
}
