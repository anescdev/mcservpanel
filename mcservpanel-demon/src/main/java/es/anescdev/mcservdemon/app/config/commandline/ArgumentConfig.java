package es.anescdev.mcservdemon.app.config.commandline;

import com.beust.jcommander.Parameter;

public class ArgumentConfig {
    @Parameter(names = {"-g", "--generate"}, description = "Genera la configuración por defecto del servicio y la imprime en la salida, sin llegar a ejecutarse la aplicación")
    public boolean generate;
    @Parameter(names = {"-h", "--help"}, help = true)
    public boolean help;
}
