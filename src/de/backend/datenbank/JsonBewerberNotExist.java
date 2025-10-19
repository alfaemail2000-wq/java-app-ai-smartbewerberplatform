package de.backend.datenbank;

public class JsonBewerberNotExist extends RuntimeException {
    public JsonBewerberNotExist(String message) {
        super(message);
    }
}
