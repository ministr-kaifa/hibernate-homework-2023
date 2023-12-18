package ru.hh.school.dao;

import org.hibernate.SessionFactory;
import ru.hh.school.employers.StatisticsDto;
import ru.hh.school.entity.Area;

public class VacancyDao extends GenericDao {
  public VacancyDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public StatisticsDto getSalaryStatistics(Area area){
    return getSession().createQuery("""
        select new ru.hh.school.employers.StatisticsDto(
            count(v.id), 
            min(v.compensationFrom), 
            max(v.compensationTo)
        )
        from Vacancy v where v.area.id = :areaId""", StatisticsDto.class)
        .setParameter("areaId", area.getId())
        .getSingleResult();
  }
}
