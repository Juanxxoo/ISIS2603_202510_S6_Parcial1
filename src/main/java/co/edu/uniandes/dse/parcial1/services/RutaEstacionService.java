package co.edu.uniandes.dse.parcial1.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.parcial1.entities.EstacionEntity;
import co.edu.uniandes.dse.parcial1.entities.RutaEntity;
import co.edu.uniandes.dse.parcial1.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcial1.repositories.EstacionRepository;
import co.edu.uniandes.dse.parcial1.repositories.RutaRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class RutaEstacionService {
    
    @Autowired
    EstacionRepository estacionRepository;

    @Autowired
    RutaRepository rutaRepository;

    @Transactional
    public EstacionEntity addEstacionRuta (Long estacionId, Long rutaId) throws EntityNotFoundException, IllegalOperationException {
		log.info("Inicia proceso de agregar una asociación entre ruta y estación ", rutaId);
		Optional<RutaEntity> rutaEntity = rutaRepository.findById(rutaId);
		Optional<EstacionEntity> estacionEntity = estacionRepository.findById(estacionId);

        if (estacionEntity.isEmpty())
			throw new EntityNotFoundException("No se encontró la estación deseada.");

		if (rutaEntity.isEmpty())
			throw new EntityNotFoundException("No se encontró la ruta deseada.");


		estacionEntity.get().getRutas().add(rutaEntity.get());
		log.info("Termina proceso de agregar una asociación entre ruta y estación", estacionId);
		return estacionEntity.get();
	}

    @Transactional
    public EstacionEntity removeEstacionRuta (Long estacionId, Long rutaId) throws EntityNotFoundException, IllegalOperationException {
		log.info("Inicia proceso de remover una asociación entre ruta y estación ", rutaId);
		Optional<RutaEntity> rutaEntity = rutaRepository.findById(rutaId);
		Optional<EstacionEntity> estacionEntity = estacionRepository.findById(estacionId);

        if (estacionEntity.isEmpty())
			throw new EntityNotFoundException("No se encontró la estación deseada.");

		if (rutaEntity.isEmpty())
			throw new EntityNotFoundException("No se encontró la ruta deseada.");


		estacionEntity.get().getRutas().remove(rutaEntity.get());
		log.info("Termina proceso de remover una asociación entre ruta y estación", estacionId);
		return estacionEntity.get();
	}



    
    
}
