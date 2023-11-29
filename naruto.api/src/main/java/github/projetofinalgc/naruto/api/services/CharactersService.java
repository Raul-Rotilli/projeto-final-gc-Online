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

    public Mono<CharactersDTO> criarPersonagem(CharactersDTO character) {
        listaPersonagens.add(character);
        return Mono.just(character);
    }
    public Mono<Void> deletarPersonagem(Integer id) {
        listaPersonagens.removeIf(character -> character.getId() == id);

        return Mono.empty();
    }

    public Mono<CharactersDTO> atualizarPersonagem(Integer id, CharactersDTO updatedCharacter) {
        return Mono.fromSupplier(() -> {
            // Encontrar o personagem pelo ID
            CharactersDTO personagemExistente = listaPersonagens.stream()
                    .filter(character -> character.getId() == id)
                    .findFirst()
                    .orElse(null);

            // Se o personagem existir, atualize os dados
            if (personagemExistente != null) {
                // Atualize os campos necessários
                personagemExistente.setName(updatedCharacter.getName());
                personagemExistente.setImages(updatedCharacter.getImages());
                personagemExistente.setDebut(updatedCharacter.getDebut());
                personagemExistente.setJutsu(updatedCharacter.getJutsu());
                personagemExistente.setPersonal(updatedCharacter.getPersonal());
                personagemExistente.setUniqueTraits(updatedCharacter.getUniqueTraits());
                personagemExistente.setNatureType(updatedCharacter.getNatureType());

                // Adicione mais campos conforme necessário

                return personagemExistente;
            } else {
                // Se o personagem não existir, retorne null ou lance uma exceção, dependendo dos requisitos.
                return null;
            }
        });
    }

    public int gerarNovoId() {
        // Lógica para gerar um novo ID (pode ser um contador, uma lógica de geração única, etc.)
        // Aqui, estou simplesmente incrementando um contador fictício.
        return listaPersonagens.size() + 1;
    }
}