import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        List<String> dirList = Arrays.asList("F:/", "Game", "F:/Game", "src", "F:/Game", "res", "F:/Game", "savegames", "F:/Game", "temp", "F:/Game/src", "main"
                , "F:/Game/src", "test", "F:/Game/res", "drawables", "F:/Game/res", "vectors", "F:/Game/res", "icons");
        for (int i = 0; i < dirList.size(); i = i + 2) {
            int j = i + 1;
            File dir = new File(dirList.get(i), dirList.get(j));
            createDirectiy(dir);
        }

        List<String> fileList = Arrays.asList("F:/Game/temp", "temp.txt", "F:/Game/src/main", "Main.java", "F:/Game/src/main", "Utils.java");
        for (int i = 0; i < fileList.size(); i = i + 2) {
            int j = i + 1;
            File file = new File(fileList.get(i), fileList.get(j));
            createFile(file);
        }

        try (FileWriter q = new FileWriter("F:/Game/temp/temp.txt")) {
            q.write(String.valueOf(sb));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void createDirectiy(File name) {
        if (name.mkdir())
            sb.append(" Directory " + name.getName() + " - create. " + "\n");
        else
            System.out.println(" Directory " + name.getName() + " not create");
    }

    static void createFile(File q) throws IOException {
        if (q.createNewFile())
            sb.append(q.getParent() + " File " + q.getName() + " - create. ");
        else
            System.out.println(q.getParent() + " File " + q.getName() + " not create");
    }

}

