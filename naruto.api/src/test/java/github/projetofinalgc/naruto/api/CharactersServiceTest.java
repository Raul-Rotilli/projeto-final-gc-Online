package github.projetofinalgc.naruto.api;

import github.projetofinalgc.naruto.api.naruto.CharactersDTO;
import github.projetofinalgc.naruto.api.naruto.Debut;
import github.projetofinalgc.naruto.api.naruto.Personal;
import github.projetofinalgc.naruto.api.services.CharactersService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CharactersServiceTest {

	@Mock
	private List<CharactersDTO> charactersList;

	@InjectMocks
	private CharactersService charactersService;

	@Test
	void testCriarPersonagem() {
		ArrayList<String> imagens = new ArrayList<>();
		imagens.add("imagem1.jpg");
		imagens.add("imagem2.jpg");

		Debut debut = new Debut();
		debut.setNovel("Novel");
		debut.setMovie("Movie");

		ArrayList<String> jutsu = new ArrayList<>();
		jutsu.add("Jutsu1");
		jutsu.add("Jutsu2");

		Personal personal = new Personal();
		personal.setSpecies("Espécie");
		personal.setStatus("Status");

		ArrayList<String> uniqueTraits = new ArrayList<>();
		uniqueTraits.add("Trait1");
		uniqueTraits.add("Trait2");

		ArrayList<String> natureTypes = new ArrayList<>();
		natureTypes.add("Nature1");
		natureTypes.add("Nature2");

		// Dados de exemplo para o novo personagem
		CharactersDTO novoPersonagem = new CharactersDTO();
		novoPersonagem.setName("Novo Personagem");
		novoPersonagem.setImages(imagens);
		novoPersonagem.setDebut(debut);
		novoPersonagem.setJutsu(jutsu);
		novoPersonagem.setPersonal(personal);
		novoPersonagem.setUniqueTraits(uniqueTraits);
		novoPersonagem.setNatureType(natureTypes);
		// Configurar o comportamento esperado
		when(charactersList.size()).thenReturn(0); // Sem personagens na lista
		when(charactersService.gerarNovoId()).thenReturn(1); // Próximo ID a ser atribuído

		// Chamar o método criarPersonagem
		Mono<CharactersDTO> resultadoMono = charactersService.criarPersonagem(novoPersonagem);

		// Verificar o resultado
		CharactersDTO resultado = resultadoMono.block(); // Obter o valor do Mono (bloqueando para um teste síncrono)
		assertEquals(1, resultado.getId()); // O ID deve ser 1 (conforme configurado no mock)

		// Você pode adicionar mais verificações conforme necessário
	}
}
