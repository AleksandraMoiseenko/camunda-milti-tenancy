package example.data;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
public class ProcessMap {
    // Нужно хранить в базе данных
    private Map<String, String> processNameToTenant = new HashMap<String, String>() {{
        put("tenant1", "Balance");
        put("tenant2", "Limit");
    }};

}
