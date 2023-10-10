package es.anescdev.mcservdemon.context.jarversion.domain.model;

import java.io.File;

public record RJarVersion(String tag, String version, File jar) {
}
