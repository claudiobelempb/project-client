package br.com.surb.projectclient.resources.client;

import br.com.surb.projectclient.dto.ClientDTO;
import br.com.surb.projectclient.services.client.ClientUpdateService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/clients")
public class ClientUpdateResource {
    private final ClientUpdateService clientUpdateService;

    public ClientUpdateResource(ClientUpdateService clientUpdateService) {
        this.clientUpdateService = clientUpdateService;
    }

    @PutMapping(value = "/{clientId}")
    public CompletableFuture<ResponseEntity<ClientDTO>> handle(@PathVariable Long clientId, @Valid @RequestBody ClientDTO dto) {
        return supplyAsync(() -> clientUpdateService.execute(clientId, dto)).thenApply((entity) -> ResponseEntity.ok().body(entity));
    }
}
