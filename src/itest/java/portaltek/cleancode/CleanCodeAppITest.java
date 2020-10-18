package portaltek.cleancode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CleanCodeAppITest {

    @Autowired
    ApplicationContext ctx;

    @Test
    public void contextLoads(){
        //assertNotNull(null, "FROM I_TEST!");
        assertNotNull(ctx);
    }



}