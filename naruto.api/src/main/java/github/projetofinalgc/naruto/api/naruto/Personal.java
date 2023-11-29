package github.projetofinalgc.naruto.api.naruto;

import java.util.ArrayList;

public class Personal {
    private String species;
    private String status;
    private String kekkeiGenkai;
    private String classification;
    private String birthdate;
    private String sex;
    private String bloodType;
    private String partner;
    private String clan;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKekkeiGenkai() {
        return kekkeiGenkai;
    }

    public void setKekkeiGenkai(String kekkeiGenkai) {
        this.kekkeiGenkai = kekkeiGenkai;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Personal:\n");
        appendIfNotNull(result, "  Espécie", species);
        appendIfNotNull(result, "  Status", status);
        appendIfNotNull(result, "  Kekkei Genkai", kekkeiGenkai);
        appendIfNotNull(result, "  Classificação", classification);
        appendIfNotNull(result, "  Data de Nascimento", birthdate);
        appendIfNotNull(result, "  Sexo", sex);
        appendIfNotNull(result, "  Tipo Sanguíneo", bloodType);
        appendIfNotNull(result, "  Parceiro", partner);
        appendIfNotNull(result, "  Clã", clan);
        return result.toString();
    }

    private void appendIfNotNull(StringBuilder builder, String label, Object value) {
        if (value != null) {
            builder.append(label).append(" = ").append(value).append("\n");
        }
    }
}
