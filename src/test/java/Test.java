import com.example.spo.model.MyCode;
import com.example.spo.utils.ForAnalyzer;
import com.example.spo.utils.ForCompiler;
import com.example.spo.utils.IfAnalyzer;
import com.example.spo.utils.IfCompiler;

public class Test {
    public static void main(String[] args) throws Exception {
        MyCode targetCode = IfAnalyzer.getTargetCode("if(5<9){int b;}");
        System.out.println(IfCompiler.execute(targetCode));
        MyCode m = ForAnalyzer.getTargetCode("for(int i=0;i<8;i++){}");
        try{
            System.out.println(ForCompiler.execute(m));
        }
        catch (Exception e){
            System.out.println("j");
        }
    }
}
