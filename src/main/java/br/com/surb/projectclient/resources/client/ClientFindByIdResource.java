package br.com.surb.projectclient.resources.client;

import br.com.surb.projectclient.dto.ClientDTO;
import br.com.surb.projectclient.services.client.ClientFindByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/clients")
public class ClientFindByIdResource {

    private final ClientFindByIdService clientFindByIdService;

    public ClientFindByIdResource(ClientFindByIdService clientFindByIdService) {
        this.clientFindByIdService = clientFindByIdService;
    }

    @GetMapping(value = "/{clientId}")
    public CompletableFuture<ResponseEntity<ClientDTO>> handle(@PathVariable Long clientId) {
        return supplyAsync(() -> clientFindByIdService.execute(clientId)).thenApply((entity) -> ResponseEntity.ok().body(entity));
    }
}
