package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;


public class SmartArrayApp {

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
                return ((Student)st).getYear() == 2 && ((Student)st).getGPA() >= 4;
            }
        };

        MyComparator comp = new MyComparator() {
            @Override
            public int compare(Object st1, Object st2) {
                String sur1 = ((Student)st1).getSurname();
                String sur2 = ((Student)st2).getSurname();
                return sur1.compareTo(sur2);
            }

            };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object st) {
                return ((Student)st).getSurname() + " " +  ((Student)st).getName();
            }
        };

        SmartArray smart = new BaseArray(students);

        smart = new DistinctDecorator(smart);
        smart = new FilterDecorator(smart, pred);
        smart = new SortDecorator(smart, comp);
        smart = new MapDecorator(smart, func);

        Object[] result = smart.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
