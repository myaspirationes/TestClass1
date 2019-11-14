import java.io.File;

public class ClassUnderTest {
    public boolean callInternalInstance(String path) {

        File file = new File(path);

        return file.exists();

    }

    public boolean callArgumentInstance(File file) {

        return file.exists();

    }
}
