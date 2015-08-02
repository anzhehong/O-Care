package com.OCare.service;

import com.OCare.dao.ElderDAO;
import com.OCare.dao.LegalPersonDAO;
import com.OCare.dao.RelativeDAO;
import com.OCare.dao.VolunteerDAO;
import com.OCare.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by fowafolo on 15/7/28.
 */

@Service
@Transactional
public class RegisterServiceImp implements RegisterService {

    @Autowired
    private ElderDAO elderDAO;
    @Autowired
    private RelativeDAO relativeDAO;
    @Autowired
    private VolunteerDAO volunteerDAO;
    @Autowired
    private LegalPersonDAO legalPersonDAO;

    public Elder registerForAnElder(String elderId, int companyId, String elderName, String elderPhone, String elderAddress, String elderPassword, String elderImage) {
        Elder newElder = new Elder();
        newElder.setAddress(elderAddress);
        newElder.setCompany_id(companyId);
        newElder.setId(elderId);
        newElder.setName(elderName);
        newElder.setPhone(elderPhone);
        newElder.setPassword(JavaMD5Util.MD5(elderPassword));
        newElder.setImage(elderImage);
        //插入到数据库中
        elderDAO.insert(newElder);
        return newElder;
    }

    @Override
    public Relative registerForARelative(String relativeId, String relativeName, String relativePhone, String relativeAddress, String relativePassword, String relativeImage) {
        Relative newRelative = new Relative();
        newRelative.setId(relativeId);
        newRelative.setName(relativeName);
        newRelative.setPhone(relativePhone);
        newRelative.setAddress(relativeAddress);
        newRelative.setPassword(JavaMD5Util.MD5(relativePassword));
        newRelative.setImamge(relativeImage);

        //插入数据库中
        relativeDAO.insert(newRelative);

        return newRelative;
    }

    @Override
    public Volunteer registerForAVolunteer(String volunteerId, String volunteerName, String volunteerPhone, String volunteerAddress, String volunteerEmail, int volunteerCompanyId, String volunteerPassword, String volunteerImage) {
        Volunteer newVolunteer = new Volunteer();
        newVolunteer.setId(volunteerId);
        newVolunteer.setName(volunteerName);
        newVolunteer.setPhone(volunteerPhone);
        newVolunteer.setAddress(volunteerAddress);
        newVolunteer.setEmail(volunteerEmail);
        newVolunteer.setCompany_id(volunteerCompanyId);
        newVolunteer.setPassword(JavaMD5Util.MD5(volunteerPassword));
        newVolunteer.setImage(volunteerImage);

        //存到数据库
        volunteerDAO.insert(newVolunteer);

        return newVolunteer;
    }

    @Override
    public LegalPerson registerForALegalPerson(String lpId, String lpName, String lpPhone, String lpEmail, String lpPassword, String lpImage) {
        LegalPerson newLP = new LegalPerson();
        newLP.setId(lpId);
        newLP.setName(lpName);
        newLP.setPhone(lpPhone);
        newLP.setEmail(lpEmail);
        newLP.setPassword(JavaMD5Util.MD5(lpPassword));
        newLP.setImage(lpImage);

        //插入到数据库
        legalPersonDAO.insert(newLP);

        return newLP;
    }
}
