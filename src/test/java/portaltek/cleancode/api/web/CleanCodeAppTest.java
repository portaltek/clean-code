package portaltek.cleancode.api.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CleanCodeAppTest {

    @Autowired
    ApplicationContext ctx;

    @Test
    public void contextLoads(){
        assertNotNull(ctx);
    }
}