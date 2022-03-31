import com.example.spo.model.CSV;
import com.example.spo.model.CsvEntity;
import com.example.spo.repository.Repository;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Repository<CsvEntity> repository = new Repository<>();
        repository.save(new CsvEntity("file","version", "creation"));
    }
}