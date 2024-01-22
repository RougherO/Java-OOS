import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class q12 {
    public static void main(String[] args) {
        Student s1 = new Student("Student 1", 1,
                List.of("Subject 1", "Subject 2", "Subject 3", "Subject 4", "Subject 5"));
        Student s2 = new Student("Student 2", 2,
                List.of("Subject 1", "Subject 2", "Subject 3", "Subject 4", "Subject 5"));
        Student s3 = new Student("Student 3", 3,
                List.of("Subject 1", "Subject 2", "Subject 3", "Subject 4", "Subject 5"));

        TabulationSheet tbSheet1 = new TabulationSheet("Subject 1", List.of(s1, s2, s3));
        TabulationSheet tbSheet2 = new TabulationSheet("Subject 2", List.of(s1, s2, s3));
        TabulationSheet tbSheet3 = new TabulationSheet("Subject 3", List.of(s1, s2, s3));
        TabulationSheet tbSheet4 = new TabulationSheet("Subject 4", List.of(s1, s2, s3));
        TabulationSheet tbSheet5 = new TabulationSheet("Subject 5", List.of(s1, s2, s3));

        tbSheet1.putMarks(1, 80);
        tbSheet2.putMarks(1, 80);
        tbSheet3.putMarks(1, 80);
        tbSheet4.putMarks(1, 80);
        tbSheet5.putMarks(1, 80);

        tbSheet1.putMarks(2, 90);
        tbSheet2.putMarks(2, 90);
        tbSheet3.putMarks(2, 90);
        tbSheet4.putMarks(2, 90);
        tbSheet5.putMarks(2, 90);

        tbSheet1.putMarks(3, 100);
        tbSheet2.putMarks(3, 100);
        tbSheet3.putMarks(3, 100);
        tbSheet4.putMarks(3, 100);
        tbSheet5.putMarks(3, 100);

        MarkSheet mkSheet1 = new MarkSheet(s1,
                List.of(tbSheet1, tbSheet2, tbSheet3, tbSheet4, tbSheet5)
                        .stream()
                        .collect(Collectors.toMap(
                                (tbSheet) -> tbSheet.getSubject(),
                                (tbSheet) -> tbSheet.getMarks(s1.getRoll()))));

        MarkSheet mkSheet2 = new MarkSheet(s2,
                List.of(tbSheet1, tbSheet2, tbSheet3, tbSheet4, tbSheet5)
                        .stream()
                        .collect(Collectors.toMap(
                                (tbSheet) -> tbSheet.getSubject(),
                                (tbSheet) -> tbSheet.getMarks(s2.getRoll()))));

        MarkSheet mkSheet3 = new MarkSheet(s3,
                List.of(tbSheet1, tbSheet2, tbSheet3, tbSheet4, tbSheet5)
                        .stream()
                        .collect(Collectors.toMap(
                                (tbSheet) -> tbSheet.getSubject(),
                                (tbSheet) -> tbSheet.getMarks(s3.getRoll()))));

        System.out.println("" + mkSheet1 + mkSheet2 + mkSheet3);
    }
}

class Student {
    Student(String name, Integer rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.subjects = new ArrayList<>();
    }

    Student(String name, Integer rollNo, List<String> subjects) {
        this.name = name;
        this.rollNo = rollNo;
        this.subjects = subjects;
    }

    public String getName() {
        return this.name;
    }

    public Integer getRoll() {
        return this.rollNo;
    }

    public List<String> getSubjects() {
        return this.subjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public void addSubject(String subject) {
        this.subjects.add(subject);
    }

    public void removeSubject(String subject) {
        this.subjects.remove(subject);
    }

    @Override
    public String toString() {
        return "\nRoll: " + this.rollNo +
                "\nName: " + this.name +
                "\nSubjects: " + this.subjects;
    }

    private String name;
    private Integer rollNo;
    private final List<String> subjects;
}

class TabulationSheet {
    TabulationSheet(String subject, List<Student> students) {
        this.subject = subject;
        this.rollWiseMarksMap = students
                .stream()
                .collect(Collectors.toMap(Student::getRoll, (rollNo) -> 0));
    }

    public String getSubject() {
        return this.subject;
    }

    public Map<Integer, Integer> getRollWiseMarksMap() {
        return this.rollWiseMarksMap;
    }

    public Integer getMarks(Integer rollNo) {
        return this.rollWiseMarksMap.get(rollNo);
    }

    public void putMarks(Integer rollNo, Integer marks) {
        this.rollWiseMarksMap.put(rollNo, marks);
    }

    public Integer getTotalMarks() {
        return this.rollWiseMarksMap
                .values()
                .stream()
                .reduce((curr, next) -> curr + next)
                .get();
    }

    public Integer getTotalRollCount() {
        return this.rollWiseMarksMap
                .keySet()
                .size();
    }

    private final String subject;
    private final Map<Integer, Integer> rollWiseMarksMap;
}

class MarkSheet {
    MarkSheet() {
        this.student = new Student("Default", 0);
        this.subjectWiseMarks = new HashMap<>();
    }

    MarkSheet(Student student) {
        this.student = student;
        this.subjectWiseMarks = new HashMap<>();
    }

    MarkSheet(Student student, Map<String, Integer> subjectWiseMarks) {
        this.student = student;
        this.subjectWiseMarks = subjectWiseMarks;
    }

    public String getName() {
        return this.student.getName();
    }

    public Integer getMarks(String subject) {
        return this.subjectWiseMarks.get(subject);
    }

    public void setName(String name) {
        this.student.setName(name);
    }

    public void putMarks(String subject, Integer marks) {
        this.subjectWiseMarks.put(subject, marks);
    }

    @Override
    public String toString() {
        return "\nMarkSheet:" +
                "\nStudent: " + student +
                "\nSubject Wise Marks: " + subjectWiseMarks
                        .entrySet()
                        .stream()
                        .sorted((entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()))
                        .collect(Collectors.toList());
    }

    private Student student;
    private final Map<String, Integer> subjectWiseMarks;
}