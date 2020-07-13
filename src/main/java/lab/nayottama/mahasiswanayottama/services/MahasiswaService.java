package lab.nayottama.mahasiswanayottama.services;

import lab.nayottama.mahasiswanayottama.entity.mahasiswa;
import lab.nayottama.mahasiswanayottama.model.MahasiswaModel;
import lab.nayottama.mahasiswanayottama.repo.MahasiswaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MahasiswaService {

    @Autowired
    private MahasiswaRepo repo;

    public List<mahasiswa> getAllData() {
        return repo.findAll();
    }

    public mahasiswa convertToEntity(MahasiswaModel model) {
      mahasiswa result = new mahasiswa();
      result.setNim(model.getNim());
      result.setNama(model.getNama());
      result.setJurusan(model.getJurusan());
      result.setAlamat(model.getAlamat());
      return result;
  }

  public mahasiswa save(mahasiswa mhs) {
      return repo.save(mhs);
  }

  public Optional<mahasiswa> findById(String nim) {
    return repo.findById(nim);
}

public void removeById(String nim) {
    repo.deleteById(nim);
}

}
