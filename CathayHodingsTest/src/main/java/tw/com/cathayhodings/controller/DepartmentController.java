package tw.com.cathayhodings.controller;

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
import tw.com.cathayhodings.service.DepartmentService;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService employeeService;

    /**
     * 新增部門資料
     */
    @PostMapping
    public void create(@RequestBody DepartmentBo departmentBo) {
        DepartmentController.logger.debug("create " + departmentBo.toString());

        employeeService.create(departmentBo);
    }

    /**
     * 更新部門資料
     */
    @PatchMapping
    public void update(@RequestBody DepartmentBo departmentBo) {
        DepartmentController.logger.debug("update " + departmentBo.toString());

        employeeService.update(departmentBo);
    }

    /**
     * 刪除部門資料
     */
    @DeleteMapping("{departmentId}")
    public void delete(@PathVariable String departmentId) {
        DepartmentController.logger.debug("delete " + departmentId);

        employeeService.delete(departmentId);
    }
}
