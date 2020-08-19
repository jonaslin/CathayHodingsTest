package tw.com.cathayhodings.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeBo {

//    private long serialNumber;

    private String name;

    private String employeeId;

    private String departmentId;

    private String gender;

    private String tel;

    private String address;

    private int age;

    // @Column(name = "create_time")
    // private String create_time ;

    // @Column(name = "modify_time")
    // private String modify_time ;
}
