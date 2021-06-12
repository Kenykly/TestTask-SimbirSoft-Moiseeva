import java.io.*;
import java.net.URL;

public class HTMLDownloader {

    private  String webAdress;

    private  String getWebAdress(){
        return  webAdress;
    }

    public void setWebAdress(String webAdress)  {
        this.webAdress = webAdress;

    }

    public HTMLDownloader(String webAdress) {
        this.webAdress = webAdress;

    }

    public HTMLDownloader() {
    }

    public void download() throws IOException {

        String htmlName = "page.html";
        File file;
        int count;
        byte[] buff = new byte[64];
        InputStream in = null;
        OutputStream out = null;

        try {
            file = new File(htmlName);
            out = new FileOutputStream(htmlName);
            in = new URL(webAdress).openStream();

            while ((count = in.read(buff)) != -1) {
                out.write(buff, 0, count);
            }

            System.out.println("\nHTML-страница загружена. Расположение: " +  file.getAbsolutePath());

        } catch (IOException e) {

            System.out.println("Не удалось скачать страницу. Пожалуйста, укажите полный и корректный адрес страницы.\n");
            System.out.println("Ошибка: " + e.getMessage());
            System.exit(1);

        } finally {

            in.close();
            out.flush();
        }


    }
}
