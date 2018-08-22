package com.javamentor.kidstarter.service.interfaces;

import com.javamentor.kidstarter.model.user.Kid;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface KidService {

    Kid getKidById(Long id);
    Kid addKid(Kid kid);
    List<Kid> getAllKids();
    void deleteKidById(Long id);
    void updateKid(Kid kid);
}
