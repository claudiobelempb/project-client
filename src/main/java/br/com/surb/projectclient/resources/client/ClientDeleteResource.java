package br.com.surb.projectclient.resources.client;

import br.com.surb.projectclient.services.client.ClientDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.runAsync;

@RestController
@RequestMapping(value = "/clients")
public class ClientDeleteResource {

    private final ClientDeleteService clientDeleteService;

    public ClientDeleteResource(ClientDeleteService clientDeleteService) {
        this.clientDeleteService = clientDeleteService;
    }

    @DeleteMapping(value = "/{clientId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable Long clientId) {
        return runAsync(() -> clientDeleteService.execute(clientId))
                .thenApply((__) -> ResponseEntity.noContent().build());
    }
}
