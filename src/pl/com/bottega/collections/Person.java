package pl.com.bottega.collections;

public class Person {

    private String firstN;
    private String lastN;
    private Integer age;
    private Gender gender;

    public Person(String firstN, String lastN, Integer age) {
        if (firstN == null || lastN == null || age == null)
            throw new IllegalArgumentException();
        this.firstN = firstN;
        this.lastN = lastN;
        this.age = age;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

//    @Override
//    public boolean equals(Object other){
//        if (!(other instanceof AbstractPerson) || other == null)
//            return false;
//        AbstractPerson otherPerson = (AbstractPerson) other;
//        return firstN.equals(otherPerson.firstN) &&
//                lastN.equals(otherPerson.lastN) &&
//                age.equals(otherPerson.age) &&
//                ((gender == otherPerson.gender) ||
//                        (gender != null && (gender.equals(otherPerson.gender))));
//    }


//    @Override
//    public boolean equals(Object o) {   // wygenerowana automatycznie przez generate > equals and hash
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        AbstractPerson person = (AbstractPerson) o;
//
//        if (!firstN.equals(person.firstN)) return false;
//        if (!lastN.equals(person.lastN)) return false;
//        if (!age.equals(person.age)) return false;
//        return gender != null ? gender.equals(person.gender) : person.gender == null;
//    }


    @Override
    public boolean equals(Object o) {   // automat z zaznaczonym subclass
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!firstN.equals(person.firstN)) return false;
        if (!lastN.equals(person.lastN)) return false;
        if (!age.equals(person.age)) return false;
        return gender != null ? gender.equals(person.gender) : person.gender == null;
    }

    @Override
    public int hashCode() {
        int result = firstN.hashCode();
        result = 31 * result + lastN.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    public String getFirstN() {
        return firstN;
    }

    public String getLastN() {
        return lastN;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "AbstractPerson{" +
                ", lastN='" + lastN + '\'' +
                "firstN='" + firstN + '\'' +
                ", age=" + age +
                '}';
    }
}
