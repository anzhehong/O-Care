package com.OCare.service;


import com.OCare.entity.ElderMonitor;

import java.util.List;

/**
 * Created by fowafolo on 15/7/29.
 */

public interface VerifyService {
    /*
        功能：监护人提交监护某老人的申请
        参数：监护人ID，老人Id，两人合照字符串
        返回值：无
     */
    public void submitMonitorApply(String relativeId, String elderId,String togetherImg);

    /*
        功能：管理员审核监护人提出的监护老人的申请
        参数：申请Id,是否同意，false为不同意，true为同意，这个值由管理员传入
        返回值：无
     */
    public void checkMonitorApply(int elderMonitorId, int isApproval);

    /*
        功能：列出所有未处理的监护人请求，即type为3的ElderMonitor的集合
        参数：无
        返回值：所有type为3，即未处理的请求。
     */
    public List<ElderMonitor> getAllUntreatedRequests();

    public ElderMonitor getRequestByID(int requestid);

    public List<ElderMonitor> monitorStatus(String relativeId);
}
