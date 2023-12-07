import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void isQuerySuitableForSimpleTask() { // тест успешного поиска в SimpleTask

        SimpleTask simpleTask = new SimpleTask(2, "Забрать заказ");
        String query = "Забрать заказ";

        boolean expected = true;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isQueryNotSuitableForSimpleTask() { // тест неуспешного поиска в SimpleTask

        SimpleTask simpleTask = new SimpleTask(2, "Забрать заказ");
        String query = "Забрать посылку";

        boolean expected = false;
        boolean actual = simpleTask.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isQuerySuitableForEpic() { // тест успешного поиска в Epic

        String[] subtasks = {"Картофель", "Тыква", "Мясо", "Хлеб", "Торт", "Чай"};
        Epic epic = new Epic(1, subtasks);

        String query = "Торт";

        boolean expected = true;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isQueryNotSuitableForEpic() { // тест неуспешного поиска в Epic

        String[] subtasks = {"Картофель", "Тыква", "Мясо", "Хлеб", "Торт", "Чай"};
        Epic epic = new Epic(1, subtasks);

        String query = "Кофе";

        boolean expected = false;
        boolean actual = epic.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isQuerySuitableForMeeting() { // тест успешного поиска в Meeting

        Meeting meeting = new Meeting(
                3,
                "Пойти в парикмахерскую",
                "Молодежная стрижка",
                "13 декабря в 15:00"
        );

        String query = "Молодежная стрижка";

        boolean expected = true;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void isQueryNotSuitableForMeeting() { // тест неуспешного поиска в Meeting

        Meeting meeting = new Meeting(
                3,
                "Пойти в парикмахерскую",
                "Молодежная стрижка",
                "13 декабря в 15:00"
        );

        String query = "Стрижка под ноль";

        boolean expected = false;
        boolean actual = meeting.matches(query);

        Assertions.assertEquals(expected, actual);
    }
}
