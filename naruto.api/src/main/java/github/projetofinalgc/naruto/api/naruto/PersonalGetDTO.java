package github.projetofinalgc.naruto.api.naruto;

 record PersonalGetDTO(String birthdate, String clan, String bloodType, String classification, String kekkeiGenkai, String species, String sex, String partner) {
    public PersonalGetDTO(Personal personal) {
        this(
                personal.getBirthdate(), personal.getClan(), personal.getBloodType(),
                personal.getClassification(),personal.getKekkeiGenkai(),
                personal.getSpecies(), personal.getSex(),personal.getPartner());
    }
}