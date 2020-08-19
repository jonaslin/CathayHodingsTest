package tw.com.cathayhodings.service;

import tw.com.cathayhodings.model.DepartmentBo;

public interface DepartmentService {

    public void create(DepartmentBo departmentBo);

    public void update(DepartmentBo departmentBo);

    public void delete(String departmentId);
}
