package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Filters<T> {

    public static <T> List<T> filterMelons(
            List<T> melons, Predicate<T> predicate) {

        List<T> result = new ArrayList<>();

        for (T melon : melons) {
            if (melon != null && predicate.test(melon)) {
                result.add(melon);
            }
        }

        return result;
    }
}
