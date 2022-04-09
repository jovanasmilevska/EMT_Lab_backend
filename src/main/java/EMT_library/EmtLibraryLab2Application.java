package EMT_library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class EmtLibraryLab2Application {

    public static void main(String[] args) {
        SpringApplication.run(EmtLibraryLab2Application.class, args);
    }

}
