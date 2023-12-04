package github.projetofinalgc.naruto.api;

import github.projetofinalgc.naruto.api.naruto.CharactersDTO;
import github.projetofinalgc.naruto.api.naruto.CharactersGetDTO;
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
	CharactersDTO charactersDTO;
	@Test
	public void testaRetornoGetDTO(CharactersDTO charactersDTO){
		/*CharactersGetDTO charactersGetDTO = new CharactersGetDTO(charactersDTO);
		System.out.println(charactersGetDTO.toString());*/
	}
}
