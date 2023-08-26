package class3.entity;

public enum KeywordOptions {
    ALL_WORDS_ANY_ORDER("All words, any order"),
    ANY_WORDS_ANY_ORDER("Any words, any order"),
    EXACT_WORD_EXACT_ORDER("Exact words, exact order"),
    EXACT_WORDS_ANY_ORDER("Exact words, any order");

    private String value;

    KeywordOptions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
