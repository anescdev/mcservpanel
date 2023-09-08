package es.anescdev.mcservdemon.rest.dto;

public record ServerInfoDto(boolean allowRemoteInstall, int[] instances, int[] modules) {

}
