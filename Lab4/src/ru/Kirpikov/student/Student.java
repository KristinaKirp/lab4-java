package ru.Kirpikov.student;

import ru.Kirpikov.validation.Validation;

import java.util.Arrays;

public class Student implements Comparable {
    private final String name;
    private final int[] grades;
    private int gradeCount;
    private double gpa;

    public Student(String name, int gradeArraySize) {
        Validation.validateName(name);
        Validation.validateGradeArraySize(gradeArraySize);

        this.name = name;
        this.grades = new int[gradeArraySize];
        this.gradeCount = 0;
    }

    public void addGrade(int grade) {
        Validation.validateGrade(grade);

        if (grades.length == 0) {
            throw new RuntimeException("Нельзя добавить оценку: массив имеет размер 0.");
        }
        if (gradeCount >= grades.length) {
            throw new RuntimeException("Массив оценок заполнен!");
        }

        grades[gradeCount++] = grade;
        AverageGrade();
    }

    private void AverageGrade() {
        if (this.gradeCount == 0) {
            gpa = 0.0;
        }
        int sum = 0;
        for (int i = 0; i < this.gradeCount; i++) {
            sum += this.grades[i];
        }
        gpa = (double) sum/this.gradeCount;
    }

    public double getGpa() {
        return gpa;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Студент: " + name +
                ", оценки: " + Arrays.toString(grades) +
                ", средний балл: " + gpa ;
    }

    @Override
    public int compare (Object obj) {
        if (!(obj instanceof Student)) {
            throw new IllegalArgumentException("Можно сравнивать только студентов!");
        }

        Student other = (Student) obj;

        if (this.gpa > other.gpa) return 1;
        if (this.gpa < other.gpa) return -1;
        return 0;
    }
}
