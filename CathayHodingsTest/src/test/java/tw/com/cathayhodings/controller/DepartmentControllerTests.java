package tw.com.cathayhodings.controller;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import tw.com.cathayhodings.model.DepartmentBo;
import tw.com.cathayhodings.service.DepartmentService;

@SpringBootTest
@AutoConfigureMockMvc
class DepartmentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    @Test
    void createDepartment() throws Exception {
        DepartmentBo departmentBo = new DepartmentBo();
        departmentBo.setDepartmentId("SW1");
        departmentBo.setName("software1");

        Mockito.when(departmentService.create(departmentBo)).thenReturn(Optional.of(departmentBo));

        String url = "/department";
        String content = "{\"departmentId\":\"SW1\",\"name\":\"software1\"}";
        String expectContent = "{\"message\":\"success\"}";
        mockMvc.perform(MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON).content(content)
                .accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectContent));
    }

    @Test
    void updateDepartment() throws Exception {
        DepartmentBo departmentBo = new DepartmentBo();
        departmentBo.setDepartmentId("SW1");
        departmentBo.setName("software-1");

        Mockito.when(departmentService.update(departmentBo)).thenReturn(Optional.of(departmentBo));

        String url = "/department";
        String content = "{\"departmentId\":\"SW1\",\"name\":\"software-1\"}";
        String expectContent = "{\"message\":\"success\"}";
        mockMvc.perform(MockMvcRequestBuilders.patch(url).contentType(MediaType.APPLICATION_JSON).content(content)
                .accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectContent));
    }

    @Test
    void deleteDepartment() throws Exception {
        String departmentId = "SW1";

        Mockito.when(departmentService.delete(departmentId)).thenReturn(true);

        String url = "/department/" + departmentId;
        String expectContent = "{\"message\":\"success\"}";
        mockMvc.perform(MockMvcRequestBuilders.delete(url).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectContent));
    }
}
