package lab.nayottama.mahasiswanayottama.repo;

import lab.nayottama.mahasiswanayottama.entity.mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaRepo extends JpaRepository<mahasiswa, String> {
}
