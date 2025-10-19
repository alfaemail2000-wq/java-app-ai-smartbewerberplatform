package de.jsonversuche;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.time.LocalDate;

public class Marmelade {
    private String name;
    private LocalDate datum;
    private String a;
    private String b;

    private String age;
    private String skill;
    protected int jahreBerufserfahrung;
    //private int bewerberId;
    private String beruf;
    private LocalDate abschlussdatum;


    protected boolean nochDabei=true;

    protected int bewerbernote;

    protected int extrapunkte;
    protected int endbewerbernoten;
    private int ausgewaehlteBewerberId=0;
    private static int globalBwerberIdCounter=1;

    public Marmelade(String name, LocalDate datum, String a, String b, String name1, String age, String skill, int jahreBerufserfahrung, String beruf, LocalDate abschlussdatum, boolean nochDabei, int bewerbernote, int extrapunkte, int endbewerbernoten) {
        this.name = name;
        this.datum = datum;
        this.a = a;
        this.b = b;
        this.name = name1;
        this.age = age;
        this.skill = skill;
        this.jahreBerufserfahrung = jahreBerufserfahrung;
        this.beruf = beruf;
        this.abschlussdatum = abschlussdatum;
        this.nochDabei = nochDabei;
        this.bewerbernote = bewerbernote;
        this.extrapunkte = extrapunkte;
        this.endbewerbernoten = endbewerbernoten;
        this.assignBewerberId();


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getJahreBerufserfahrung() {
        return jahreBerufserfahrung;
    }

    public void setJahreBerufserfahrung(int jahreBerufserfahrung) {
        this.jahreBerufserfahrung = jahreBerufserfahrung;
    }

    public String getBeruf() {
        return beruf;
    }

    public void setBeruf(String beruf) {
        this.beruf = beruf;
    }

    public LocalDate getAbschlussdatum() {
        return abschlussdatum;
    }

    public void setAbschlussdatum(LocalDate abschlussdatum) {
        this.abschlussdatum = abschlussdatum;
    }

    public boolean isNochDabei() {
        return nochDabei;
    }

    public void setNochDabei(boolean nochDabei) {
        this.nochDabei = nochDabei;
    }

    public int getBewerbernote() {
        return bewerbernote;
    }

    public void setBewerbernote(int bewerbernote) {
        this.bewerbernote = bewerbernote;
    }

    public int getExtrapunkte() {
        return extrapunkte;
    }

    public void setExtrapunkte(int extrapunkte) {
        this.extrapunkte = extrapunkte;
    }

    public int getEndbewerbernoten() {
        return endbewerbernoten;
    }

    public void setEndbewerbernoten(int endbewerbernoten) {
        this.endbewerbernoten = endbewerbernoten;
    }

    public int getAusgewaehlteBewerberId() {
        return ausgewaehlteBewerberId;
    }

    public void setAusgewaehlteBewerberId(int ausgewaehlteBewerberId) {
        this.ausgewaehlteBewerberId = ausgewaehlteBewerberId;
    }

    public static int getGlobalBwerberIdCounter() {
        return globalBwerberIdCounter;
    }

    public static void setGlobalBwerberIdCounter(int globalBwerberIdCounter) {
        Marmelade.globalBwerberIdCounter = globalBwerberIdCounter;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }


    public void assignBewerberId(){
        if(this.ausgewaehlteBewerberId==0)
        { this.ausgewaehlteBewerberId=globalBwerberIdCounter++;}
    }

    public static void main(String[] args)throws Exception {
        ObjectMapper mapper;
        mapper=new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.activateDefaultTyping(
                mapper.getPolymorphicTypeValidator(),
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.PROPERTY
        );
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        Marmelade marmelade = new Marmelade(
                "Anna",                          // name
                LocalDate.now(),                // datum
                "A-Wert",                       // a
                "B-Wert",                       // b
                "Name1",                        // name1
                "28",                           // age
                "Kommunikation",               // skill
                5,                              // jahreBerufserfahrung
                "Ärztin",                       // beruf
                LocalDate.of(2021, 7, 1),       // abschlussdatum
                true,                           // nochDabei
                -250,                            // bewerbernote
                10,                             // extrapunkte
                260                            // endbewerbernoten

        );

        Marmelade marmelade2 = new Marmelade(
                "Anna",                          // name
                LocalDate.now(),                // datum
                "A-Wert",                       // a
                "B-Wert",                       // b
                "Name1",                        // name1
                "28",                           // age
                "Kommunikation",               // skill
                5,                              // jahreBerufserfahrung
                "Ärztin",                       // beruf
                LocalDate.of(2021, 7, 1),       // abschlussdatum
                true,                           // nochDabei
                -250,                            // bewerbernote
                10,                             // extrapunkte
                260                            // endbewerbernoten

        );
        writer.writeValue(new File("DATEI_PFAD"), marmelade);

    }
}


