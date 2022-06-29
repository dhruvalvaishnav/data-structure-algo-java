package com.demo.interviews;

import java.util.*;

public class ITC {
    public static void main(String[] args) {
        List<Pics> pics = new ArrayList<>();
        pics.add(new Pics(112, "pic1", "gandikota"));
        pics.add(new Pics(21, "pic2", "Gokarna"));
        pics.add(new Pics(3, "pic3", "Goa"));
        pics.add(new Pics(4, "pic4", "Dandeli"));
        pics.add(new Pics(15, "pic5", "Chikmagalur"));
        pics.add(new Pics(26, "pic6", "Belum caves"));

        pics.stream().sorted((o1, o2) -> {
            if (o1.id > o2.id) return 1;
            else if (o1.id < o2.id) return -1;
            return 0;
        }).forEach(System.out::println);

        System.out.println();

        Collections.sort(pics, (o1, o2) -> {
            if (o1.id > o2.id) return 1;
            else if (o1.id < o2.id) return -1;
            return 0;
        });

        for (Pics p : pics) {
            System.out.println(p);
        }
    }


}

class Pics {
    int id;
    String name;
    String Location;

    public Pics(int id, String name, String location) {
        this.id = id;
        this.name = name;
        Location = location;
    }

    @Override
    public String toString() {
        return "Pics{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Location='" + Location + '\'' +
                '}';
    }
}


/*

package com.demo.interviews;

public class ITC {
    public static void main(String[] args) {

    }
}

// 1. ms
// 2. API gateway and load balancer
// 3. service discovery
// 4. communication
// 5.

// @configuration
// @Autowired
// one interface - two impl - @Qualifier @
// @Lazy

// java8 -> list - sort using lambda ex

List<Pics> pics = new ArrayList<>();
pics.add(new Pics(112, "pic1", "gandikota"));
pics.add(new Pics(21, "pic2", "Gokarna"));
pics.add(new Pics(3, "pic3", "Goa"));
pics.add(new Pics(4, "pic4", "Dandeli"));
pics.add(new Pics(15, "pic5", "Chikmagalur"));
pics.add(new Pics(26, "pic6", "Belum caves"));

Collections.sort(pics);

//FI before 1.8

// map flatMap reduce

AWS - VPC



public class Main
{
public static void gfg(String s)
{
System.out.println("String");
}
public static void gfg(Object o)
{
System.out.println("Object");
}

 public static void main(String args[])
{
gfg(null);
}
}

*******************************

public class D {

 static {
System.out.println("static");
}

D(){
System.out.println("constructor");
}

{
System.out.println("instance");
}

public static void main(String[] args) {
D d= new D();
}

*******************************

 */