package com.vikastadge.designPattern.singleton;

public class Singleton {
    private static Singleton INSTANCE;
    private Singleton(){
        if(INSTANCE != null){
            throw new IllegalStateException("Object already exists");
        }
    }

    public static final Singleton getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    protected  Object readResolve(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}
