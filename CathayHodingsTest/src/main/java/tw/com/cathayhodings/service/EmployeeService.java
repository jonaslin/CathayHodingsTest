package tw.com.cathayhodings.service;

import java.util.List;

import tw.com.cathayhodings.entity.Employee;
import tw.com.cathayhodings.model.EmployeeBo;

public interface EmployeeService {

    public void create(EmployeeBo employeeBo);

    public void update(EmployeeBo employeeBo);

    public void delete(String employeeId);

    public List<Employee> query(String employeeName, String employeeId, int employeeAge, String departmentName,
            int pageNum, int pageSize);
}
