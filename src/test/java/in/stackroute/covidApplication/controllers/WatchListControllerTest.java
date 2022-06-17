package in.stackroute.covidApplication.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import in.stackroute.covidApplication.BaseTest;
import in.stackroute.covidApplication.controller.WatchListController;
import in.stackroute.covidApplication.model.WatchList;
import in.stackroute.covidApplication.service.WatchListService;

public class WatchListControllerTest extends BaseTest {


	protected MockMvc mvc;

	private static final String URI = "/wishlist/";


	@Test
	public void testWatchListSave() throws Exception {
		WatchListController controller = mock(WatchListController.class);
		MockMvc mvc = MockMvcBuilders.standaloneSetup(controller).build();
		WatchListService service = mock(WatchListService.class);
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
		String inputInJson = this.mapToJson(wl);
		Mockito.when(service.save(any(WatchList.class))).thenReturn(wl);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI + "save").accept(MediaType.APPLICATION_JSON)
				.content(inputInJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void testGetWatchListByUsername() throws Exception {
		WatchListController controller = mock(WatchListController.class);
		MockMvc mvc = MockMvcBuilders.standaloneSetup(controller).build();
		WatchListService service = mock(WatchListService.class);
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
		List<WatchList> list = Arrays.asList(wl1, wl2);
		Mockito.when(service.getWatchListForUser("username")).thenReturn(list);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI + "get/username")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
}
