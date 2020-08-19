package tw.com.cathayhodings.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.com.cathayhodings.model.EmployeeBo;
import tw.com.cathayhodings.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    /**
     * 新增員工資料
     */
    @PostMapping
    public void createEmployee(@RequestBody EmployeeBo employeeBo) {
        EmployeeController.logger.debug("addEmployee " + employeeBo.toString());

        employeeService.create(employeeBo);
    }

    /**
     * 更新員工資料
     */
    @PatchMapping
    public void updateEmployee(@RequestBody EmployeeBo employeeBo) {
        EmployeeController.logger.debug("updateEmployee " + employeeBo.toString());

        employeeService.update(employeeBo);
    }

    /**
     * 刪除員工資料
     */
    @DeleteMapping("{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId) {
        EmployeeController.logger.debug("deleteEmployee " + employeeId);

        employeeService.delete(employeeId);
    }

    /**
     * 查詢員工資料
     *
     */
    @GetMapping
    public Map<String, String> queryEmployee() {
        logger.info("test");
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "aa");
        map.put("2", "bb");
        return map;
    }
}
