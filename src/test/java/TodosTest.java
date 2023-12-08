import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() { // тест на добавление новых задач
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSimpleTaskAmongAllTasks() { // Тест на успешный поиск SimpleTask среди всех задач
        SimpleTask simpleTask = new SimpleTask(1, "Выполнить дз");

        String[] subtasks = {"Кефир", "Сметана", "Ряженка"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Сходить на собеседование",
                "вакансия QA инженер",
                "в пятницу в 11:00"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Выполнить дз");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchEpicAmongAllTasks() { // Тест на успешный поиск Epic среди всех задач
        SimpleTask simpleTask = new SimpleTask(1, "Выполнить дз");

        String[] subtasks = {"Кефир", "Сметана", "Ряженка"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Сходить на собеседование",
                "вакансия QA инженер",
                "в пятницу в 11:00"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Сметана");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeetingAmongAllTasks() { // Тест на успешный поиск Meeting среди всех задач
        SimpleTask simpleTask = new SimpleTask(1, "Выполнить дз");

        String[] subtasks = {"Кефир", "Сметана", "Ряженка"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Сходить на собеседование",
                "вакансия QA инженер",
                "в пятницу в 11:00"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Сходить на собеседование");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSeveralTasksAmongAllTasks() { // Тест на успешный поиск нескольких задач среди всех задач
        SimpleTask simpleTask = new SimpleTask(1, "Выполнить дз");

        String[] subtasks = {"Кефир", "Сметана", "Ряженка"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Выполнить дз",
                "по модулю наследование и полиморфизм",
                "к воскресенью к 23:59"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("Выполнить дз");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchZeroTasksAmongAllTasks() { // Тест на неуспешный поиск среди всех задач
        SimpleTask simpleTask = new SimpleTask(1, "Выполнить дз");

        String[] subtasks = {"Кефир", "Сметана", "Ряженка"};
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Сходить на собеседование",
                "вакансия QA инженер",
                "в пятницу в 11:00"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Выполнить домашнее задание");
        Assertions.assertArrayEquals(expected, actual);
    }
}
