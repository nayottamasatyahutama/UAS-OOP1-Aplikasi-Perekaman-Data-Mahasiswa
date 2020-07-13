package lab.nayottama.mahasiswanayottama.repo;

import lab.nayottama.mahasiswanayottama.entity.mahasiswa;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class MahasiswaRepoTest {

    @Autowired
    private MahasiswaRepo repo;

    private Logger logger = LoggerFactory.getLogger(MahasiswaRepoTest.class);

    @Test
    public void findAllTest() {
        List<mahasiswa> result = repo.findAll();
        logger.info("isi datanya : " + result.size());
        Assert.notEmpty(result);
    }

}
