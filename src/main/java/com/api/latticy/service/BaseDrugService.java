package com.api.latticy.service;

import com.api.latticy.model.BaseDrugModel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Jianglq
 * @Date 2021/5/20 11:29
 * @Version 1.0
 * @Email 348663490@qq.com
 */
public interface BaseDrugService extends IService<BaseDrugModel> {

    /**
     * 分页获取基药数据信息
     *
     * @param page  当前页
     * @param count 当前页数目
     * @return 用户名
     */
    IPage<BaseDrugModel> getBaseDrugAll(Integer page, Integer count);

    BaseDrugModel getBaseDrugById(Long id);

    IPage<BaseDrugModel> getBaseDrugByType(String type, Integer page, Integer count);

    List<BaseDrugModel> getBaseDrugByDrugName(String drugName);
}
