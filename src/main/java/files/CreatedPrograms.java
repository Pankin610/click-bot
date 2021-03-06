package files;

import files.reading.ReadFileObject;

import java.io.File;

/**
 * Utility class which shows names of created programs.
 */

public class CreatedPrograms {
  private CreatedPrograms() {
  }

  private static final String path = Paths.PATH_WITH_PROGRAMS.getPath();

  public static String[] getNames() {
    File file = new File(path);
    String[] res = file.list();
    if (res == null) return null;
    for (int i = 0; i < res.length; i++) {
      res[i] = String.valueOf(res[i].subSequence(0, res[i].length() - 4));
    }
    return res;
  }

  public static String getPathByName(String name) {
    return path + name + ".txt";
  }

  public static ReadFileObject getFileByName(String name) {
    return new ReadFileObject(path + name + ".txt");
  }
}
