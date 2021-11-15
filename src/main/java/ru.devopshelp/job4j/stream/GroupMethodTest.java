package job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GroupMethodTest {
    @Test
    public void test() {
        GroupMethod.User1 u1 = new GroupMethod.User1(10, "Ivan");
        GroupMethod.User1 u2 = new GroupMethod.User1(10, "Boris");
        GroupMethod.User1 u3 = new GroupMethod.User1(15, "Semen");
        GroupMethod.User1 u4 = new GroupMethod.User1(20, "Petr");
        Map<Integer, List<GroupMethod.User1>> expect = Map.of(
                10, List.of(u1, u2),
                15, List.of(u3),
                20, List.of(u4)
        );
        assertEquals(expect, GroupMethod.groupBy(
                List.of(u1, u2, u3, u4)
        ));
    }
}