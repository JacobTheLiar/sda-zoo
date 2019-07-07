package pl.jacob_the_liar.sda_zoo.helpers;

import java.time.LocalDateTime;

public class DateProvider implements IDateProvider {
    @Override
    public LocalDateTime getDateTime() {
        return LocalDateTime.now();
    }
}
