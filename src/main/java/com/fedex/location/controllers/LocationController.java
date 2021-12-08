package com.fedex.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fedex.location.entites.Location;
import com.fedex.location.repos.LocationRepository;
import com.fedex.location.service.LocationService;
import com.fedex.location.utils.EmailSender;
import com.fedex.location.utils.ReportUtil;

@Controller
public class LocationController {
	@Autowired
	LocationService locationService;

	@Autowired
	EmailSender emailSender;

	@Autowired
	LocationRepository locationRepository;

	@Autowired
	ReportUtil reportUtil;

	@Autowired
	ServletContext servletContext;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";// createLocation
	}

	@RequestMapping("/saveloc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		System.out.println(location);
		Location savedLocation = locationService.saveLocation(location);
		System.out.println(savedLocation);
		String msg = "Location saved" + savedLocation.getId();
		System.out.println(msg);
		modelMap.addAttribute("msg", msg);
		// emailSender.sendEmail("princevarun1935@gmail.com","Testing our app","hi
		// message sent to your mail");
		return "createLocation";

	}

	@RequestMapping("/dislpayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> allLocations = locationService.getAllLocations();
		modelMap.addAttribute("allLocationsKey", allLocations);
		return "dislpayLocations";

	}

	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		locationService.deleteLocation(locationService.getLocationById(id));
		List<Location> locations = locationService.getAllLocations();
		modelMap.addAttribute("allLocationsKey", locations);
		return "dislpayLocations";
	}

	@RequestMapping("/updateLocation")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = locationService.getLocationById(id);
		modelMap.addAttribute("locationKey", location);
		return "updateLocations";

	}

	@RequestMapping("/updateloc")
	public String UpdateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		locationService.updateLocation(location);
		List<Location> allLocations = locationService.getAllLocations();
		modelMap.addAttribute("allLocationsKey", allLocations);
		return "dislpayLocations";
	}

	@RequestMapping("/generateReport")
	public String generateReport() {

		String path = servletContext.getRealPath("/");
		List<Object[]> typeAndCount = locationRepository.getTypeAndCount();
		reportUtil.PieChart(path, typeAndCount);
		return "report";

	}

}
