package bergony.ml.rest_api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RestApiApplicationTests {

    @Test
    void contextLoads() {
        RestApiApplication.main(new String[] {});
    }

}
