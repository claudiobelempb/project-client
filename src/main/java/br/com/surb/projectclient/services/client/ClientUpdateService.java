package br.com.surb.projectclient.services.client;

import br.com.surb.projectclient.dto.ClientDTO;
import br.com.surb.projectclient.entities.Client;
import br.com.surb.projectclient.repositories.ClientRepository;
import br.com.surb.projectclient.shared.constants.ConstantException;
import br.com.surb.projectclient.shared.exeptions.resource.ResourceNotFondExecption;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientUpdateService {
    private final ClientRepository clientRepository;

    public ClientUpdateService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ClientDTO execute(Long clientId, ClientDTO dto) {
        try {
            Client entity = clientRepository.getReferenceById(clientId);
            copyDtoToEntity(dto, entity);
            entity = clientRepository.save(entity);
            return new ClientDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFondExecption(ConstantException.ENTITY_NOT_FOUND);
        }

    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setBirthDate(dto.getBirthDate());
        entity.setIncome(dto.getIncome());
        entity.setChildren(dto.getChildren());
    }
}
