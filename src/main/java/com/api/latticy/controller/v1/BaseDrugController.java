package com.api.latticy.controller.v1;

import com.api.latticy.common.mybatis.Page;
import com.api.latticy.common.util.PageUtil;
import com.api.latticy.dto.book.CreateOrUpdateBookDTO;
import com.api.latticy.model.BaseDrugModel;
import com.api.latticy.model.BookDO;
import com.api.latticy.service.BaseDrugService;
import com.api.latticy.service.BookService;
import com.api.latticy.vo.CreatedVO;
import com.api.latticy.vo.DeletedVO;
import com.api.latticy.vo.PageResponseVO;
import com.api.latticy.vo.UpdatedVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;

/**
 * @Author Jianglq
 * @Date 2021/5/20 11:16
 * @Version 1.0
 * @Email 348663490@qq.com
 */
@RestController
@RequestMapping("api/base")
@Validated
public class BaseDrugController {

    @Autowired
    private BaseDrugService baseDrugService;

    @GetMapping("/{id}")
    public BaseDrugModel getBase(@PathVariable(value = "id")
                                     @Positive(message = "{id.positive}") Long id){
        BaseDrugModel baseDrug = baseDrugService.getBaseDrugById(id);
        if(baseDrug == null){
            throw new NotFoundException("基药数据未找到", 11001);
        }
        return baseDrug;
    }


    @GetMapping("/type/{type}")
    public PageResponseVO<BaseDrugModel> getBaseByType(@PathVariable(value = "type")
                                       @NotBlank() String type,
                                             @RequestParam(required = false, defaultValue = "0")
                                             @Min(value = 0) Integer page,
                                             @RequestParam(required = false, defaultValue = "10")
                                             @Min(value = 1) @Max(value = 20) Integer count){
        IPage<BaseDrugModel> iPage = baseDrugService.getBaseDrugByType(type, page, count);
        return PageUtil.build(iPage);
    }

    @GetMapping("/all")
    public PageResponseVO<BaseDrugModel> getBases(@RequestParam(required = false, defaultValue = "0")
                                                    @Min(value = 0) Integer page,
                                                    @RequestParam(required = false, defaultValue = "10")
                                                    @Min(value = 1) @Max(value = 30) Integer count){
        // 分页对象
        IPage<BaseDrugModel> iPage = baseDrugService.getBaseDrugAll(page, count);
        return PageUtil.build(iPage);
    }

    @GetMapping("/drugName/{drugName}")
    public List<BaseDrugModel> getBaseByDrugName(@PathVariable(value = "drugName")
                                       @NotBlank() String drugName){
        List<BaseDrugModel> baseDrug = baseDrugService.getBaseDrugByDrugName(drugName);
        if(baseDrug == null){
            throw new NotFoundException("基药数据未找到", 11001);
        }
        return baseDrug;
    }
}
