package tw.com.cathayhodings.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tw.com.cathayhodings.entity.Department;

@Repository
public interface DepartmentDao extends CrudRepository<Department, String> {
}
