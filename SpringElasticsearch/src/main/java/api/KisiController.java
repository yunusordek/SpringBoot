package api;

import com.WorkSpace.Repository.KisiRepository;
import com.WorkSpace.entity.Kisi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kisi")
public class KisiController {
    private KisiRepository kisiRepository;

    @PostConstruct
    public void init(){
        Kisi kisi =new Kisi();
        kisi.setAd("Yunus");
        kisi.setSoyad("Emre");
        kisi.setAdres("İstanbul");
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        kisi.setId("K0001");
        kisiRepository.save(kisi);
    }


    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
       List<Kisi> kisiList = kisiRepository.getByContomQuery(search);
        return ResponseEntity.ok(kisiList);
    }
}
