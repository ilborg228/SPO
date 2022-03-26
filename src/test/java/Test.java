import com.example.spo.utils.ForCompiler;
import com.example.spo.utils.IfCompiler;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(ForCompiler.execute("int i=0;i<9;i++"));
        System.out.println(IfCompiler.execute("false"));
    }
}
