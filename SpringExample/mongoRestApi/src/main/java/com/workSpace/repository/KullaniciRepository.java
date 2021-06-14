package com.workSpace.repository;

import com.workSpace.entity.Kullanici;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KullaniciRepository extends MongoRepository <Kullanici,String>{


}
