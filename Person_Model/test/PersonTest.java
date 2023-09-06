import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    //Test the constructors, all modifier/setter methods, and any additional special methods.
    // You do not test the getter/read methods.
    Person p1, p2, p3, p4, p5, p6;
    @BeforeEach
    void setup()
    {
        p1 = new Person("000abc","Bob","Smith","Mr.",1950);
        p2 = new Person("000123","Jane","Smith","Mrs.",1952);
        p3 = new Person("000234","Jack","Man","Mr.",1990);
        p4 = new Person("000bbb","Bobby","Smack","Mr.",1960);
        p5 = new Person("000abc","Ava","Nick","Ms.",1945);
        p6 = new Person("000abc","Chip","Dust","Dr.",1950);
    }

    @Test
    void setIDNum() {
        p1.setID("000123");
        assertEquals("000123", p1.getID());
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Jane");
        assertEquals("Jane", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Smith");
        assertEquals("Smith", p1.getLastName());
    }

    @Test
    void setYOB() {
        p1.setYOB(1952);
        assertEquals(1952, p1.getYOB());
    }
    @Test
    void setTitle(){
        p1.setTitle("Mrs.");
        assertEquals("Mrs.", p1.getTitle());
    }
    @Test
    void equals() {
        p1.setID("00000B");
        p1.setFirstName("Sally");
        p1.setLastName("Tester2");
        p1.setYOB(1975);
        p1.setTitle("Mrs.");
        assertEquals(false, p1.equals(p2));
    }
    @Test
    void fullname(){
        assertEquals("Bob Smith", p1.fullName());
    }
    @Test
    void formal(){
        assertEquals("Mr. Bob Smith", p1.formalName());
    }
    @Test
    void age(){
        assertEquals("73", p1.getAge());
    }
    @Test
    void age2(){
        assertEquals("72", p1.getAge(2022));
    }

}