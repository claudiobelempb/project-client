package br.com.surb.projectclient.services.client;

import br.com.surb.projectclient.repositories.ClientRepository;
import br.com.surb.projectclient.shared.constants.ConstantException;
import br.com.surb.projectclient.shared.exeptions.resource.ResourceNotFondExecption;
import br.com.surb.projectclient.shared.exeptions.service.ServiceDataIntegrityViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientDeleteService {
    private final ClientRepository clientRepository;

    public ClientDeleteService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void execute(Long clientId) {

        if (!clientRepository.existsById(clientId))
            throw new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND);

        try {
            clientRepository.deleteById(clientId);
        } catch (DataIntegrityViolationException e) {
            throw new ServiceDataIntegrityViolationException(ConstantException.DATA_INTEGRITY_VIOLATION);
        }

    }
}
