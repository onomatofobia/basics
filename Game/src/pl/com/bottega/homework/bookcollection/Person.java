package pl.com.bottega.homework.bookcollection;

import pl.com.bottega.cwiczeniowe.collections.Gender;

public class Person implements Comparable{
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;

    public Person(String firstName, String lastName){

        if (firstName == null || lastName == null)
            throw new IllegalArgumentException();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

/*    @Override
    public boolean equals(Object other){

        if (!(other instanceof Person))
            return false;
        Person otherPerson = (Person) other;

        return otherPerson != null &&
                firstName.equals(otherPerson.firstName) &&
                lastName.equals(otherPerson.lastName) &&
                age.equals(otherPerson.age) &&
                ( (gender == otherPerson.gender) ||
                        (gender != null && gender.equals(otherPerson.gender))) ;
    }*/


 /*   public boolean hashCode(){

    }*/

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!firstName.equals(person.firstName)) return false;
        if (!lastName.equals(person.lastName)) return false;
        return gender == person.gender;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}


