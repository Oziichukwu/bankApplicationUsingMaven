package africa.semicolon.bankingApplication.data.repositories;

import africa.semicolon.bankingApplication.data.models.Bvn;

import java.util.List;

public interface BvnRepository {

    Bvn save(Bvn bvn);
    Bvn findByCustomerId(String id);
    void delete(Bvn bvn);
    void delete(String id);
    List<Bvn> findAll();
}
