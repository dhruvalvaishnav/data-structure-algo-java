package com.demo.interviews;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;

public class Iris {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println(SingleTonIris.getInstance());
        System.out.println(SingleTonIris.getInstance());
        System.out.println(SingleTonIris.getInstance());
        System.out.println(SingleTonIris.getInstance());
        System.out.println(SingleTonIris.getInstance());
        System.out.println(SingleTonIris.getInstance());
        System.out.println(SingleTonIris.getInstance());

        SingleTonIris instance = SingleTonIris.getInstance();
        Object clone = (SingleTonIris) instance.clone();

        System.out.println(clone == instance);
    }
}

class SingleTonIris implements Cloneable, Serializable {

    private static volatile SingleTonIris obj;

    private SingleTonIris() {}

    public static SingleTonIris getInstance() {
        if (obj == null) {
            synchronized (SingleTonIris.class) {
                if (obj == null) {
                    obj = new SingleTonIris();
                }
            }
        }
        return obj;
    }

    @Override
    protected SingleTonIris clone() throws CloneNotSupportedException {
        super.clone();
        return SingleTonIris.getInstance();
    }
}


// Object
// cloneable
// immutable class :

/*
class final EmployeeImmutable {
    private final int eID;
    private final String eName;
    private final HashMap<Integer,String> eMap;

    public EmployeeImmutable(int eID, String eName, HashMap<Integer, String> eMap) {
        this.eID = eID;
        this.eName = eName;
        this.eMap = (HashMap<Integer, String>) Collections.unmodifiableMap(eMap);
    }

    public int geteID() {
        return eID;
    }

    public String geteName() {
        return eName;
    }

    public HashMap<Integer, String> geteMap() {
        return (HashMap<Integer, String>) Collections.unmodifiableMap(eMap);
    }
}
 */