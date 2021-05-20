package com.api.latticy.mapper;

import com.api.latticy.model.BaseDrugModel;
import com.api.latticy.model.BookDO;
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
public interface BaseDrugMapper {

    List<BaseDrugModel> selectBaseById(@Param("id")Long id);
}
