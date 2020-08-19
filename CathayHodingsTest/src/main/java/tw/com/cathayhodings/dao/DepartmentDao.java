package tw.com.cathayhodings.dao;

import org.springframework.data.repository.CrudRepository;

import tw.com.cathayhodings.entity.Department;

public interface DepartmentDao extends CrudRepository<Department, String> {

}
