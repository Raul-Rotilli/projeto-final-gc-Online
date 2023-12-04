package github.projetofinalgc.naruto.api.services;
import github.projetofinalgc.naruto.api.naruto.CharactersDTO;
import github.projetofinalgc.naruto.api.naruto.CharactersGetDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class CharactersService{

    private final WebClient webClient;
    private final List<CharactersGetDTO> listaPersonagens = new ArrayList<>();

    public CharactersService(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://narutodb.xyz/api").build();

    }

    public Mono<CharactersDTO> getPersonagemById(Integer id) {
        return webClient
                .get()
                .uri("/character/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
                .bodyToMono(CharactersDTO.class);
    }

    public Mono<CharactersDTO> getPersonagemByName(String name) {
        //CharactersDTO a = new CharactersDTO();
        //CharactersGetDTO b = new CharactersGetDTO(a);
        //listaPersonagens.add(b);
        return webClient
                .get()
                .uri("/character/search?name=" + name + "/")
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
                .bodyToMono(CharactersDTO.class);
    }

    public Mono<CharactersDTO> getAllCharacters(){
        CharactersGetDTO a = new CharactersGetDTO();
        listaPersonagens.add(a);
        return webClient.get().
                uri("/character/").
                accept(APPLICATION_JSON).retrieve().
                onStatus(HttpStatusCode::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Verifique os parâmetros informados"))).
                bodyToMono(CharactersDTO.class);
    }


}