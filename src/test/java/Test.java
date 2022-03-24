import com.example.spo.jni.JNI;
import com.example.spo.utils.ForCompiler;

//To run add to jvm options:
//-Djava.library.path="{Your path to project}\SPO\src\main\java\com\example\spo\jni"
public class Test {
    public static void main(String[] args) {
        ForCompiler f = new ForCompiler();
        f.compile("");
    }
}
