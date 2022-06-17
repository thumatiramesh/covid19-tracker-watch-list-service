package in.stackroute.covidApplication.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.stackroute.covidApplication.model.WatchList;

public interface WatchListRepository extends MongoRepository<WatchList, Long> {
	WatchList findByCountryAndUsername(String country, String username);
	
	List<WatchList> findByUsername(String username);
}
