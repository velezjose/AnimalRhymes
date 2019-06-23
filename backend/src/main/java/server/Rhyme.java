package server;

public class Rhyme {
    private final String[] results;

    public Rhyme(String word) {
        String[] rs = { "bird", "horse", "cow" };
        this.results = rs;
    }

    public String[] getResults() {
        return this.results;
    }
}