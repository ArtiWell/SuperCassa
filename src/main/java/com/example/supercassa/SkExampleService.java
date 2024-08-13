package com.example.supercassa;
import com.example.supercassa.Entity.SkExampleEntity;
import com.example.supercassa.Entity.SkExampleRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SkExampleService {

    @Autowired
    private SkExampleRepository repository;

    @Transactional
    public int modifyObject(Long id, int add) {
        SkExampleEntity entity = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Entity not found"));

        JSONObject jsonObject = new JSONObject(entity.getObj());
        int current = jsonObject.getInt("current");

        current += add;
        jsonObject.put("current", current);

        entity.setObj(jsonObject.toString());
        repository.save(entity);

        return current;
    }
}