package pl.com.bottega.cwiczeniowe.collections;

import java.util.*;

public class PersonUtils {

    public static int k, v;

    public static void main(String[] args) {

        Person p1 = new Person("Jan", "Kowalski", 17);
        Person p2 = new Person("Janina", "Nowak", 22);
        Person p3 = new Person("Grzegorz", "Wiśniewski", 30);
        Person p4 = new Person("Jan", "Kowalski", 17);
        Person p5 = new Person("Jan", "Kowalski", 44);

        List<Person> people = new LinkedList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);

        Set<Person> peopleSet = new HashSet<>();
        peopleSet.add(p1);
        peopleSet.add(p2);
        peopleSet.add(p3);
        peopleSet.add(p4);
        peopleSet.add(p5);

        System.out.println("Pierwsza osoba powyżej 20 lat: " + firstIndexOver20(people));
        System.out.println("Inna pierwsza osoba powyżej 20 lat: " + anotherFirstIndexOver20(people));

        displaySortedPeople(people);

        System.out.println("Posortowane wg wieku powyżej 20 lat " + above20SortedByAge(peopleSet));

        System.out.println("Czy zbiór zawiera osobę? --> " + containsPerson(peopleSet, "Jan", "Kowalski", 18));

        System.out.println("Mapa ludzi z kluczem wieku: " + ageMap(people));
    }

    public static int firstIndexOver20(List<Person> persons) {
        int counter = 0;
        for (Person p : persons) {
            if (p.getAge() > 20) {
                return counter;
            }
            counter++;
        }
        return -1;
    }


    public static int anotherFirstIndexOver20(List<Person> persons) {

        for (ListIterator<Person> i = persons.listIterator(); i.hasNext(); ) {
            Person person = i.next();
            if (person.getAge() > 20)
                return i.previousIndex();
        }
        return -1;
    }

    public static void displaySortedPeople(Collection<Person> people) {

        List<Person> peopleList = new ArrayList<>(people);
        peopleList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {

                //-1 o1 < o2
                // 0 o1 == o2
                // 1 o1 > o2

                int compareLastName = o1.getLastName().compareTo(o2.getLastName());
                if (compareLastName == 0) {
                    int compareFirstName = o1.getFirstName().compareTo(o2.getFirstName());
                    if (compareFirstName == 0) {
                        return o2.getAge().compareTo(o2.getAge());
                    }
                    else
                        return compareFirstName;
                }
                 else
                    return compareLastName;
                }
            }
            );

        Comparator<Person> otherComparator = new Comparator<Person>() {

            private static final int LAST_NAME_PRIORITY = 0;
            private static final int FIRST_NAME_PRIORITY = 0;
            private static final int AGE_PRIORITY = 1;
            @Override
            public int compare(Person o1, Person o2) {
                int compareLastName = (int) Math.signum(o1.getLastName().compareTo(o2.getLastName()));
                int compareFirstName = (int) Math.signum(o1.getFirstName().compareTo(o2.getFirstName()));
                int compareAge = (int) Math.signum(o2.getAge().compareTo(o2.getAge()));
                return compareLastName * LAST_NAME_PRIORITY +
                        compareFirstName * FIRST_NAME_PRIORITY +
                        compareFirstName * AGE_PRIORITY;
            }
        };
        peopleList.sort(otherComparator);
            for(Person person : peopleList){
                System.out.println(person);
            }
        }

        public static List<Person> above20SortedByAge(Set<Person> people){

            List<Person> peopleList = new ArrayList<>(people);
            List<Person> peopleListAbove20 = new ArrayList<>();

            for (ListIterator<Person> i = peopleList.listIterator(); i.hasNext(); ) {
                Person person = i.next();
                if (person.getAge() > 20)
                    peopleListAbove20.add(person);
            }

            Comparator<Person> nextComparator = new Comparator<Person>() {

                @Override
                public int compare(Person o1, Person o2) {
                    int compareAge = (int) Math.signum(o2.getAge().compareTo(o2.getAge()));
                    return compareAge;
                }
            };
            peopleListAbove20.sort(nextComparator);
            return peopleListAbove20;
        }

        public static List<Person> peopleListOver20Sorted(Set<Person> people){

            List<Person> sortedPeople = new LinkedList<>(people);
            sortedPeople.sort(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return o1.getAge().compareTo(o2.getAge());
                }
            });
            for (ListIterator<Person> i = sortedPeople.listIterator(); i.hasNext();)
                if (i.next().getAge() <= 20)
                    i.remove();
                else
                    break;
            return sortedPeople;
        }

        public static boolean containsPerson(Set<Person> people, String firstName, String lastName, Integer age){
            return people.contains(new Person(firstName, lastName, age));
        }

        public static Map<Integer, Integer> ageMap(Collection<Person> people) {

            Map<Integer, Integer> peopleMap = new HashMap<>();

            for (Person p : people) {
                Integer currentCount = peopleMap.get(p.getAge());
                if (currentCount == null)
                    peopleMap.put(p.getAge(), 1);
                else
                    peopleMap.put(p.getAge(), currentCount + 1);
            }
                return peopleMap;
        }
}













/*                if (o1.getLastName().compareTo(o2.getLastName()) > 0 )
                    return -1;
                else if (o1.getLastName().compareTo(o2.getLastName()) < 0)
                    return 1;
                else if (o1.getLastName().compareTo(o2.getLastName()) == 0)
                    if (o1.getFirstName().compareTo(o2.getFirstName()) > 0)
                        return -1;
                    else if (o1.getFirstName().compareTo(o2.getFirstName()) < 0)
                        return 1;
                    else if (o1.getFirstName().compareTo(o2.getFirstName()) == 0)
                        if (o1.getAge() < o2.getAge())
                            return -1;
                        else if (o1.getAge() > o2.getAge())
                            return 1;
                return 0; */


/*    public static void set() {
    Set<Person> peopleSet = new HashSet<>();
    peopleSet.add(p1);
    peopleSet.add(p2);
}*/
