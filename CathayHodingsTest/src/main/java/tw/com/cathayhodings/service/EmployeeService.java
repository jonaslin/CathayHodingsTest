package tw.com.cathayhodings.service;

import tw.com.cathayhodings.model.EmployeeBo;

public interface EmployeeService {

    public void create(EmployeeBo employeeBo);

    public void update(EmployeeBo employeeBo);

    public void delete(String employeeId);
}
