package tw.com.cathayhodings.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.cathayhodings.dao.DepartmentDao;
import tw.com.cathayhodings.entity.Department;
import tw.com.cathayhodings.model.DepartmentBo;
import tw.com.cathayhodings.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private static Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 新增部門資料
     */
    @Override
    public Optional<DepartmentBo> create(DepartmentBo departmentBo) {
        DepartmentServiceImpl.logger.debug("create");

        String departmentId = departmentBo.getDepartmentId();
        Optional<Department> department = departmentDao.findById(departmentId);
        if (!department.isPresent()) {
            save(departmentBo);
            return Optional.of(departmentBo);
        } else {
            DepartmentServiceImpl.logger.info("already exists (" + departmentId + ")");
            return Optional.empty();
        }
    }

    /**
     * 更新部門資料
     */
    @Override
    public Optional<DepartmentBo> update(DepartmentBo departmentBo) {
        DepartmentServiceImpl.logger.debug("update");

        String departmentId = departmentBo.getDepartmentId();
        Optional<Department> department = departmentDao.findById(departmentId);
        if (department.isPresent()) {
            save(departmentBo);
            return Optional.of(departmentBo);
        } else {
            DepartmentServiceImpl.logger.info("not found (" + departmentId + ")");
            return Optional.empty();
        }
    }

    /**
     * 刪除部門資料
     */
    @Override
    public boolean delete(String departmentId) {
        DepartmentServiceImpl.logger.debug("delete " + departmentId);

        Optional<Department> department = departmentDao.findById(departmentId);
        if (department.isPresent()) {
            departmentDao.deleteById(departmentId);
            return true;
        } else {
            DepartmentServiceImpl.logger.info("not found (" + departmentId + ")");
            return false;
        }
    }

    private void save(DepartmentBo departmentBo) {
        Department department = new Department();
        department.setDepartmentId(departmentBo.getDepartmentId());
        department.setName(departmentBo.getName());

        departmentDao.save(department);
    }
}
