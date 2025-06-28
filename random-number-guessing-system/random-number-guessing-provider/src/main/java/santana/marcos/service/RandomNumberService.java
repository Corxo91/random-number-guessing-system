package santana.marcos.service;

import santana.marcos.mapper.RandomNumberMapper;
import santana.marcos.entity.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomNumberService {
    @Autowired
    private RandomNumberMapper randomNumberMapper;

    public int getOrCreateRandomNumber() {
        RandomNumber rn = randomNumberMapper.getRandomNumber();
        if (rn == null) {
            int number = new Random().nextInt(100) + 1;
            randomNumberMapper.insertRandomNumber(number);
            return number;
        }
        return rn.getNumber();
    }

    public void clearRandomNumber() {
        randomNumberMapper.deleteAll();
    }
}