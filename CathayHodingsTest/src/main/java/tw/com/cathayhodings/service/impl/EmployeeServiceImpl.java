package tw.com.cathayhodings.service.impl;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.cathayhodings.dao.EmployeeDao;
import tw.com.cathayhodings.entity.Employee;
import tw.com.cathayhodings.model.EmployeeBo;
import tw.com.cathayhodings.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 新增員工資料
     */
    @Override
    public void create(EmployeeBo employeeBo) {
        EmployeeServiceImpl.logger.debug("create");

        String employeeId = employeeBo.getEmployeeId();
        Optional<Employee> employee = employeeDao.findById(employeeId);
        if (!employee.isPresent()) {
            employeeBo.setCreateTime(new Date());
            save(employeeBo);
        } else {
            EmployeeServiceImpl.logger.info("already exists (" + employeeId + ")");
        }
    }

    /**
     * 更新員工資料
     */
    @Override
    public void update(EmployeeBo employeeBo) {
        EmployeeServiceImpl.logger.debug("update");

        String employeeId = employeeBo.getEmployeeId();
        Optional<Employee> employee = employeeDao.findById(employeeId);
        if (employee.isPresent()) {
            employeeBo.setCreateTime(employee.get().getCreateTime());
            employeeBo.setModifyTime(new Date());
            save(employeeBo);
        } else {
            EmployeeServiceImpl.logger.info("not found (" + employeeId + ")");
        }
    }

    /**
     * 刪除員工資料
     */
    @Override
    public void delete(String employeeId) {
        EmployeeServiceImpl.logger.debug("delete " + employeeId);

        Optional<Employee> employee = employeeDao.findById(employeeId);
        if (employee.isPresent())
            employeeDao.deleteById(employeeId);
        else
            EmployeeServiceImpl.logger.info("not found (" + employeeId + ")");
    }

    private void save(EmployeeBo employeeBo) {
        Employee employee = new Employee();
        employee.setName(employeeBo.getName());
        employee.setEmployeeId(employeeBo.getEmployeeId());
        employee.setDepartmentId(employeeBo.getDepartmentId());
        employee.setGender(employeeBo.getGender());
        employee.setTel(employeeBo.getTel());
        employee.setAddress(employeeBo.getAddress());
        employee.setAge(employeeBo.getAge());
        employee.setCreateTime(employeeBo.getCreateTime());
        employee.setModifyTime(employeeBo.getModifyTime());

        employeeDao.save(employee);
    }
}
