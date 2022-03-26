import com.example.spo.model.MyCode;
import com.example.spo.utils.ForAnalyzer;
import com.example.spo.utils.ForCompiler;
import com.example.spo.utils.IfCompiler;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(IfCompiler.execute("false"));
        MyCode m = ForAnalyzer.getTargetCode("");
        System.out.println(ForCompiler.execute(m));
    }
}
