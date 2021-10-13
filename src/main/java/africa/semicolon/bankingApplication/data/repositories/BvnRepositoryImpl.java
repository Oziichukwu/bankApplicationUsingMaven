package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Bvn;

import java.util.ArrayList;
import java.util.List;

public class BvnRepositoryImpl implements BvnRepository{

        private List<Bvn> bvns = new ArrayList<>();
    @Override
    public Bvn save(Bvn bvn) {
        bvns.add(bvn);
        return findByCustomerId(bvn.getId());
    }

    @Override
    public Bvn findByCustomerId(String id) {
        for (Bvn bvn : bvns){
            if(bvn.getId().equalsIgnoreCase(id)){
                return bvn;
            }
        }
        return null;
    }

    @Override
    public void delete(Bvn bvn) {
        bvns.remove(bvn);
    }

    @Override
    public void delete(String id) {
       Bvn bvn = findByCustomerId(id);
        delete(bvn);
    }

    @Override
    public List<Bvn> findAll() {
        return bvns;
    }
}
