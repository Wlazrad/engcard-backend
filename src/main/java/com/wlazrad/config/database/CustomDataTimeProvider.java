package com.wlazrad.config.database;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.stereotype.Component;

import java.time.temporal.TemporalAccessor;
import java.util.Optional;

@Component("dateTimeProvider")
public class CustomDataTimeProvider implements DateTimeProvider{
    @Override
    public Optional<TemporalAccessor> getNow() {
        return Optional.empty();
    }
}
