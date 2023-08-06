package es.anescdev.mcservdemon;


import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Formatter LOG_FORMATTER = new Formatter() {
        private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("Date: dd-MM-uuuu Time: HH:mm:ss");
        @Override
        public String format(LogRecord record) {
            return String.format("[%s] [%s] [%s] : %s" , record.getLevel(),
                    LocalDateTime.ofInstant(record.getInstant(), ZoneOffset.UTC).format(this.dtf),
                    record.getLoggerName(), record.getMessage());
        }
    };
    public static void main( String[] args )
    {
    }
    public static Logger createLogger(Class<?> classForLog){
        Logger logger = Logger.getLogger(classForLog.getName());
        logger.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(App.LOG_FORMATTER);
        logger.addHandler(consoleHandler);
        return logger;
    }
}
