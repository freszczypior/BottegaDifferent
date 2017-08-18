package pl.com.bottega.books;

public class Person {

    private String firstN;
    private String lastN;
    private Gender gender;

    public Person(String firstN, String lastN) {
        if (firstN == null || lastN == null)
            throw new IllegalArgumentException("First name, last name and age are required.");
        this.firstN = firstN;
        this.lastN = lastN;

    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!firstN.equals(person.firstN)) return false;
        if ((!lastN.equals(person.lastN))) return false;
        //TODO PYTANIE do poniżej.. a co jak gender!=null a person.gender==null, nie rzuci wyjątkiem??
        return gender!=null ? gender.equals(person.gender) : person.gender == null;
    }
    @Override
    public int hashCode(){
        int result = firstN.hashCode();
        result = result * 31 + lastN.hashCode();
        result = result * 31 + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    public String getFirstN() {
        return firstN;
    }

    public String getLastN() {
        return lastN;
    }
}
