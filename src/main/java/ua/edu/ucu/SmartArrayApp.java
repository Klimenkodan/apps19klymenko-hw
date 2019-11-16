package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;


public class SmartArrayApp {
    static final double MINGPA = 4;
    static final int YEARREQUIRED = 2;

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        MyPredicate pred = new MyPredicate() {
            @Override
            public boolean test(Object st) {
                Student stud = (Student) st;
                return stud.getYear() == YEARREQUIRED && stud.getGPA() >= MINGPA;
            }
        };

        MyComparator comp = new MyComparator() {
            @Override
            public int compare(Object st1, Object st2) {
                String surFirst = ((Student)st1).getSurname();
                String surSecond = ((Student)st2).getSurname();
                return surFirst.compareTo(surSecond);
            }

            };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object st) {
                Student student = (Student) st;
                return student.getSurname() + " " +  student.getName();
            }
        };

        SmartArray smart = new BaseArray(students);
        smart = new DistinctDecorator(smart);
        System.out.println(Arrays.toString(smart.toArray()));
        smart = new FilterDecorator(smart, pred);
        System.out.println(Arrays.toString(smart.toArray()));
        smart = new SortDecorator(smart, comp);
        System.out.println(Arrays.toString(smart.toArray()));
        smart = new MapDecorator(smart, func);

        Object[] result = smart.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
