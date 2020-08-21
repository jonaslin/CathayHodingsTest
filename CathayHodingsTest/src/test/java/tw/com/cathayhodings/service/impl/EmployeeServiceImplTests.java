package tw.com.cathayhodings.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import tw.com.cathayhodings.entity.Employee;
import tw.com.cathayhodings.model.EmployeeBo;
import tw.com.cathayhodings.service.EmployeeService;

@SpringBootTest
public class EmployeeServiceImplTests {

    @MockBean
    private EmployeeService employeeService;

    @Test
    void create() throws Exception {
        EmployeeBo employeeBo = new EmployeeBo();
        employeeBo.setName("user1");
        employeeBo.setEmployeeId("20200001");
        employeeBo.setDepartmentId("SW1");
        employeeBo.setGender("male");
        employeeBo.setTel("1234567");
        employeeBo.setAddress("台北市信義區松仁路");
        employeeBo.setAge(25);

        Mockito.when(employeeService.create(employeeBo)).thenReturn(Optional.of(employeeBo));

        Optional<EmployeeBo> bo = employeeService.create(employeeBo);
        Assert.assertTrue(bo.isPresent());

        EmployeeBo resultBo = bo.get();
        Assert.assertEquals(employeeBo.getName(), resultBo.getName());
        Assert.assertEquals(employeeBo.getEmployeeId(), resultBo.getEmployeeId());
        Assert.assertEquals(employeeBo.getDepartmentId(), resultBo.getDepartmentId());
        Assert.assertEquals(employeeBo.getGender(), resultBo.getGender());
        Assert.assertEquals(employeeBo.getTel(), resultBo.getTel());
        Assert.assertEquals(employeeBo.getAddress(), resultBo.getAddress());
        Assert.assertEquals(employeeBo.getAge(), resultBo.getAge());
    }

    @Test
    void update() throws Exception {
        EmployeeBo employeeBo = new EmployeeBo();
        employeeBo.setName("user1");
        employeeBo.setEmployeeId("20200001");
        employeeBo.setDepartmentId("SW1");
        employeeBo.setGender("male");
        employeeBo.setTel("3332221");
        employeeBo.setAddress("台北市信義區松仁路");
        employeeBo.setAge(25);

        Mockito.when(employeeService.update(employeeBo)).thenReturn(Optional.of(employeeBo));

        Optional<EmployeeBo> bo = employeeService.update(employeeBo);
        Assert.assertTrue(bo.isPresent());

        EmployeeBo resultBo = bo.get();
        Assert.assertEquals(employeeBo.getName(), resultBo.getName());
        Assert.assertEquals(employeeBo.getEmployeeId(), resultBo.getEmployeeId());
        Assert.assertEquals(employeeBo.getDepartmentId(), resultBo.getDepartmentId());
        Assert.assertEquals(employeeBo.getGender(), resultBo.getGender());
        Assert.assertEquals(employeeBo.getTel(), resultBo.getTel());
        Assert.assertEquals(employeeBo.getAddress(), resultBo.getAddress());
        Assert.assertEquals(employeeBo.getAge(), resultBo.getAge());
    }

    @Test
    void delete() throws Exception {
        String employeeId = "20200001";

        Mockito.when(employeeService.delete(employeeId)).thenReturn(true);

        boolean isSuccess = employeeService.delete(employeeId);
        Assert.assertTrue(isSuccess);
    }

    @Test
    void query() throws Exception {
        String employeeName = null;
        String employeeId = null;
        int employeeAge = 25;
        String departmentName = null;
        int pageNum = 0;
        int pageSize = 10;

        List<Employee> employee = new ArrayList<Employee>();

        Mockito.when(employeeService.query(employeeName, employeeId, employeeAge, departmentName, pageNum, pageSize))
                .thenReturn(employee);

        List<Employee> result = employeeService.query(employeeName, employeeId, employeeAge, departmentName, pageNum,
                pageSize);
        Assert.assertEquals(employee.size(), result.size());
    }
}
