package org.zaidism.corejava;


import static org.zaidism.model.EmployeeProvider.printSeparation;

class Person implements Cloneable {
    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

}

class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}

public class CloningTechniques {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address originalAddress = new Address("New York");
        Person originalPerson = new Person("John", originalAddress);
        shallowClone(originalPerson);
        printSeparation();
        deepClone(originalPerson);

    }

    private static void shallowClone(Person originalPerson) throws CloneNotSupportedException {
        // Creating an original person object with address

        System.out.println("Original Person : " + originalPerson);

        // Shallow cloning
        Person shallowClonedPerson = (Person) originalPerson.clone();

        // Changing city in the cloned object will affect the original object
        shallowClonedPerson.getAddress().setCity("Shallow Clone City");
        System.out.println("After Shallow Clone after making changes in shallow cloned Person: " + shallowClonedPerson);
        System.out.println("Original Person after shallow clone : " + originalPerson);
    }

    private static void deepClone(Person originalPerson) {
        System.out.println("Person before deep clone : " + originalPerson);

        // Deep cloning
        Person deepClonedPerson = new Person(originalPerson.getName(), new Address(originalPerson.getAddress().getCity()));

        // Changing city in the cloned object won't affect the original object
        deepClonedPerson.getAddress().setCity("Deep Clone City");
        System.out.println("Deep Cloned Person after changing deep clone object: " + deepClonedPerson);
        System.out.println("Original Person after deep cloning: " + originalPerson);
    }
}

