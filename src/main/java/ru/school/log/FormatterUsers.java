package ru.school.log;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class FormatterUsers extends Formatter {
    @Override
    public String format(LogRecord record) {
        return "\n"
                + new Date(record.getMillis()) +"\n"
                + record.getSourceClassName()+" ["
                + record.getSourceMethodName()+ "] "
                + record.getLevel() + ": \n"
                + record.getMessage() + "\n";
    }
}
