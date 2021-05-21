package com.api.latticy.mapper;

import com.api.latticy.common.mybatis.Page;
import com.api.latticy.model.BaseDrugModel;
import com.api.latticy.model.BookDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Jianglq
 * @Date 2021/5/20 11:40
 * @Version 1.0
 * @Email 348663490@qq.com
 */
@Repository
public interface BaseDrugMapper extends BaseMapper<BaseDrugModel> {

    IPage<BaseDrugModel> selectBaseAll(Page<BaseDrugModel> pager);

    BaseDrugModel selectBaseById(@Param("id") Long id);

    IPage<BaseDrugModel> selectBaseByType(@Param("type") String type, Page<BaseDrugModel> pager);

    List<BaseDrugModel> selectBaseByDrugName(@Param("drugName") String drugName);
}
