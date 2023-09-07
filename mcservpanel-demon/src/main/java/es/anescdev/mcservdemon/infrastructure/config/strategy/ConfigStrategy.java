package es.anescdev.mcservdemon.infrastructure.config.strategy;

import es.anescdev.mcservdemon.infrastructure.config.ConfigParam;
import jakarta.annotation.Nonnull;

public interface ConfigStrategy {
    /**
     * Obtiene el valor de una configuración específica.
     * @param configParam Nombre del parámetro de la configuración
     * @return Valor obtenido de la configuración pasada
     */
    String getConfigValue(@Nonnull ConfigParam configParam);
}
