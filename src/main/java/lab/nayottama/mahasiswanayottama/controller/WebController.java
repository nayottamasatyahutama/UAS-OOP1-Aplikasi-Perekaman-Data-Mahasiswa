package lab.nayottama.mahasiswanayottama.controller;

import lab.nayottama.mahasiswanayottama.entity.mahasiswa;
import lab.nayottama.mahasiswanayottama.model.MahasiswaModel;
import lab.nayottama.mahasiswanayottama.services.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    private MahasiswaService service;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("mhs", service.getAllData());
        return "index";
    }

    @GetMapping("/tambah")
    public String tampilkanTambahForm(Model model) {
        model.addAttribute("mhs", new MahasiswaModel());
        return "tambah-mahasiswa";
    }

    @PostMapping("/simpan")
    public String simpan(MahasiswaModel mhs) {
        service.save(service.convertToEntity(mhs));
        return "redirect:/";
    }

    @GetMapping("/ubah/{nim}")
    public String edit(@PathVariable("nim") String nim, Model model) {
        Optional<mahasiswa> result = service.findById(nim);
        if(result.isPresent()) {
            mahasiswa data = result.get();
            model.addAttribute("mhs", data);
            return "edit-mahasiswa";
        } else return "redirect:/";
    }

    @GetMapping("/hapus/{nim}")
    public String hapus(@PathVariable("nim") String nim) {
        service.removeById(nim);
        return "redirect:/";
    }

}
