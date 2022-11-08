package org.example;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private String name;
    private Map<String, String> dictionary;

    private Dictionary(){}
    public Dictionary(String name)
    {
        this.name = name;
        dictionary = new HashMap<>();
    }
    public String getName()
    {
        return this.name;
    }

    public boolean isEmpty()
    {
        return this.dictionary.isEmpty();
    }

    public void addTranslation(String toTranslate, String translation)
    {
        if(!dictionary.containsKey(toTranslate)) dictionary.put(toTranslate, translation);
    }

    public String getTranslation(String word)
    {
        if(this.dictionary.containsKey(word)) return this.dictionary.get(word);
        return null;
    }
}
