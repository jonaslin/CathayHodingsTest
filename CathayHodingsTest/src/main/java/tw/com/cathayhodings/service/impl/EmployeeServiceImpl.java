package tw.com.cathayhodings.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;

import tw.com.cathayhodings.dao.DepartmentDao;
import tw.com.cathayhodings.dao.EmployeeDao;
import tw.com.cathayhodings.entity.Department;
import tw.com.cathayhodings.entity.Employee;
import tw.com.cathayhodings.entity.QDepartment;
import tw.com.cathayhodings.entity.QEmployee;
import tw.com.cathayhodings.model.EmployeeBo;
import tw.com.cathayhodings.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @PersistenceContext
    private EntityManager entityManager;

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
    @Override
    public List<Employee> query(String employeeName, String employeeId, int employeeAge, String departmentName,
            int pageNum, int pageSize) {
        EmployeeServiceImpl.logger.debug("query employeeName=" + employeeName);
        EmployeeServiceImpl.logger.debug("query employeeId=" + employeeId);
        EmployeeServiceImpl.logger.debug("query employeeAge=" + employeeAge);
        EmployeeServiceImpl.logger.debug("query departmentName=" + departmentName);

        QEmployee qemployee = QEmployee.employee;
        QDepartment qdepartment = QDepartment.department;

        BooleanBuilder builder = new BooleanBuilder();

        if (employeeName != null)
            builder.and(qemployee.name.eq(employeeName));

        if (employeeId != null)
            builder.and(qemployee.employeeId.eq(employeeId));

        if (employeeAge > 0)
            builder.and(qemployee.age.eq(employeeAge));

        if (departmentName != null)
            builder.and(qdepartment.name.eq(departmentName));

        JPAQuery<Employee> jpaQuery = new JPAQuery<Employee>(entityManager);
        jpaQuery.from(qemployee).join(qdepartment).on(qemployee.department.departmentId.eq(qdepartment.departmentId))
                .where(builder).offset(pageNum * pageSize).limit(pageSize);
        return jpaQuery.fetch();
    }

    private void save(EmployeeBo employeeBo) {
        Employee employee = new Employee();
        employee.setName(employeeBo.getName());
        employee.setEmployeeId(employeeBo.getEmployeeId());

        String departmentId = employeeBo.getDepartmentId();
        Optional<Department> departmentOpt = departmentDao.findById(employeeBo.getDepartmentId());
        if (!departmentOpt.isPresent()) {
            EmployeeServiceImpl.logger.error("Department not exist (" + departmentId + ")");
            return;
        }

        Department department = departmentOpt.get();
        employee.setDepartment(department);

        employee.setGender(employeeBo.getGender());
        employee.setTel(employeeBo.getTel());
        employee.setAddress(employeeBo.getAddress());
        employee.setAge(employeeBo.getAge());
        employee.setCreateTime(employeeBo.getCreateTime());
        employee.setModifyTime(employeeBo.getModifyTime());

        employeeDao.save(employee);
    }
}
