package tw.com.cathayhodings.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeBo {

    private String name;

    private String employeeId;

    private String departmentId;

    private String gender;

    private String tel;

    private String address;

    private int age;

    private Date createTime;

    private Date modifyTime;
}
