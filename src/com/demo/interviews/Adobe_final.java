package com.demo.interviews;

import java.util.*;
import java.util.stream.Collectors;

public class Adobe_final {
    public static void main(String[] args) {
//        Map<String, Product> map = new HashMap<>();
//        map.put("P1", new Product(59, "ACROBAT", "235"));
//        map.put("P2", new Product(99, "PS PRO", "535"));
//        map.put("P3", new Product(199, "Illustrator", "856"));
//        Collection<Product> productCollection = map.values();
//        Set<Integer> prices = productCollection.stream().map(x -> x.getPrice()).collect(Collectors.toSet());
//        System.out.println("prices : " + prices);
//
//        String a = "2";
//        Integer c = 2;
//        String b = c.toString();
//
//        if (a == b) {
//            System.out.println("SAME");
//        } else {
//            System.out.println("DIFF");
//        }

//        Product_List list = new Product_List();
//        list.addProduct(new Product(14, "DEMO", "45"));
//        list.addProduct(new Product(44, "DEMO1", "55"));
//        list.addProduct(new Product(84, "DEMO2", "95"));
//        list.addProduct(new Product(94, "DEMO3", "75"));
//        List<Product> productList = list.getProducts();

        // sort array of int
        System.out.println(Arrays.toString(sortArray(new int[]{4, 1, 9, 6, 89, 14, 23})));
    }


    private static int[] sortArray(int[] arr) {
        // sort an array in ascending order
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int a = arr[i];
            while ((j > 0) && (arr[j - 1] > a)) { //returns true when both conditions are true
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = a;
        }

        // Arrays.sort(arr);
        return arr;
    }
}


class Product {
    private int price;
    private String name;
    private String id;

    public Product(int price, String name, String id) {
        this.price = price;
        this.name = name;
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" + "price=" + price + ", name='" + name + '\'' + ", id='" + id + '\'' + '}';
    }
}

class Product_List {
    private List<Product> products;

    public Product_List() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }


}



/*
    String id
    String name
    int price

    main-map<String, Product> -load products
    products

    get the list from the map-set of price

    List<Product>

    Set<Integer>

    ProList
    List<Product> method-

    5 10 15 20 50 100 700 75


    @Entity
@Table("EMPLOYEEEE")
class Employee {
    private int eno;
    private String fn;
    private String ln;
    private String DOJ;

// const
//getter setter

}

@Repository
interface EmployeeRepository extends JpaRepository {

    public List<Employee> employeesBasedOnFnAndLn(String fn, String ln);
}

@Service
class EmplImpl implements EmployeeRepository {
    public List<Employee> employeesBasedOnFnAndLn(String fn, String ln) {


    }
}


SQL : find by fn and ln
Employee table
empId,fn,ln,manager_id

empId,fn,ln,manager_name

SELECT e1.empId,e1.fn,e1.ln,e2.fn AS manager_name FROM Employee e1
JOIN Employee e2 ON e2.manager_id=e1.empId;



 */


