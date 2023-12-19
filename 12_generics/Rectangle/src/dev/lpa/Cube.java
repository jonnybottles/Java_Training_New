package dev.lpa;

public class Cube extends Rectangle {

    private double height;
    private static int theObjectCount;

    public Cube(double length, double width, double height) {
        super(length, width);
        this.height = height;
    }

    public void increase() {
        theObjectCount++;
    }

    @Override
    public double area() {

        return 2*(getLength())*(getWidth())+2*(getLength())*(height)+2*(getWidth())*(height);
    }

    @Override
    public String toString() {
        return "Shape: " + getClass().getSimpleName() + "\n" +
                "Length: " + getLength() + "\n" +
                "Width: " + getWidth() + "\n" +
                "Height: " + height + "\n" +
                "Area: " + area() + "\n";
    }
}
//
//
//a) Static methods in a class are called via the class name (e.g. Integer.parseInt()) and not via the instantiated object (myObect.someNonStaticMethod()). Static methods are meant to be used essentially as helper methods. They can be used by other parts of your program, external to the class.
//
//b) Static members of a class share the same data across instantiated objects. Whereas non-static data member's data is specific to that instantiated object and not shared across objects. For example, if I wanted to keep track of how many Rectangle objects I have instantiated, I could create a member variable with the following keyword / access modifiers "private static int theRectangleCount;". Then within the constructor, every time an object is constructed I could increase theRectangleCount by one. This data is then accessible to all Rectangle objects.
//
//c). Polymorphism is a concept applied to classes as it relates to inheritance. As the name implies, poly (meaning many) allows your classes / subclasses to morph it's behavior (e.g. methods) where required. Polymorphism provides a great deal of flexibility by allowing a sub-class to inherit all of the common&nbsp; &nbsp;attributes and behavior of it's base class, but also allows you to implmenent sub-class specific behaviors that are unique to that particular class (e.g. overriding toString as did in the previous questions as an example) while sharing the same method names.
//
//        d) Composition vs inheritance. The common saying for composition is that it institutes a "has a" relationship, whereas with inheritance, it is considered an "is a" relationship. Inheritance is used when their is some sort of class heirarchy amongst your classes, where you classes are closely related and need to share some of the same attributes / methods. This greatly decreases the amount of code reuse. An example of inheritance would be program called CarDealership. In this program you could create a base Vehicle class, then a Car class that extends Vehicle, then a Chevy class that extends car, etc. An example of composition with this program would be to then create a DealerShip class, which would utilize composition, as it would contain Vehicle objects within the class.&nbsp;
//
//e) Abstract classes are classes that define the attributes and methods of those classes which will extend that given abstract class. The abstract class itself does not implement the methods / behaviors, but it does outline what methods its sub-classes must include. Abstract classes are much like a contract, it outlines behaviors that the sub-classes must implement.
//
//
//        f) Java interfaces are somewhat like abstract classes, but instead it's contract only defines the behavior that must be implemented and has no attributes associated with it. Furthermore, unlike inheritance where you can only extend from one base class, with interfaces you can extend / implement multiple interfaces. Java interfaces provide a great wealth of flexibility, particulary when writing programs that are used by multiple external entities who rely upon that interface. Through many of the features of interfaces, Java now allows for the ability to update interfaces, without breaking the programs which rely upon it.
//
//
