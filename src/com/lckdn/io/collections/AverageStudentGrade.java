package com.lckdn.io.collections;

public class AverageStudentGrade implements Comparable<AverageStudentGrade> {
    private String name;
    private float averageGrade;

    public AverageStudentGrade(String name, float averageGrade) {
        this.name = name;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public float getAverageGrade() {
        return averageGrade;
    }

    @Override
    public int compareTo(AverageStudentGrade that) {
        if (this.averageGrade < that.averageGrade) {
            return -1;
        }

        if (this.averageGrade > that.averageGrade) {
            return 1;
        }

        return name.compareTo(that.getName());
    }

    @Override
    public String toString() {
        return "AverageStudentGrade{" +
                "name='" + name + '\'' +
                ", averageGrade=" + averageGrade +
                '}';
    }
}
