package com.api.latticy.service.impl;

import com.api.latticy.mapper.BaseDrugMapper;
import com.api.latticy.model.BaseDrugModel;
import com.api.latticy.service.BaseDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Jianglq
 * @Date 2021/5/20 11:30
 * @Version 1.0
 * @Email 348663490@qq.com
 */
@Service
public class BaseDrugServiceImpl implements BaseDrugService {

    @Autowired
    private BaseDrugMapper baseDrugMapper;

    @Override
    public List<BaseDrugModel> getBaseDrugById(Long id) {
        List<BaseDrugModel> baseDrugs = baseDrugMapper.selectBaseById(id);
        return baseDrugs;
    }
}
