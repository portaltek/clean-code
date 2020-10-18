package portaltek.cleancode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CleanCodeAppIT {

    @Autowired
    ApplicationContext ctx;

    @Test
    public void contextLoads(){
        System.out.println("FROM TEST!");
        //Assertions.assertNotNull(null, "FROM UNIT_TEST!");
        assertNotNull(ctx);
    }
}