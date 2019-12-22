package hello.repos;

import hello.domain.Statistic;
import hello.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends CrudRepository<Statistic, Integer> {
}
