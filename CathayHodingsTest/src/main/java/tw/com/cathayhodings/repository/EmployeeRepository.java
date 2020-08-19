package tw.com.cathayhodings.repository;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import tw.com.cathayhodings.entity.Employee;

public class EmployeeRepository implements PagingAndSortingRepository<Employee, String> {

    private static Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(Employee arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll(Iterable<? extends Employee> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteById(String arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean existsById(String arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterable<Employee> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Employee> findAllById(Iterable<String> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Employee> findById(String arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Employee> S save(S arg0) {
        // TODO Auto-generated method stub
        EmployeeRepository.logger.debug("save");
        return null;
    }

    @Override
    public <S extends Employee> Iterable<S> saveAll(Iterable<S> arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Employee> findAll(Sort arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Employee> findAll(Pageable arg0) {
        // TODO Auto-generated method stub
        return null;
    }
}
