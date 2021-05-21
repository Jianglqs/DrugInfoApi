package com.api.latticy.service.impl;

import com.api.latticy.common.mybatis.Page;
import com.api.latticy.mapper.BaseDrugMapper;
import com.api.latticy.model.BaseDrugModel;
import com.api.latticy.service.BaseDrugService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class BaseDrugServiceImpl extends ServiceImpl<BaseDrugMapper, BaseDrugModel> implements BaseDrugService {

    @Override
    public BaseDrugModel getBaseDrugById(Long id) {
        BaseDrugModel baseDrugs = this.baseMapper.selectBaseById(id);
        return baseDrugs;
    }

    @Override
    public IPage<BaseDrugModel> getBaseDrugAll(Integer page, Integer count) {
        Page<BaseDrugModel> pager = new Page<>(page, count);
        IPage<BaseDrugModel> iPage = this.baseMapper.selectBaseAll(pager);
        return iPage;
    }

    @Override
    public IPage<BaseDrugModel> getBaseDrugByType(String type, Integer page, Integer count) {
       Page<BaseDrugModel> pager = new Page<>(page, count);
       IPage<BaseDrugModel> iPage = this.baseMapper.selectBaseByType(type, pager);
        return iPage;
    }

    @Override
    public List<BaseDrugModel> getBaseDrugByDrugName(String drugName) {
        List<BaseDrugModel> baseDrugs = this.baseMapper.selectBaseByDrugName(drugName);
        return baseDrugs;
    }
}
