package com.demo.interviews.interview2024;

public class Cognizant1 {
    public static void main(String[] args) {

        int number = 121; // Example number
        if (isPalindrome2(number)) {
            System.out.println(number + " is a palindrome. 1");
        } else {
            System.out.println(number + " is not a palindrome. 1");
        }

        if (isPalindrome1(number)) {
            System.out.println(number + " is a palindrome. 2");
        } else {
            System.out.println(number + " is not a palindrome. 2");
        }

        int n = 10; // Number of Fibonacci terms to generate
        System.out.println("Fibonacci Series (Iterative):");
        printFibonacciIterative(n);

        System.out.println("Fibonacci Series (Recursive):");
        for (int i = 0; i < n; i++) {
            System.out.print(printFibonacciRecursive(i) + " ");
        }

    }


    // using string builder1
    private static boolean isPalindrome1(int number) {
        if (number == 0 || number < 0) {
            return false;
        }

        String original = String.valueOf(number);
        String reverse = new StringBuilder(original).reverse().toString();

        return original.equals(reverse);
    }

    // using temp variable
    private static boolean isPalindrome2(int number) {
        // Negative numbers and numbers that end with 0 (but are not 0) are not palindromes
        if (number < 0 || (number % 10 == 0 && number != 0)) {
            return false;
        }

        int reversed = 0, original = number;

        while (number > 0) {
            int digit = number % 10; // Get the last digit
            reversed = reversed * 10 + digit; // Build the reversed number
            number /= 10; // Remove the last digit from the original number
        }

        return original == reversed; // Check if the original number is equal to the reversed number
    }


    private static void printFibonacciIterative(int length) {
        int firstNum = 0, secondNum = 1;
        for (int i = 1; i < length; i++) {
            System.out.print(firstNum + " , ");
            int nextNum = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = nextNum;
        }
    }

    private static int printFibonacciRecursive(int i) {
        if (i <= 1) {
            return i;
        }
        return printFibonacciRecursive(i - 1) + printFibonacciRecursive(i - 2);
    }


}


/*
Q : Why Mockito doesn't mock private methods?

Firstly, we are not dogmatic about mocking private methods.
We just don't care about private methods because from the standpoint of testing private methods don't exist.

Here are a couple of reasons Mockito doesn't mock private methods:
    It requires hacking of classloaders that is never bulletproof,
    and it changes the api (you must use custom test runner, annotate the class, etc.).

    It is very easy to work around - just change the visibility of method from private to package-protected (or protected).

    It requires me to spend time implementing & maintaining it.
    And it does not make sense given point #2 and a fact that it is already implemented in different tool (powermock).

    Finally... Mocking private methods is a hint that there is something wrong with OO understanding.
    In OO you want objects (or roles) to collaborate, not methods. Forget about pascal & procedural code. Think in objects.

use powermock - https://github.com/powermock/powermock/wiki/MockPrivate
public class Hello {
    private Hello obj;
    private Integer method1(Long id) {
        return id + 10;
    }
}

Hello testObj = new Hello();
Integer result = Whitebox.invokeMethod(testObj, "method1", new Long(10L));

Hello testObj = new Hello();
Hello newObject = new Hello();
Whitebox.setInternalState(testObj, "obj", newObject);


use JUnit ReflectionUtils -
@RunWith(SpringRunner.class)
@SpringBootTest
public class ComTurretaSpringReflectionReflectiontestutilsApplicationTests {

    @Test
    public void test01()
    {
        Student student = new Student();
        student.setName("James Dean");

        System.out.println("Before: " + student.toString());
        ReflectionTestUtils.setField(student, "internalCode", 1343243);

        System.out.println("After: " + student.toString());

        ReflectionTestUtils.invokeMethod(student, "saveOrUpdate", "From Unit test");
    }
}


use By using reflection -
public class TestA {

    @Test
    public void testMethod() {

    A a= new A();
    Method privateMethod = A.class.getDeclaredMethod("method1", null);
    privateMethod.setAccessible(true);
    // invoke the private method for test
    privateMethod.invoke(A, null);

    }
}

Q : heap vs stack memory in java
    Heap Memory:
    Purpose: Stores objects and their instance variables.
    Lifetime: Objects created on the heap live as long as they are referenced by other objects or until garbage collection removes them.
    Access: Objects on the heap can be accessed by any thread in the application.
    Size: Generally larger than the stack, and can grow dynamically as needed.
    Allocation: Memory allocation is slower compared to the stack.
    Error: If the heap is full, you get an OutOfMemoryError.

    Stack Memory:
    Purpose: Stores method parameters, local variables, and return addresses.
    Lifetime: Memory is allocated when a method is called and deallocated when the method exits.
    Access: Only accessible by the thread that owns the method.
    Size: Smaller than the heap and has a fixed size (configurable with the -Xss JVM option).
    Allocation: Memory allocation and deallocation are fast and efficient due to the LIFO structure.
    Error: If the stack is full, you get a StackOverflowError

    Key Differences:
    Data Stored:
    Heap stores objects, while the stack stores method-specific data.
    Lifetime:
    Heap objects live until garbage collected, while stack memory lives for the duration of the method call.
    Access:
    Heap objects are globally accessible, while stack memory is only accessible within the method.
    Size and Management:
    Heap is larger and dynamically allocated, while the stack is smaller and managed automatically.

    eg :
    public static void main(String[] args) {
        int x = 10; // x is a local variable stored on the stack
        Example obj = new Example(); // obj is a reference to an object on the heap
    }


Q: JavaScript IIFE (Immediately Invoked Function Expression
    (function() {
      var message = "Hello from IIFE!";
      console.log(message);
    })();

Q: Feature of ES6 ECMA
Q: Array methods in JS
Q: How to create React app, different methods
Q: How to access the data using the Redux flow
Q: How to optimize the React code for  api calls

You can remove the '0' from each element in the array using both Java and JavaScript:

const arr = [200, 303, 304, 7809, 70,12];
//2, 33, 34, 789, 7, 12

JavaScript:
    const res = arr.map(num=>Number(String(num).replace(/0/g,'')));
    console.log("res : " + res);

Java:
    int[] result = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
        result[i] = Integer.parseInt(String.valueOf(arr[i]).replace("0", ""));
    }
    // Remove trailing zeros
    result = Arrays.stream(result).filter(n -> n != 0).toArray();
    System.out.println(Arrays.toString(result)); // Output: [2, 33, 34, 789, 7, 12]
 */