package github.projetofinalgc.naruto.api.naruto;

public class Debut {

    public String novel;
    public String movie;
    public String appearsIn;
    public String manga;
    public String anime;
    public String game;
    public String ova;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Debut: ");

        appendIfNotNull(result, "Série", novel);
        appendIfNotNull(result, "Filme", movie);
        appendIfNotNull(result, "Aparece em", appearsIn);
        appendIfNotNull(result, "Manga", manga);
        appendIfNotNull(result, "Anime", anime);
        appendIfNotNull(result, "Jogo", game);
        appendIfNotNull(result, "OVA", ova);

        return result.toString();
    }
    public void appendIfNotNull(StringBuilder builder, String label, String value) {
        if (value != null && !value.isEmpty()) {
            builder.append(label).append("=").append(value).append(", ");
        }
    }
}
