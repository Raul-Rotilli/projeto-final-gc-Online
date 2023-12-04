package github.projetofinalgc.naruto.api.naruto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharactersDTO {
    private int id;
    private String name;
    private ArrayList<String> images;
    private Debut debut;
    private ArrayList<String> jutsu;
    private Personal personal;
    private ArrayList<String> uniqueTraits;

    private ArrayList<String> natureType;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public Debut getDebut() {
        return debut;
    }

    public void setDebut(Debut debut) {
        this.debut = debut;
    }

    public ArrayList<String> getJutsu() {
        return jutsu;
    }

    public void setJutsu(ArrayList<String> jutsu) {
        this.jutsu = jutsu;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public ArrayList<String> getUniqueTraits() {
        return uniqueTraits;
    }

    public void setUniqueTraits(ArrayList<String> uniqueTraits) {
        this.uniqueTraits = uniqueTraits;
    }

    public ArrayList<String> getNatureType() {
        return natureType;
    }

    public void setNatureType(ArrayList<String> natureType) {
        this.natureType = natureType;
    }



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Personagem:\n");
        result.append("  ID = ").append(id).append("\n");
        result.append("  Nome = ").append(name).append("\n");

        // Imagens
        if (images != null && !images.isEmpty()) {
            result.append("  Imagens = ").append(String.join(", ", images)).append("\n");
        }

        // Debut
        if (debut != null) {
            result.append("  Debut:\n");
            result.append(debut.toString());
        }

        // Jutsu
        if (jutsu != null && !jutsu.isEmpty()) {
            result.append("  Jutsu = ").append(String.join(", ", jutsu)).append("\n");
        }

        // Personal
        if (personal != null) {
            result.append("  Atributos pessoais:\n");
            result.append(personal.toString());
        }

        // Traits únicas
        if (uniqueTraits != null && !uniqueTraits.isEmpty()) {
            result.append("  Traits únicas = ").append(String.join(", ", uniqueTraits)).append("\n");
        }

        // Nature Type
        if (natureType != null && !natureType.isEmpty()) {
            result.append("  Nature Type = ").append(String.join(", ", natureType)).append("\n");
        }

        return result.toString();
    }



}



