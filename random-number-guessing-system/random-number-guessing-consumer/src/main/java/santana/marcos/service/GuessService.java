package santana.marcos.service;

import santana.marcos.client.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuessService {
    @Autowired
    private ProviderClient providerClient;

    public String guess(int number) {
        return providerClient.guess(number);
    }
}