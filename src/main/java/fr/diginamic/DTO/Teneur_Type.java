package fr.diginamic.DTO;

public enum Teneur_Type {
    energie100g("energie",0),
    graisse100g("graisse",1),
    sucres100g("sucres",2),
    fibres100g("fibres",3),
    proteines100g("proteines",4),
    sel100g("sel",5),
    vitA100g("vitA",6),
    vitD100g("vitD",7),
    vitE100g("vitE",8),
    vitK100g("vitK",9),
    vitC100g("vitC",10),
    vitB1100g("vitB",11),
    vitB2100g("vitB2",12),
    vitPP100g("vitPP",13),
    vitB6100g("vitB6",14),
    vitB9100g("vitB9",15),
    vitB12100g("vitB12",16),
    calcium100g("calcium",17),
    magnesium100g("magnesium",18),
    iron100g("iron",19),
    fer100g("fer",20),
    betaCarotene100g("betaCarotene",21),
    presenceHuilePalme("presenceHuilePalme", 22);

    public final String label;
    public final int value;

    Teneur_Type(String label, int value) {
        this.label = label;
        this.value = value;
    }
    public static String valueOfLabel(int value) {
        for (Teneur_Type e : values()) {
            if (e.value == value) {
                return e.getLabel();
            }
        }
        return null;
    }

    public String getLabel() {
        return label;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString(){
        return this.label;
    }
}
