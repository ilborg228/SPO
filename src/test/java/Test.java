import com.example.spo.jni.JNI;
import com.example.spo.utils.ForCompiler;
import com.example.spo.utils.MyCompiler;

//To run add to jvm options:
//-Djava.library.path="{Your path to project}\SPO\src\main\java\com\example\spo\jni"
public class Test {
    public static void main(String[] args) throws Exception {
        MyCompiler.compile("class MyClass {\n" +
                "  public static void main(String args[]) {\n" +
                "    System.out.println(\"Hello, World\");\n" +
                "  }\n" +
                "}");
    }
}
