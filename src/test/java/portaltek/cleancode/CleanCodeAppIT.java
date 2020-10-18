package portaltek.cleancode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import portaltek.cleancode.spi.datastore.model.User;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CleanCodeAppIT {

    @Autowired
    ApplicationContext ctx;

    @Test
    public void contextLoads(){
        assertNotNull(ctx);
    }
}