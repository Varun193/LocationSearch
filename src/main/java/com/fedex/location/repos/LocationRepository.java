package com.fedex.location.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fedex.location.entites.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

	@Query("select type, count(type) from location group by type ")
	List<Object[]> getTypeAndCount();
}
