package com.api.latticy.controller.v1;

import com.api.latticy.dto.book.CreateOrUpdateBookDTO;
import com.api.latticy.model.BaseDrugModel;
import com.api.latticy.model.BookDO;
import com.api.latticy.service.BaseDrugService;
import com.api.latticy.service.BookService;
import com.api.latticy.vo.CreatedVO;
import com.api.latticy.vo.DeletedVO;
import com.api.latticy.vo.UpdatedVO;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.core.annotation.GroupRequired;
import io.github.talelin.core.annotation.PermissionMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

/**
 * @Author Jianglq
 * @Date 2021/5/20 11:16
 * @Version 1.0
 * @Email 348663490@qq.com
 */
@RestController
@RequestMapping("/base")
@Validated
public class BaseDrugController {

    @Autowired
    private BaseDrugService baseDrugService;

    @GetMapping("/{id}")
    public List<BaseDrugModel> getBase(@PathVariable(value = "id")
                                       @Positive(message = "{id.positive}") Long id){
        List<BaseDrugModel> baseDrug = baseDrugService.getBaseDrugById(id);
        if(baseDrug == null){
            throw new NotFoundException("基药数据未找到", 10022);
        }
        return baseDrug;
    }
}
