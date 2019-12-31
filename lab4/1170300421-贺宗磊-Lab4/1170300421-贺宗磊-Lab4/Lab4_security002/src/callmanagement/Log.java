package callmanagement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Log {
    public static FileOutputStream output;
    public Log() {
        try {
            File f=new File("log.txt");
            if(f.exists()) {
                System.out.println("文件存在");
            }else {
                System.out.println("文件不存在");
            }
            FileOutputStream output = new FileOutputStream(f, true);
            Log.output=output;
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
