package hello.repos;

import hello.domain.Statistic;
import hello.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface StatisticRepository extends CrudRepository<Statistic, Integer> {
    Statistic findByDate(Date date);
    Statistic findStatisticByUserId(Integer id);
    boolean existsByUserId(Integer id);
}
