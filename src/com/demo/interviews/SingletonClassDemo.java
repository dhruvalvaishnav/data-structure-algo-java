package com.demo.interviews;

//Singleton Class Demo
public class SingletonClassDemo {

    private static SingletonClassDemo SingletonClassDemo = null;

    private SingletonClassDemo() {}

    public SingletonClassDemo getInstance() {
        if (SingletonClassDemo == null) {
            synchronized (SingletonClassDemo.getClass()) {
                if (SingletonClassDemo == null) SingletonClassDemo = new SingletonClassDemo();
            }
        }
        return SingletonClassDemo;
    }
}

// 7
//core
//WEB
//DATA - JDBC
