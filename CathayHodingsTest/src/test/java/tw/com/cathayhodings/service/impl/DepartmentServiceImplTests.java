package tw.com.cathayhodings.service.impl;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import tw.com.cathayhodings.model.DepartmentBo;
import tw.com.cathayhodings.service.DepartmentService;

@SpringBootTest
public class DepartmentServiceImplTests {

    @MockBean
    private DepartmentService departmentService;

    @Test
    void create() throws Exception {
        DepartmentBo departmentBo = new DepartmentBo();
        departmentBo.setDepartmentId("SW1");
        departmentBo.setName("software1");

        Mockito.when(departmentService.create(departmentBo)).thenReturn(Optional.of(departmentBo));

        Optional<DepartmentBo> bo = departmentService.create(departmentBo);
        Assert.assertTrue(bo.isPresent());

        DepartmentBo resultBo = bo.get();
        Assert.assertEquals(departmentBo.getDepartmentId(), resultBo.getDepartmentId());
        Assert.assertEquals(departmentBo.getName(), resultBo.getName());
    }

    @Test
    void update() throws Exception {
        DepartmentBo departmentBo = new DepartmentBo();
        departmentBo.setDepartmentId("SW1");
        departmentBo.setName("software-1");

        Mockito.when(departmentService.update(departmentBo)).thenReturn(Optional.of(departmentBo));

        Optional<DepartmentBo> bo = departmentService.update(departmentBo);
        Assert.assertTrue(bo.isPresent());

        DepartmentBo resultBo = bo.get();
        Assert.assertEquals(departmentBo.getDepartmentId(), resultBo.getDepartmentId());
        Assert.assertEquals(departmentBo.getName(), resultBo.getName());
    }

    @Test
    void delete() throws Exception {
        String departmentId = "SW1";

        Mockito.when(departmentService.delete(departmentId)).thenReturn(true);

        boolean isSuccess = departmentService.delete(departmentId);
        Assert.assertTrue(isSuccess);
    }
}
