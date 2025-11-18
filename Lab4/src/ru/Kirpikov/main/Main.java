package ru.Kirpikov.main;
import ru.Kirpikov.box.Box;
import ru.Kirpikov.box.BoxUtils;
import ru.Kirpikov.box.Coordinates3D;
import ru.Kirpikov.function.CollectFunction;
import ru.Kirpikov.function.FilterFunction;
import ru.Kirpikov.function.Functions;
import ru.Kirpikov.function.ReduceFunction;
import ru.Kirpikov.student.Student;
import ru.Kirpikov.validation.Validation;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите номер задания: ");
            System.out.println("Задание 1.4");
            System.out.println("Задание 2.3");
            System.out.println("Задание 3.1");
            System.out.println("Задание 3.2");
            System.out.println("Задание 3.3");
            System.out.println("Задание 3.4");

            String choice = scanner.next();
            switch (choice) {
                case "1.4":
                    try {
                        System.out.println("Введите имя первого студента:");
                        String name1 = scanner.next();
                        Validation.validateName(name1);

                        System.out.println("Введите количество оценок для первого студента:");
                        int arrSize1 = scanner.nextInt();
                        Validation.validateGradeArraySize(arrSize1);

                        Student s1 = new Student(name1, arrSize1);
                        for (int i = 0; i < arrSize1; i++) {
                            System.out.println("Введите оценку №" + (i + 1) + " (от 2 до 5):");
                            int grade = scanner.nextInt();
                            s1.addGrade(grade);
                        }

                        System.out.println("Введите имя второго студента:");
                        String name2 = scanner.next();
                        Validation.validateName(name2);

                        System.out.println("Введите количество оценок для второго студента:");
                        int arrSuze2 = scanner.nextInt();
                        Validation.validateGradeArraySize(arrSuze2);

                        Student s2 = new Student(name2, arrSuze2);
                        for (int i = 0; i < arrSuze2; i++) {
                            System.out.println("Введите оценку №" + (i + 1) + " (от 2 до 5):");
                            int grade = scanner.nextInt();
                            s2.addGrade(grade);
                        }
                        System.out.println();
                        System.out.println(s1);
                        System.out.println(s2);

                        int result = s1.compare(s2);

                        System.out.println(result);
                    }
                    catch (RuntimeException ex) {
                        System.out.println("Ошибка: " + ex.getMessage());
                    }
                    break;
                case "2.3":
                    Box<Coordinates3D> box = new Box<>();
                    BoxUtils.putRandomPoint(box);
                    break;
                case "3.1":
                    List<String> words1 = List.of("qwerty", "asdfg", "zx");
                    List<Integer> lengths = Functions.map(words1, String::length);
                    System.out.println("Длины строк: " + lengths);
                    List<Integer> numbers1 = List.of(1, -3, 7);
                    List<Integer> absValues = Functions.map(numbers1, n -> n < 0 ? -n : n);
                    System.out.println("Абсолютные значения: " + absValues);

                    List<int[]> arrays1 = List.of(
                            new int[]{1, 2, 3},
                            new int[]{-5, 0, -10},
                            new int[]{7, 7, 7});
                    List<Integer> maxValues = Functions.map(arrays1, arr -> {
                        int max = arr[0];
                        for (int x : arr) if (x > max) max = x;
                        return max;
                    });
                    System.out.println("Максимумы массивов: " + maxValues);
                    break;
                case "3.2":
                    List<String> words2 = List.of("qwerty", "asdfg", "zx");
                    List<Integer> numbers2 = List.of(1, -3, 7);
                    List<int[]> arrays2 = List.of(
                            new int[]{1, 2, 3},
                            new int[]{-5, 0, -10},
                            new int[]{7, 7, 7});
                    List<String> filteredStrings = FilterFunction.filter(words2, s -> s.length() >= 3);
                    System.out.println("Строки длиной >= 3: " + filteredStrings);

                    List<Integer> negativeNumbers = FilterFunction.filter(numbers2, n -> n < 0);
                    System.out.println("Только отрицательные числа: " + negativeNumbers);

                    List<int[]> onlyNegArrays = FilterFunction.filter(arrays2, arr -> {
                        for (int x : arr) if (x > 0) return false;
                        return true;
                    });
                    System.out.println("Массивы без положительных элементов:");
                    for (int[] arr : onlyNegArrays) {
                        System.out.println(Arrays.toString(arr));
                    }
                    break;
                case "3.3":
                    List<String> words3 = List.of("qwerty", "asdfg", "zx");
                    List<Integer> numbers3 = List.of(1, -3, 7);
                    List<int[]> arrays3 = List.of(
                            new int[]{1, 2, 3},
                            new int[]{-5, 0, -10},
                            new int[]{7, 7, 7});
                    String joined = ReduceFunction.reduce(words3, "", (a, b) -> a + b);
                    System.out.println("Объединённая строка: " + joined);

                    Integer sum = ReduceFunction.reduce(numbers3, 0, Integer::sum);
                    System.out.println("Сумма чисел: " + sum);

                    List<List<Integer>> listOfLists = List.of(
                            List.of(1, 2, 3),
                            List.of(4, 5),
                            List.of(6, 7, 8, 9)
                    );
                    Integer totalCount = ReduceFunction.reduce(
                            Functions.map(listOfLists, List::size),
                            0,
                            Integer::sum
                    );
                    System.out.println("Количество элементов во всех списках: " + totalCount);
                    break;
                case "3.4":
                    List<Integer> nums = List.of(1, -3, 7, -2, 4);

                    List<List<Integer>> separated = CollectFunction.collect(
                            nums,
                            ArrayList::new,
                            (list, n) -> {
                                if (list.isEmpty()) {
                                    list.add(new ArrayList<>());
                                    list.add(new ArrayList<>());
                                }
                                if (n >= 0) list.get(0).add(n);
                                else list.get(1).add(n);
                            }
                    );
                    System.out.println("Положительные и отрицательные: " + separated);

                    List<String> strings2 = List.of("qwerty", "asdfg", "zx", "qw");
                    Map<Integer, List<String>> byLength = new HashMap<>();
                    CollectFunction.collect(strings2, ArrayList::new, (l, s) -> {
                        byLength.computeIfAbsent(s.length(), k -> new ArrayList<>()).add(s);
                    });
                    System.out.println("Строки по длине: " + byLength);

                    List<String> strings3 = List.of("qwerty", "asdfg", "qwerty", "qw");
                    Set<String> unique = CollectFunction.collect(strings3, HashSet::new, Set::add);
                    System.out.println("Уникальные строки: " + unique);
                    break;
                default:
                    System.out.println("Нверный выбор");
            }
        }
    }
}
