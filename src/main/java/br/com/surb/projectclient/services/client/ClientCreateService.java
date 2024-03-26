package br.com.surb.projectclient.services.client;

import br.com.surb.projectclient.dto.ClientDTO;
import br.com.surb.projectclient.entities.Client;
import br.com.surb.projectclient.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientCreateService {

    private final ClientRepository clientRepository;

    public ClientCreateService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ClientDTO execute(ClientDTO dto) {
        Client entity = new Client();
        copyDtoToEntity(dto, entity);
        entity = clientRepository.save(entity);
        return new ClientDTO(entity.getId(), entity.getName(), entity.getCpf(), entity.getBirthDate(), entity.getIncome(), entity.getChildren());
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setBirthDate(dto.getBirthDate());
        entity.setIncome(dto.getIncome());
        entity.setChildren(dto.getChildren());
    }
}
