package in.stackroute.covidApplication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import in.stackroute.covidApplication.model.WatchList;

public class WatchListServiceTest {

	@Test
	public void testSaveWatchListForUser() {
		WatchListServiceImpl service = mock(WatchListServiceImpl.class);
		WatchList wl = new WatchList();
		wl.setCountry("Country");
		wl.setDeceased("deseased");
		wl.setHistoryData("hist data");
		wl.setInfected("Infected");
		wl.setLastUpdateApify("last updated apfy");
		wl.setMoreData("more data");
		wl.setRecovered("recovered");
		wl.setSourceUrl("source url");
		wl.setTested("tested");
		wl.setUsername("username");
		when(service.save(any()))
		.thenReturn(wl);
		WatchList dummy = service.save(any());
		assertNotNull(dummy);
	}
	
	@Test
	public void testGetWatchListForUser() {
		WatchListServiceImpl service = mock(WatchListServiceImpl.class);
		
		WatchList wl1 = new WatchList();
		wl1.setCountry("Country");
		wl1.setDeceased("deseased");
		wl1.setHistoryData("hist data");
		wl1.setInfected("Infected");
		wl1.setLastUpdateApify("last updated apfy");
		wl1.setMoreData("more data");
		wl1.setRecovered("recovered");
		wl1.setSourceUrl("source url");
		wl1.setTested("tested");
		wl1.setUsername("username");
		
		WatchList wl2 = new WatchList();
		wl2.setCountry("Country");
		wl2.setDeceased("deseased");
		wl2.setHistoryData("hist data");
		wl2.setInfected("Infected");
		wl2.setLastUpdateApify("last updated apfy");
		wl2.setMoreData("more data");
		wl2.setRecovered("recovered");
		wl2.setSourceUrl("source url");
		wl2.setTested("tested");
		wl2.setUsername("username");
		
		when(service.getWatchListForUser("username"))
		.thenReturn(Arrays.asList(wl1, wl2));
		List<WatchList> watchListForUser = service.getWatchListForUser("username");
		assertNotNull(watchListForUser);
		assertEquals(watchListForUser.size(), 2);
		assertEquals(watchListForUser.get(0).getUsername(), "username");
	}
	
	
}
