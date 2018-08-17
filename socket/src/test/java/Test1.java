import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 千里明月 on 2018/7/23.
 */
public class Test1 {
    protected synchronized void test(String name) {
        System.out.println(name);
    }

    private final static String file1 = "F:\\cloundMusic\\allMusic";
    private final static String file2 = "F:\\cloundMusic";

    public static void main(String[] args) throws IOException {
        File allMusic = new File(file1);
        File cloundMusic = new File(file2);
        File[] files = cloundMusic.listFiles();
        for (File file : files) {
            File[] files1 = file.listFiles();
            for (File file3 : files1) {
                File file4 = new File(allMusic, file3.getName());
                FileInputStream inputStream = new FileInputStream(file3);
                FileOutputStream outputStream = new FileOutputStream(file4);
                byte[] buffer = new byte[9999];
                int i = 0;
                while ((i = inputStream.read(buffer)) != -1){
                    outputStream.write(buffer);
                }
            }
        }
//        Test1 test1 = new Test1();
//        test1.te();
    }

    private void te(){
        File file = new File(file1);
        File[] files = file.listFiles();
        for (File file3 : files) {
            String name = file3.getName();
            file3.renameTo(new File(file3.getParentFile(),"明月-"+name));
        }
    }
}
