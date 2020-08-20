package tw.com.cathayhodings.dao;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import tw.com.cathayhodings.entity.Employee;

@Repository
public interface EmployeeDao extends PagingAndSortingRepository<Employee, String>, QuerydslPredicateExecutor<Employee> {
}
