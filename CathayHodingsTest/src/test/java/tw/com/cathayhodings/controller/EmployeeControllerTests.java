package tw.com.cathayhodings.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import tw.com.cathayhodings.entity.Department;
import tw.com.cathayhodings.entity.Employee;
import tw.com.cathayhodings.model.EmployeeBo;
import tw.com.cathayhodings.service.EmployeeService;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void testaCreateEmployee() throws Exception {
        EmployeeBo employeeBo = new EmployeeBo();
        employeeBo.setName("user1");
        employeeBo.setEmployeeId("20200001");
        employeeBo.setDepartmentId("SW1");
        employeeBo.setGender("male");
        employeeBo.setTel("1234567");
        employeeBo.setAddress("台北市信義區松仁路");
        employeeBo.setAge(25);

        Mockito.when(employeeService.create(employeeBo)).thenReturn(Optional.of(employeeBo));

        String url = "/employee";
        String content = "{\"name\":\"user1\",\"employeeId\":\"20200001\",\"departmentId\":\"SW1\",\"gender\":\"male\",\"tel\":\"1234567\",\"address\":\"台北市信義區松仁路\",\"age\":25}";
        String expectContent = "{\"message\":\"success\"}";
        mockMvc.perform(MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON).content(content)
                .accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectContent));
    }

    @Test
    void updateEmployee() throws Exception {
        EmployeeBo employeeBo = new EmployeeBo();
        employeeBo.setName("user1");
        employeeBo.setEmployeeId("20200001");
        employeeBo.setDepartmentId("SW1");
        employeeBo.setGender("male");
        employeeBo.setTel("3332221");
        employeeBo.setAddress("台北市信義區松仁路");
        employeeBo.setAge(25);

        Mockito.when(employeeService.update(employeeBo)).thenReturn(Optional.of(employeeBo));

        String url = "/employee";
        String content = "{\"name\":\"user1\",\"employeeId\":\"20200001\",\"departmentId\":\"SW1\",\"gender\":\"male\",\"tel\":\"3332221\",\"address\":\"台北市信義區松仁路\",\"age\":25}";
        String expectContent = "{\"message\":\"success\"}";
        mockMvc.perform(MockMvcRequestBuilders.patch(url).contentType(MediaType.APPLICATION_JSON).content(content)
                .accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectContent));
    }

    @Test
    void deleteEmployee() throws Exception {
        String employeeId = "20200001";

        Mockito.when(employeeService.delete(employeeId)).thenReturn(true);

        String url = "/employee/" + employeeId;
        String expectContent = "{\"message\":\"success\"}";
        mockMvc.perform(MockMvcRequestBuilders.delete(url).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectContent));
    }

    @Test
    void queryEmployee() throws Exception {
        String employeeName = null;
        String employeeId = null;
        int employeeAge = 25;
        String departmentName = null;
        int pageNum = 0;
        int pageSize = 10;

        List<Employee> employeeList = new ArrayList<Employee>();
        Employee employee = new Employee();
        employee.setName("user1");
        employee.setEmployeeId("20200001");
        employee.setGender("male");
        employee.setTel("1234567");
        employee.setAddress("台北市信義區松仁路");
        employee.setAge(employeeAge);

        Department department = new Department();
        department.setDepartmentId("SW1");
        department.setName("software-1");
        employee.setDepartment(department);

        employeeList.add(employee);

        Mockito.when(employeeService.query(employeeName, employeeId, employeeAge, departmentName, pageNum, pageSize))
                .thenReturn(employeeList);

        String url = "/employee";
        String expectContent = "[{\"name\":\"user1\",\"employeeId\":\"20200001\",\"department\":{\"departmentId\":\"SW1\",\"name\":\"software-1\"},\"gender\":\"male\",\"tel\":\"1234567\",\"address\":\"台北市信義區松仁路\",\"age\":25,\"createTime\":null,\"modifyTime\":null}]";
        mockMvc.perform(MockMvcRequestBuilders.get(url).param("employeeAge", String.valueOf(employeeAge))
                .param("pageNum", String.valueOf(pageNum))).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectContent));
    }
}
