package github.projetofinalgc.naruto.api.naruto;

public class Debut {

    private String novel;
    private String movie;
    private String appearsIn;
    private String manga;
    private String anime;
    private String game;
    private String ova;


    public String getNovel() {
        return novel;
    }

    public void setNovel(String novel) {
        this.novel = novel;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getAppearsIn() {
        return appearsIn;
    }

    public void setAppearsIn(String appearsIn) {
        this.appearsIn = appearsIn;
    }

    public String getManga() {
        return manga;
    }

    public void setManga(String manga) {
        this.manga = manga;
    }

    public String getAnime() {
        return anime;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getOva() {
        return ova;
    }

    public void setOva(String ova) {
        this.ova = ova;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Debut: ");

        appendIfNotNull(result, "Série", this.novel);
        appendIfNotNull(result, "Filme", this.movie);
        appendIfNotNull(result, "Aparece em", this.appearsIn);
        appendIfNotNull(result, "Manga", this.manga);
        appendIfNotNull(result, "Anime", this.anime);
        appendIfNotNull(result, "Jogo", this.game);
        appendIfNotNull(result, "OVA", this.ova);

        return result.toString();
    }
    public void appendIfNotNull(StringBuilder builder, String label, String value) {
        if (value != null && !value.isEmpty()) {
            builder.append(label).append("=").append(value).append(", ");
        }
    }
}
