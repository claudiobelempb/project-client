package br.com.surb.projectclient.resources.client;

import br.com.surb.projectclient.dto.ClientDTO;
import br.com.surb.projectclient.services.client.ClientFindAllService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/clients")
public class ClientFindAllResource {
    private final ClientFindAllService clientFindAllService;

    public ClientFindAllResource(ClientFindAllService clientFindAllService) {
        this.clientFindAllService = clientFindAllService;
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<Page<ClientDTO>>> handle(Pageable pageable) {
        return supplyAsync(() -> clientFindAllService.execute(pageable)).thenApply((entity) -> ResponseEntity.ok().body(entity));
    }
}
