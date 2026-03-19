package Bai06;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class FactoryRegistry {
    private final Map<String, SalesChannelFactory> factories = new LinkedHashMap<>();

    public void register(SalesChannelFactory factory) {
        factories.put(factory.getCode(), factory);
    }

    public SalesChannelFactory get(String code) {
        return factories.get(code);
    }

    public Collection<SalesChannelFactory> list() {
        return factories.values();
    }
}

