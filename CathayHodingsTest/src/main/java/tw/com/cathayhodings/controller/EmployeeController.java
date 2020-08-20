package tw.com.cathayhodings.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.com.cathayhodings.entity.Employee;
import tw.com.cathayhodings.model.EmployeeBo;
import tw.com.cathayhodings.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    public static final int MAX_PAGE_SIZE = 10;

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
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId) {
        EmployeeController.logger.debug("deleteEmployee " + employeeId);

        employeeService.delete(employeeId);
    }

    /**
     * 查詢員工資料
     *
     * 「動態條件」為：姓名、員工編號、年齡、部門名稱(欄位皆為選填)
     *
     * 若填寫多個欄位條件，各條件為and
     *
     * 回傳欄位為：所有欄位(包含員工及部門資料)
     *
     * 需要有分頁功能，每頁最多顯示10筆
     */
    @GetMapping
    public List<Employee> queryEmployee(@RequestParam(name = "employeeName", required = false) String employeeName,
            @RequestParam(name = "employeeId", required = false) String employeeId,
            @RequestParam(name = "employeeAge", required = false, defaultValue = "0") Integer employeeAge,
            @RequestParam(name = "departmentName", required = false) String departmentName,
            @RequestParam(name = "pageNum", required = false, defaultValue = "0") Integer pageNum) {
        EmployeeController.logger.debug("queryEmployee employeeName=" + employeeName);
        EmployeeController.logger.debug("queryEmployee employeeId=" + employeeId);
        EmployeeController.logger.debug("queryEmployee employeeAge=" + employeeAge);
        EmployeeController.logger.debug("queryEmployee departmentName=" + departmentName);
        EmployeeController.logger.debug("queryEmployee pageNum=" + pageNum);

        return employeeService.query(employeeName, employeeId, employeeAge, departmentName, pageNum,
                EmployeeController.MAX_PAGE_SIZE);
    }
}
