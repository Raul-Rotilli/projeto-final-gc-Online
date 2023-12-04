package github.projetofinalgc.naruto.api.naruto;

record DebutGetDTO(String novel, String movie, String appearsIn, String manga, String anime, String game, String ova) {

    public DebutGetDTO(Debut debut) {
        this(
                debut.getNovel(), debut.getMovie(), debut.getAppearsIn(),
                debut.getManga(),debut.getAnime(), debut.getGame(), debut.getOva());
    }

}
