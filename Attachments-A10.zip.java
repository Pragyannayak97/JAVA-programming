// Assignment 10 - Java OOP Programs
// GIET University, 3rd Semester
// All five examples are combined into one runnable Java file.

class Bank {
    float getRateOfInterest() {
        return 0.0f;
    }
}

class SBI extends Bank {
    @Override
    float getRateOfInterest() {
        return 8.4f;
    }
}

class ICICI extends Bank {
    @Override
    float getRateOfInterest() {
        return 7.3f;
    }
}

class Axis extends Bank {
    @Override
    float getRateOfInterest() {
        return 9.7f;
    }
}

// Example 2: Multiple inheritance through default interface methods
interface A {
    default void show() {
        System.out.println("Hello from Interface A");
    }
}

interface B {
    default void display() {
        System.out.println("Hello from Interface B");
    }
}

class C implements A, B {
    // C inherits the default methods from both interfaces.
}

// Example 3: Use of the 'this' keyword
class Student {
    int age;

    Student(int age) {
        this.age = age; // Refers to the current object's age variable.
    }

    void displayAge() {
        System.out.println("Age = " + age);
    }
}

// Example 4: Use of the 'static' keyword
class StaticStudent {
    static String college = "GIETU";
    int rollNo;

    StaticStudent(int rollNo) {
        this.rollNo = rollNo;
    }

    static void showCollege() {
        System.out.println("College: " + college);
    }

    static {
        System.out.println("Static block executed");
    }

    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("College: " + college);
    }
}

// Example 5: Hybrid inheritance (multilevel + hierarchical inheritance)
class Demo {
    void showDemo() {
        System.out.println("Class Demo");
    }
}

class Demo1 extends Demo {
    void showDemo1() {
        System.out.println("Class Demo1");
    }
}

class Demo2 extends Demo1 {
    void showDemo2() {
        System.out.println("Class Demo2");
    }
}

// Demo2 and Demo3 both inherit from Demo1 (hierarchical inheritance).
// Demo -> Demo1 -> Demo2 forms the multilevel part.
class Demo3 extends Demo1 {
    void showDemo3() {
        System.out.println("Class Demo3");
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. Runtime polymorphism / method overriding
        System.out.println("1. METHOD OVERRIDING - BANK INTEREST RATES");
        Bank bank;

        bank = new SBI();
        System.out.println("SBI Rate of Interest: " + bank.getRateOfInterest() + "%");

        bank = new ICICI();
        System.out.println("ICICI Rate of Interest: " + bank.getRateOfInterest() + "%");

        bank = new Axis();
        System.out.println("Axis Rate of Interest: " + bank.getRateOfInterest() + "%");

        // 2. Multiple inheritance using interfaces
        System.out.println("\\n2. MULTIPLE INHERITANCE USING INTERFACES");
        C obj = new C();
        obj.show();
        obj.display();

        // 3. 'this' keyword
        System.out.println("\\n3. USE OF THIS KEYWORD");
        Student student = new Student(29);
        student.displayAge();

        // 4. 'static' keyword
        System.out.println("\\n4. USE OF STATIC KEYWORD");
        StaticStudent s1 = new StaticStudent(101);
        StaticStudent s2 = new StaticStudent(102);

        s1.display();
        s2.display();
        StaticStudent.showCollege();

        // 5. Hybrid inheritance
        System.out.println("\\n5. HYBRID INHERITANCE");
        Demo2 obj1 = new Demo2();
        obj1.showDemo();
        obj1.showDemo1();
        obj1.showDemo2();

        Demo3 obj2 = new Demo3();
        obj2.showDemo();
        obj2.showDemo1();
        obj2.showDemo3();
    }
}
