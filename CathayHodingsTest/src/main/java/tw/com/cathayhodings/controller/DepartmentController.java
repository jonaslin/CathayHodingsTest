package tw.com.cathayhodings.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.cathayhodings.model.DepartmentBo;
import tw.com.cathayhodings.model.ResponseVo;
import tw.com.cathayhodings.service.DepartmentService;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    /**
     * 新增部門資料
     */
    @PostMapping
    public ResponseVo createDepartment(@RequestBody DepartmentBo departmentBo) {
        DepartmentController.logger.debug("create " + departmentBo.toString());

        Optional<DepartmentBo> bo = departmentService.create(departmentBo);
        ResponseVo vo = new ResponseVo();
        if (bo.isPresent()) {
            vo.setMessage("success");
        } else {
            vo.setMessage("fail");
        }

        return vo;
    }

    /**
     * 更新部門資料
     */
    @PatchMapping
    public ResponseVo updateDepartment(@RequestBody DepartmentBo departmentBo) {
        DepartmentController.logger.debug("update " + departmentBo.toString());

        Optional<DepartmentBo> bo = departmentService.update(departmentBo);
        ResponseVo vo = new ResponseVo();
        if (bo.isPresent()) {
            vo.setMessage("success");
        } else {
            vo.setMessage("fail");
        }

        return vo;
    }

    /**
     * 刪除部門資料
     */
    @DeleteMapping("{departmentId}")
    public ResponseVo deleteDepartment(@PathVariable String departmentId) {
        DepartmentController.logger.debug("delete " + departmentId);

        boolean isSuccess = departmentService.delete(departmentId);
        ResponseVo vo = new ResponseVo();
        if (isSuccess) {
            vo.setMessage("success");
        } else {
            vo.setMessage("fail");
        }

        return vo;
    }
}
