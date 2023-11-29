package github.projetofinalgc.naruto.api.controllers;
import github.projetofinalgc.naruto.api.naruto.CharactersDTO;

import github.projetofinalgc.naruto.api.services.CharactersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("naruto")

public class PersonagemController {
    CharactersService charactersService;
    @GetMapping("/{id}")
    public Mono<CharactersDTO> getPersonagemById(@PathVariable Integer id) {

        return charactersService.getPersonagemById(id);

    }
    @PostMapping
    public Mono<CharactersDTO> addCharacter(@RequestBody CharactersDTO character) {
        return charactersService.addCharacter(character);
    }
    @PutMapping("/{id}")
    public Mono<CharactersDTO> atualizarPersonagem(@PathVariable Integer id, @RequestBody CharactersDTO characters) {
        return charactersService.atualizarPersonagem(id, characters);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteCharacter(@PathVariable Integer id) {
        return charactersService.deleteCharacter(id);
    }

}
