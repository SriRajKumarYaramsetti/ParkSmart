package Repositories;

import Models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {

    private Map<Long,Gate> gates=new TreeMap<>();    //{1:gate1,2:gate2,3:gate3}

    public Optional<Gate> findGateById(Long id){
        if(gates.containsKey(id)) {
            return Optional.of(gates.get(id));
        }
        return Optional.empty();


    }
}
