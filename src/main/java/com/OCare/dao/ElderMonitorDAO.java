package com.OCare.dao;

import com.OCare.entity.ElderMonitor;

import java.util.List;

/**
 * Created by fowafolo on 15/7/31.
 */
public interface ElderMonitorDAO extends IGeneralDAO<ElderMonitor> {

    /*
        列出所有未处理的监护人请求，即type为3的ElderMonitor的集合
     */
    public List<ElderMonitor> getAllUntreatedRequests();
    public List<ElderMonitor> queryByRelativeId(String relativeId);
}
