package br.com.surb.projectclient.services.client;

import br.com.surb.projectclient.dto.ClientDTO;
import br.com.surb.projectclient.entities.Client;
import br.com.surb.projectclient.repositories.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientFindAllService {

    private final ClientRepository clientRepository;

    public ClientFindAllService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> execute(Pageable pageable) {
        Page<Client> result = clientRepository.findAll(pageable);
        return result.map(client -> new ClientDTO(client));
    }
}
