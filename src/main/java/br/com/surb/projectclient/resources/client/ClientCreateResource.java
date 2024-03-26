package br.com.surb.projectclient.resources.client;

import br.com.surb.projectclient.dto.ClientDTO;
import br.com.surb.projectclient.services.client.ClientCreateService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/clients")
public class ClientCreateResource {
    private final ClientCreateService clientCreateService;

    public ClientCreateResource(ClientCreateService clientCreateService) {
        this.clientCreateService = clientCreateService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<ClientDTO>> handle(@Valid @RequestBody ClientDTO dto) {
        ClientDTO obj = clientCreateService.execute(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{productId}").buildAndExpand(obj.getId()).toUri();
        return supplyAsync(() -> obj).thenApply((__) -> ResponseEntity.created(uri).body(obj));
    }
}
