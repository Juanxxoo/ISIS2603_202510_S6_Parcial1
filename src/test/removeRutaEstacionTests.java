import co.edu.uniandes.dse.parcial1.services.RutaEstacionService;

@DataJpaTest
@Transactional
@Import(RutaEstacionService.class)
public class removeRutaEstacionTests {

    @Autowired
    RutaEstacionService rutaEstacionService;

    @BeforeEach
    void setUp() {
        estacion = new EstacionEntity();
        estacion.setName("Estación 1");
        estacion.setCapacidad(120);
        estacion.setRutas(new ArrayList<>());
        entityManager.persist(estacion);
        rutaNocturna = new RutaEntity();
        rutaNocturna.setNombre("Ruta Nocturna ");
        nuevaRuta = new RutaEntity();
        otraRuta.setNombre("Ruta Diurna 1");
        estacion.getRutas().add(rutaNocturna);
        rutaNocturna.getEstaciones().add(estacion);

    }


    @Test
    void testRemoveRutaEstacion1() throws EntityNotFoundException, IllegalOperationException {
        nuevaRuta.getEstaciones().add(estacion);
        estacion.getRutas().add(nuevaRuta);
        entityManager.persist(estacion);
        estacionRutaService.removeEstacionRuta(estacion.getId(), nuevaRuta.getId());
        assertFalse(estacion.getRutas().contains(nuevaRuta));
    }

    @Test
    void testRemoveRutaEstacion2() {
        assertThrows(EntityNotFoundException.class, () -> {
            RutaEstacionService.removeRutaEstacion(0L, rutaNocturna.getId());
        });
    }


    }
