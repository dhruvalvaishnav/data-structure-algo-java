package com.demo.interviews;

public class TestForSingleTon {

    public static void main(String[] args) {
        SingleTon.getInstance();
        SingleTon.getInstance();
        SingleTon.getInstance();
        SingleTon.getInstance();
        SingleTon.getInstance();
        SingleTon.getInstance();
    }
}

class SingleTon {
    private static volatile SingleTon instance;

    private SingleTon() {
    }

    public static SingleTon getInstance() {
        if (instance == null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();
                    System.out.println("SingleTon obj created");
                } else {
                    throw new RuntimeException("can not create the object");
                }
            }
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        throw new CloneNotSupportedException("can not clone this object");
    }
}