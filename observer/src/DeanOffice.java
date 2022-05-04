import interfaces.Observer;

import java.util.HashMap;
import java.util.Map;

public class DeanOffice implements Observer {

    public Map<String, Boolean> _reportStatuses = new HashMap<>();

    @Override
    public void update(Object value) {
        _reportStatuses.put((String) value, true);
    }

    public String getReport() {
        if (!_reportStatuses.containsValue(false)) {
            return "All professors filled reports";
        }

        StringBuilder result = new StringBuilder("Professors that didn't fill reports:\n");
        for (var id : _reportStatuses.keySet()) {
            if (!_reportStatuses.get(id)) {
                result.append("\tTeacher ").append(id).append("\n");
            }
        }
        return result.toString();
    }

    public void nextWeek() {
        _reportStatuses.replaceAll((i, v) -> false);
    }
}
