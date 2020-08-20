package tw.com.cathayhodings.service;

import java.util.List;
import java.util.Optional;

import tw.com.cathayhodings.entity.Employee;
import tw.com.cathayhodings.model.EmployeeBo;

public interface EmployeeService {

    public Optional<EmployeeBo> create(EmployeeBo employeeBo);

    public Optional<EmployeeBo> update(EmployeeBo employeeBo);

    public boolean delete(String employeeId);

    public List<Employee> query(String employeeName, String employeeId, int employeeAge, String departmentName,
            int pageNum, int pageSize);
}
