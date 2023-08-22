import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class Student02 {
    // id,name,department,grade
    private String name, department, id;
    private double grade;

    public Student02(String name, String department, String id, double grade) {
        this.name = name;
        this.department = department;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student02 [name=" + name + ", department=" + department + ", id=" + id + ", grade=" + grade + "]";
    }

}

public class StudentTest {
    public static void main(String[] args) {
        HashMap<String, Student02> studentList = new HashMap<>();
        studentList.put("장성호", new Student02("장성호", "java", "01", 3.0));
        studentList.put("장동건", new Student02("장동건", "python", "01", 3.0));
        studentList.put("정형돈", new Student02("정형돈", "c#", "01", 3.0));
        studentList.put("유재석", new Student02("장성호", "node", "01", 3.0));
        // Set<String> keys = studentList.keySet();
        // java.util.Iterator<String> it = keys.iterator();
        // while (it.hasNext()) {
        // System.out.println(studentList.get(it.next()).toString());
        // }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("학생 이름을 입력하시오");
            String name = scanner.nextLine();
            if (name.equals("그만"))
                return;
            if (studentList.get(name) == null) {
                System.out.println("없는 학생입니다. 우리 학교에 10년째 다니는 다리없는 콩콩콩 뛰어 다니는 애 있습니다.");
            } else {
                System.out.println(studentList.get(name).toString());
            }
        }
    }
}
