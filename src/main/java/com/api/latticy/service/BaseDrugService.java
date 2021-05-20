package com.api.latticy.service;

import com.api.latticy.model.BaseDrugModel;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Jianglq
 * @Date 2021/5/20 11:29
 * @Version 1.0
 * @Email 348663490@qq.com
 */
public interface BaseDrugService {

    public List<BaseDrugModel> getBaseDrugById(Long id);
}
