package exercise1;
import java.util.Comparator;


public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student stu1, Student stu2) {
        if (stu1.getAge() == stu2.getAge()) {
            return stu1.getName().compareTo(stu2.getName());
        }
        else {
            return Integer.compare(stu1.getAge(), stu2.getAge());
        }
    }
}
