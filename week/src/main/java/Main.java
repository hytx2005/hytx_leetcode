import java.io.*;
import java.util.*;

/**
 * @author ASUS
 */
public class Main implements Serializable{
    public class Student implements Comparable<Student>{
        public String name;


        @Override
        public int compareTo(Student other) {
            return other.name.compareTo(this.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            Student student = (Student) object;
            return Objects.equals(name, student.name);
        }
    }
    public static void main(String[] args) {
        TreeSet<Student> set = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        Student s1 = new Main().new Student();
        s1.name = "Alice";
        Student s2 = new Main().new Student();
        s2.name = "Bob";
        set.add(s1);
        set.add(s2);
        for (Student student : set) {
            System.out.println(student.name);
        }
    }
}
