package github.projetofinalgc.naruto.api.services;
import github.projetofinalgc.naruto.api.naruto.CharactersDTO;
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
    private final List<CharactersDTO> listaPersonagens = new ArrayList<>();

    private final WebClient webClient;

    public CharactersService(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://narutodb.xyz/api").build();

    }
    public Flux<CharactersDTO> getAllCharacters() {

        return Flux.fromIterable(listaPersonagens);
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

    public Mono<CharactersDTO> addCharacter(CharactersDTO character) {
        listaPersonagens.add(character);
        return Mono.just(character);
    }
    public Mono<Void> deleteCharacter(Integer id) {
        listaPersonagens.removeIf(character -> character.getId() == id);

        return Mono.empty();
    }

    public Mono<CharactersDTO> atualizarPersonagem(Integer id, CharactersDTO updatedCharacter) {
        return Mono.fromSupplier(() -> {
            // Encontrar o personagem pelo ID
            CharactersDTO existingCharacter = listaPersonagens.stream()
                    .filter(character -> character.getId() == id)
                    .findFirst()
                    .orElse(null);

            // Se o personagem existir, atualize os dados
            if (existingCharacter != null) {
                // Atualize os campos necessários
                existingCharacter.setName(updatedCharacter.getName());
                existingCharacter.setImages(updatedCharacter.getImages());
                existingCharacter.setDebut(updatedCharacter.getDebut());
                existingCharacter.setJutsu(updatedCharacter.getJutsu());
                existingCharacter.setPersonal(updatedCharacter.getPersonal());
                existingCharacter.setUniqueTraits(updatedCharacter.getUniqueTraits());
                existingCharacter.setNatureType(updatedCharacter.getNatureType());

                // Adicione mais campos conforme necessário

                return existingCharacter;
            } else {
                // Se o personagem não existir, retorne null ou lance uma exceção, dependendo dos requisitos.
                return null;
            }
        });
    }
}