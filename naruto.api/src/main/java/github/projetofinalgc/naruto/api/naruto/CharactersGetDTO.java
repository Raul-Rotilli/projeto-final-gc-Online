package github.projetofinalgc.naruto.api.naruto;


import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharactersGetDTO {
    private int id;
    private String name;
    private ArrayList<String> images;
    private DebutGetDTO debut;
    private ArrayList<String> jutsu;
    private PersonalGetDTO personal;
    private ArrayList<String> uniqueTraits;

    public CharactersGetDTO(CharactersDTO charactersDTO){
        Gson gson = new Gson();
        this.id = charactersDTO.getId();
        this.name = charactersDTO.getName();
        this.jutsu = charactersDTO.getJutsu();
        this.debut = new DebutGetDTO(charactersDTO.getDebut());
        this.personal = new PersonalGetDTO(charactersDTO.getPersonal());

    }


    }