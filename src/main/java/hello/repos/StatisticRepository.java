package hello.repos;

import hello.domain.Statistic;
import hello.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;

@Repository
public interface StatisticRepository extends CrudRepository<Statistic, Integer> {
    boolean existsStatisticByUserIdAndDate(Integer id, Calendar date);
    Statistic findByUserIdAndDate(Integer id, Calendar date);

}
