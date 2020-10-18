package portaltek.cleancode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class CleanCodeAppIT2 {

    @Autowired
    ApplicationContext ctx;

    @Test
    public void contextLoads(){
        Assertions.assertNotNull(null, "FROM INT_TEST!");
        Assertions.assertNotNull(ctx);
    }



}