package tw.com.cathayhodings.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "serial_number")
    // private long serialNumber;

    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "department_id")
    private String departmentId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "tel")
    private String tel;

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private int age;

    // @Column(name = "create_time")
    // private String create_time ;

    // @Column(name = "modify_time")
    // private String modify_time ;
}
