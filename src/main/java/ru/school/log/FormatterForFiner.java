package ru.school.log;


import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class FormatterForFiner extends Formatter {
    @Override
    public String format(LogRecord record) {
        return "\n"
                + record.getSourceClassName()+" ["
                + record.getSourceMethodName()+ "] "
                + record.getLevel() + ": \n"
                + record.getMessage() + "\n";
    }
}
