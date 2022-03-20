import com.example.spo.jni.JNI;

//To run add to jvm options:
//-Djava.library.path="{Your path to project}\SPO\src\main\java\com\example\spo\jni"
public class Test {
    public static void main(String[] args) {
        JNI jni = new JNI();
        System.out.println(jni.MULTIPLY(3,2));
        System.out.println(jni.OR(3,2));
    }
}
