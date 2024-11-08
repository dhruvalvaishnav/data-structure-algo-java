package com.demo.interviews;

import java.io.*;

// Singleton Class with cloning and serialize/deserialize objects
public class SingleTon_With_clone_serialize_D {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        // check for cloning
        System.out.println("check for clone of the object............");

        SingleTon.getInstance();
        SingleTon.getInstance();
        SingleTon.getInstance();
        SingleTon.getInstance();
        SingleTon.getInstance();
        SingleTon.getInstance();

        System.out.println("Object created  = " + SingleTon.getInstance());
        System.out.println("=========================================================");

        SingleTon INSTANCE = SingleTon.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(("singleTon.ser")));
        oos.writeObject(INSTANCE);
        oos.close();

        // Here I am recreating the instance by reading the serialized object data store
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleTon.ser"));
        SingleTon factory1 = (SingleTon) ois.readObject();
        ois.close();

        // I am recreating the instance AGAIN by reading the serialized object data store
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("singleTon.ser"));
        SingleTon factory2 = (SingleTon) ois2.readObject();
        ois2.close();

        /*
            It has created two objects and one static reference for INSTANCE.
            That means if we read the serialized format of a singleton object multiple times,
            we will create multiple objects. This is not what a singleton object is supposed to do.
            So can we avoid i?, Yes, we can. by creating readResolver() method.
        */

        // Let's see how we have broken the singleton behavior
        System.out.println("Instance reference check->" + factory1.getInstance());
        System.out.println("Instance reference check->" + factory2.getInstance());
        System.out.println("=========================================================");
        System.out.println("Object reference check->" + factory1);
        System.out.println("Object reference check->" + factory2);


    }
}

class SingleTon implements Serializable, Cloneable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static volatile SingleTon instance;

    private SingleTon() {
    }

    public static SingleTon getInstance() {
        if (instance == null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();
                    System.out.println("SingleTon obj is created.");
                } else {
                    System.out.println("can not create the object again...!");
                }
            }
        }
        return instance;
    }

    // Create the clone object by overriding the clone method
    // Overriding clone() method by simply calling Object class clone() method.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        throw new CloneNotSupportedException("can not clone this object...!");
    }


    // To avoid multiple instances of singleton class we will use following method provided by serialization:
    // This will prevent the creation of multiple instances of a singleton class.
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }
}