package com.OCare.service;

import com.OCare.dao.*;
import com.OCare.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by fowafolo on 15/7/29.
 */

@Service
@Transactional
public class VerifyServiceImp implements VerifyService {

    @Autowired
    private ElderMonitorDAO elderMonitorDAO;
    @Autowired
    private ElderDAO elderDAO;
    @Autowired
    private RelativeDAO relativeDAO;
    @Autowired
    private VolunteerDAO volunteerDAO;
    @Autowired
    private LegalPersonDAO legalPersonDAO;

    public void submitMonitorApply(String relativeId, String elderId, String togetherImg) {
        ElderMonitor newRelation = new ElderMonitor();
        System.out.println("elderID:"+elderId);
        newRelation.setElder_id(elderId);
        newRelation.setRelative_id(relativeId);
        newRelation.setTogetherImg(togetherImg);
        //在申请状态ElderMonitor里的type应为4
        newRelation.setType(3);
        //添加到数据库
        elderMonitorDAO.insert(newRelation);
    }

    @Override
    public void checkMonitorApply(int elderMonitorId, int isApproval) {
        //首先根据id拿到数据库中的elderMonitor
        ElderMonitor monitorToUpdate = elderMonitorDAO.getById(elderMonitorId);
        //审批不同意，ElderMonitor里的type应为4
        if (isApproval == 4){
            monitorToUpdate.setType(4);
            elderMonitorDAO.update(monitorToUpdate);
        }
        else if( isApproval==1||isApproval==2){
            //审批同意，ElderMonitor里的type应为1，意味监护人
            monitorToUpdate.setType(1);
            elderMonitorDAO.update(monitorToUpdate);
        }else {
            monitorToUpdate.setType(3);
            elderMonitorDAO.update(monitorToUpdate);
        }
    }

    @Override
    public List<ElderMonitor> getAllUntreatedRequests() {
        return elderMonitorDAO.getAllUntreatedRequests();
    }

    @Override
    public ElderMonitor getRequestByID(int requestid) {return elderMonitorDAO.getById(requestid); }

    @Override
    public List<ElderMonitor> monitorStatus(String relativeId) {
        return elderMonitorDAO.queryByRelativeId(relativeId);
    }


    /*
        1表示监护类型为监护人；
        2表示监护类型为普通亲戚；
        3表示在申请监护人;
        4表示申请监护人被拒绝;
        5表示亲属关系;
        6代表邻居关系;
        7.代表原来有关系现在没关系了
     */
    @Override
    public boolean changeRelationBetweenElderAndSomebody(String elderId, String sbPhoneNum, int newRelationType) {
        boolean flag = false;
        String sbId = getIdByPhoneNum(sbPhoneNum);
        ArrayList<ElderMonitor> elderMonitorList = elderMonitorDAO.getMonitorByElderIdAndSbId(elderId, sbId);
        Iterator<ElderMonitor> iterator = elderMonitorList.iterator();
        while (iterator.hasNext())
        {
            ElderMonitor elderMonitor = iterator.next();
            //取到有效值,默认只有一条非有效值
            if (elderMonitor.getType() != 7)
            {
                elderMonitor.setType(newRelationType);
                elderMonitorDAO.update(elderMonitor);
                flag = true;
            }
        }

        return flag;
    }

    @Override
    public boolean deleteRelationBetweenElderAndSomebody(String elderId, String sbPhoneNum) {
        boolean flag = false;
        String sbId = getIdByPhoneNum(sbPhoneNum);
        ArrayList<ElderMonitor> elderMonitorList = elderMonitorDAO.getMonitorByElderIdAndSbId(elderId, sbId);
        Iterator<ElderMonitor> iterator = elderMonitorList.iterator();
        while (iterator.hasNext())
        {
            ElderMonitor elderMonitor = iterator.next();
            //取到有效值,默认只有一条非有效值
            if (elderMonitor.getType() != 7)
            {
                elderMonitor.setType(7);
                elderMonitorDAO.update(elderMonitor);
                flag = true;
            }
        }

        return flag;
    }

    public String getIdByPhoneNum(String phoneNum)
    {
        String idToGet = "";
        Elder elder = elderDAO.queryByPhoneNum(phoneNum);
        Relative relative = relativeDAO.queryByPhoneNum(phoneNum);
        Volunteer volunteer = volunteerDAO.queryByPhoneNum(phoneNum);
        LegalPerson legalPerson = legalPersonDAO.queryByPhoneNum(phoneNum);
        if (elder != null)
        {
            idToGet = elder.getId();
        }else if (relative != null)
        {
            idToGet = relative.getId();
        }else if (volunteer != null)
        {
            idToGet = volunteer.getId();
        }else if (legalPerson != null)
        {
            idToGet = legalPerson.getId();
        }

        return idToGet;
    }

}
