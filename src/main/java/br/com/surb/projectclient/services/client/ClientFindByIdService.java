package br.com.surb.projectclient.services.client;

import br.com.surb.projectclient.dto.ClientDTO;
import br.com.surb.projectclient.entities.Client;
import br.com.surb.projectclient.repositories.ClientRepository;
import br.com.surb.projectclient.shared.constants.ConstantException;
import br.com.surb.projectclient.shared.exeptions.resource.ResourceNotFondExecption;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ClientFindByIdService {

    private final ClientRepository clientRepository;

    public ClientFindByIdService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional(readOnly = true)
    public ClientDTO execute(Long clientId) {
        Objects.requireNonNull(clientId);
        Client entity = clientRepository
                .findById(clientId)
                .orElseThrow(() -> new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND));
        return new ClientDTO(entity);
    }
}
