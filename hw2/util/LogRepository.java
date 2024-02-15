package hw2.util;

import java.util.List;

public interface LogRepository {
    void save(List<String> log);
    List<String> load();
}
