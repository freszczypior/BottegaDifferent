package pl.com.bottega.collections;


import java.util.*;

public class PersonUtils {

    public static void main(String[] args) {
        Person p1 = new Person("jan", "nowak", 19);
        Person p2 = new Person("marek", "prym", 20);
        Person p3 = new Person("teresa", "bąk", 30);
        Person p4 = new Person("teresa", "bąk", 35);

        List<Person> list = new LinkedList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        Set<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
//        System.out.println(firstIndexOver20(list));
//        System.out.println(firstIndexOver20Iterator(list));

//        System.out.println("********************");
//        displaySortetPeople(list);
//        System.out.println("*********************");
//        System.out.println(containPerson(set, "bąk", "teresa", 30));


        for (Object temp : sortPersonOver20ByAge(set)) {
            System.out.println(temp);
        }
//        System.out.println("mapa *********************");
//        Collection<AbstractPerson> collection = list;
//        for (Object temp : generateMap(collection).keySet()) {
//            System.out.println(temp);
//        }


    }

    public static int firstIndexOver20(List<Person> persons) {
        int index = 0;
        for (Person temp : persons) {
            if (temp.getAge() > 20)
                return index;
            index++;
        }
        return -1;
    }

    public static int firstIndexOver20Iterator(List<Person> list) {
        for (ListIterator<Person> iter = list.listIterator(); iter.hasNext(); ) {
            Person person = iter.next();
            if (person.getAge() > 20)
                return iter.previousIndex();
        }
        return -1;
    }

    public static void displaySortetPeople(Collection<Person> list) {
        List<Person> personList = new ArrayList<>(list);        // podając w konst tworze liste z takimi samymi elementami jak kolekcja
//        personList.sort(new Comparator<AbstractPerson>() {
//            @Override
//            public int compare(AbstractPerson o1, AbstractPerson o2) {
//                int compareLastN =  o1.getLastN().compareTo(o2.getLastN());
//                if (compareLastN == 0) {
//                    int compareFirstN = o1.getFirstN().compareTo(o2.getFirstN());
//                    if (compareFirstN == 0) {
//                        int compareAge = o1.getAge().compareTo(o2.getAge());
//                        if (compareAge == 0);
//                        return compareAge;
//                    }else
//                        return compareFirstN;
//                }else
//                    return compareLastN;
//            }
//        });
        personList.sort(new Comparator<Person>() {          // inny comparator
            private static final int LAST_N_PRIORITY = 100;
            private static final int FIRST_N_PRIORYTY = 10;
            private static final int AGE_PRIORYTY = 1;

            @Override
            public int compare(Person o1, Person o2) {
                int compareLastN = (int) Math.signum(o1.getLastN().compareTo(o2.getLastN()));
                int compareFirstN = (int) Math.signum(o1.getFirstN().compareTo(o2.getFirstN()));
                int compareAge = (int) Math.signum(o1.getAge().compareTo(o2.getAge()));
                return compareLastN * LAST_N_PRIORITY + compareFirstN * FIRST_N_PRIORYTY + compareAge * AGE_PRIORYTY;
            }

        });
        for (Person temp : personList) {
            System.out.println(temp);
        }
    }

    //    public static List sortPersonOver20ByAge(Set<AbstractPerson> set) { // najpierw filtrujemy a póxniej sortujemy
//        List<AbstractPerson> list = new ArrayList<>();
//        for (AbstractPerson temp : set) {
//            if (temp.getAge() > 20)
//                list.add(temp);
//        }
//        list.sort(new Comparator<AbstractPerson>() {
//            @Override
//            public int compare(AbstractPerson o2, AbstractPerson o1) {
//                return o2.getAge().compareTo(o2.getAge());
//            }
//        });
//       return list;
//    }
    public static List sortPersonOver20ByAge(Set<Person> set) { // najpierw sortujemy a póniej filtrujemy
        List<Person> sortedList = new LinkedList<>(set);
        sortedList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o2, Person o1) {  // jak kolenośc o2, o1 to desc, a jak o1, o2 to asc

                return o2.getAge().compareTo(o1.getAge());
            }
        });
        for (Iterator<Person> iter = sortedList.iterator(); iter.hasNext(); )
            if (iter.next().getAge() <= 20)
                iter.remove();
            else
                break;
        return sortedList;
    }

    public static boolean containPerson(Set<Person> people, String firstN, String lastN, Integer age) {
        return people.contains(new Person(lastN, firstN, age));
    }

    public static Map<Integer, Integer> generateMap(Collection<Person> personList) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Person temp : personList) {
            if (map.containsKey(temp.getAge()))
                map.put(temp.getAge(), map.get(temp.getAge() + 1));
            else
                map.put(temp.getAge(), 1);
        }
        return map;
    }

    public static Map<Integer, Integer> generateMapV2(Collection<Person> personList) {   // versja druga, optymalniejsza, bo pod contains i tak jest get, a więc wywołujemy geta dwa razy
        Map<Integer, Integer> map = new HashMap<>();
        for (Person temp : personList) {
            Integer contains = map.get(temp.getAge());
            if (contains == null)
                map.put(temp.getAge(), 1);
                else
                map.put(temp.getAge(), map.get(temp.getAge() + 1));
        }
        return map;
    }
}
