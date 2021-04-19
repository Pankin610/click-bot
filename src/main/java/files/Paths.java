package files;

/**
 * Enum of useful paths.
 */
public enum Paths {
    PATH_WITH_PROGRAMS("src/main/java/testing/testPrograms/");

    private final String path;
    Paths(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
