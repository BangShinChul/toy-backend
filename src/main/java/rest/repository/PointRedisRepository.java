package rest.repository;

import org.springframework.data.repository.CrudRepository;
import rest.model.Point;

public interface PointRedisRepository extends CrudRepository<Point, String> {
}
