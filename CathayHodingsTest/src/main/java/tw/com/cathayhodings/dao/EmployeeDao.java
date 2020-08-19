package tw.com.cathayhodings.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tw.com.cathayhodings.entity.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, String> {
}
