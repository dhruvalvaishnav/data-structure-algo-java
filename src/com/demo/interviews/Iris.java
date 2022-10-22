package com.demo.interviews;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;

public class Iris {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println(SingleTonDemo1.getInstance());
        System.out.println(SingleTonDemo1.getInstance());
        System.out.println(SingleTonDemo1.getInstance());
        System.out.println(SingleTonDemo1.getInstance());
        System.out.println(SingleTonDemo1.getInstance());
        System.out.println(SingleTonDemo1.getInstance());
        System.out.println(SingleTonDemo1.getInstance());

        SingleTonDemo1 instance = SingleTonDemo1.getInstance();
        Object clone = (SingleTonDemo1) instance.clone();

        System.out.println(clone == instance);
    }
}

class SingleTonDemo1 implements Cloneable, Serializable {

    private static volatile SingleTonDemo1 obj;

    private SingleTonDemo1() {}

    public static SingleTonDemo1 getInstance() {
        if (obj == null) {
            synchronized (SingleTonDemo1.class) {
                if (obj == null) {
                    obj = new SingleTonDemo1();
                }
            }
        }
        return obj;
    }

    @Override
    protected SingleTonDemo1 clone() throws CloneNotSupportedException {
        super.clone();
        return SingleTonDemo1.getInstance();
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