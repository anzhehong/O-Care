package com.OCare.dao;

import com.OCare.entity.Elder;

/**
 * Created by fowafolo on 15/7/28.
 */
public interface ElderDAO extends IGeneralDAO<Elder> {
    public Elder queryByPhoneNum(String phoneNum);
}
