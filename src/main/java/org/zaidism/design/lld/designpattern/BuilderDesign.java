package org.zaidism.design.lld.designpattern;

class Employee {

    private final String name;
    private final String address;
    private final String id;
    private final String gender; // cannot change
    private final String hobbies; //optional

    private Employee(EmployeeBuilder employeeBuilder) {
        this.name = employeeBuilder.name;
        this.address = employeeBuilder.address;
        this.id = employeeBuilder.id;
        this.gender = employeeBuilder.gender;
        this.hobbies = employeeBuilder.hobbies;
    }

    //getters

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }

    static class EmployeeBuilder {

        private String name;
        private String address;
        private String id;
        private String gender;
        private String hobbies;

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public EmployeeBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public EmployeeBuilder setHobbies(String hobbies) {
            this.hobbies = hobbies;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}


public class BuilderDesign {

    public static void main(String[] args) {
        Employee employee1 = new Employee.EmployeeBuilder()
                .setAddress("Address 1")
                .setGender("MALE")
                .setName("Zahid")
                .setId("lsdnlndnj2w")
                .build();

        Employee employee2 = new Employee.EmployeeBuilder()
                .setAddress("Address 1")
                .setName("Ram")
                .setId("wjejw")
                .setHobbies("Playing cricket")
                .build();

        System.out.println(employee1);
        System.out.println(employee2);
    }
}
