package com.OCare.dao;

import com.OCare.entity.Relative;

/**
 * Created by fowafolo on 15/7/28.
 */
public interface RelativeDAO extends IGeneralDAO<Relative>{
    public Relative queryByPhoneNum(String phoneNum);
}
