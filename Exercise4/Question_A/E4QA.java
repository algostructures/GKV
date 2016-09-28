import java.io.*;
import java.util.*;
public class E4QA{
    public static void main(String arg[]) throws IOException{
        File newFile = new File("Sample.txt");
        if(newFile.exists()){
            System.out.println("File Exists");
            if(newFile.canRead())
                System.out.println("File is Readable");
            else
                System.out.println("File is not Readable");

            if(newFile.canWrite())
                System.out.println("File is Writable");
            else
                System.out.println("File is not Writable");

            if(newFile.canRead() && newFile.canWrite()){
                System.out.println("Type : "+getFileExtension(newFile));
                System.out.println("Size : "+newFile.length()+" bytes");
            }
        }
    }
    private static String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }

}
