import java.io.*;

/**
 * @author ASUS
 */
public class Main implements Serializable{
    public class Student implements Serializable {
        String name;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) throws IOException {
        Student student = new Main().new Student("Alice", 20);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"));
        try {
            oos.writeObject(student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            oos.close();
        }

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"));
        try {
            try {
                Object o = ois.readObject();
                Student deserializedStudent = (Student) o;
                System.out.println("Name: " + deserializedStudent.getName());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
