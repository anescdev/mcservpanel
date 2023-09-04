package es.anescdev.config.commandline.generator;

import jakarta.annotation.Nonnull;

/**
 * Interfaz usada para hacer las clases generadoras de configuraciones
 * @param <T>
 */
public interface ConfigGenerator<T> {
    boolean generateConfig();
    void setDefaultConfig(@Nonnull T configObject);
}
