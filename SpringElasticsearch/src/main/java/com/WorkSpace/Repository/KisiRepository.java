package com.WorkSpace.Repository;

import com.WorkSpace.entity.Kisi;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KisiRepository extends ElasticsearchRepository<Kisi,String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"ad\": \"?0\"}}]}}")
    //kisi ismine göre search edilmek istendiğinde
    List<Kisi> getByContomQuery(String search);
    //ad veya soyad ilk search edilmek istendiğinde örn: yunus için yun yazmak yeterli
    List<Kisi> findByAdlikeOrSoyadLike(String ad, String soyad);
}
