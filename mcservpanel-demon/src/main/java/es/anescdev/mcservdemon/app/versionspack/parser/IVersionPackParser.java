package es.anescdev.mcservdemon.app.versionspack.parser;

import java.io.File;

import java.util.List;
import java.util.Optional;

public interface IVersionPackParser {
    Optional<List<RVersionPackEntry>> parseVersionsPack(File versionsPackFile);
}
