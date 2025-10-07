package es.unizar.webeng.lab2   // <-- pon el package correcto, el mismo que en Application.kt

import org.hamcrest.Matchers.containsString   // <-- ESTA LINEA ES LA IMPORTANTE
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get


@SpringBootTest
@AutoConfigureMockMvc
class ErrorPageTest @Autowired constructor(
    val mockMvc: MockMvc
) {

@Test
fun `custom error page is shown on 404`() {
    val result = mockMvc.get("/ruta-que-no-existe")
        .andExpect {
            status { isNotFound() }
        }
        .andReturn()

}

@Test
fun `time endpoint returns current server time`() {
    mockMvc.get("/time")
        .andExpect {
            status { isOk() }
            content { string(containsString("time")) }
        }
}


}
