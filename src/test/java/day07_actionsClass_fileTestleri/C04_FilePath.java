package day07_actionsClass_fileTestleri;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilePath {
    @Test
    public void test01(){
        String dosyaYolu="C:\\Users\\belkıs oruç\\OneDrive\\Masaüstü\\Devir Yetki Sözleşmesi .docx";
        boolean sonuc= Files.exists(Paths.get(dosyaYolu));
        System.out.println(sonuc);
        System.out.println(System.getProperty("user.home"));
        dosyaYolu="C:\\Users\\belkıs oruç\\OneDrive\\Masaüstü\\Devir Yetki Sözleşmesi .docx";
        dosyaYolu=System.getProperty("user.home") + "\\OneDrive\\Masaüstü\\Devir Yetki Sözleşmesi .docx";
    }
}
