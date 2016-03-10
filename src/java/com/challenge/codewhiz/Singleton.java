package com.challenge.codewhiz;

public class Singleton {
    private static Singleton _instance = null;
    public String str;

    private Singleton() {

    }

    static Singleton getSingleInstance() {
        if (_instance == null) {
            _instance = new Singleton();
        }
        return _instance;
    }
}
