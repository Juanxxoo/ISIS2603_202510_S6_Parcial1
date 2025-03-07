import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import co.edu.uniandes.dse.parcial1.entities.EstacionEntity;
import co.edu.uniandes.dse.parcial1.entities.RutaEntity;
import co.edu.uniandes.dse.parcial1.services.RutaEstacionService;
import jakarta.transaction.Transactional;

@DataJpaTest
@Transactional
@Import(RutaEstacionService.class)
public class addRutaEstacionTest {

    @Autowired
    RutaEstacionService rutaEstacionService;

    @BeforeEach
    void setUp() {
        
    }

}