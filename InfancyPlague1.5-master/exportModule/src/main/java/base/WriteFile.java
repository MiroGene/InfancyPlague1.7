package base;

import java.io.File;

/**
 * Created by Administrator on 2017/3/18.
 */
public class WriteFile {

    static public void createFile() {

        File file = new File("Novel.txt");
        File dir = new File("Chapter");
        dir.mkdir();
        System.out.println(dir.getAbsolutePath());
    }


    public static void main(String[] args) {

        WriteFile.createFile();

    }


}
