package tw.com.cathayhodings.service;

import java.util.Optional;

import tw.com.cathayhodings.model.DepartmentBo;

public interface DepartmentService {

    public Optional<DepartmentBo> create(DepartmentBo departmentBo);

    public Optional<DepartmentBo> update(DepartmentBo departmentBo);

    public boolean delete(String departmentId);
}
