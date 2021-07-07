package com.indigo.fashion.web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.indigo.fashion.DesignApplication;
import com.indigo.fashion.config.Receiver;
import com.indigo.fashion.model.City;
import com.indigo.fashion.model.Supplier;
import com.indigo.fashion.service.*;

@RestController
public class MainController {
	
	@Autowired
	private ProductService  ProductService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private Receiver receiver;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DesignApplication.class);
	
//	@Value("${anvc:}")
//	private String activeProfile;
//	
//
//	@Autowired
//    private Environment environment;
	
	@Bean
	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {

		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.addMessageListener(listenerAdapter, new PatternTopic("chat"));

		return container;
	}
	
	
	

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	@Bean
	Receiver receiver() {
		return new Receiver();
	}

	@Bean
	StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
		return new StringRedisTemplate(connectionFactory);
	}



	@RequestMapping("/")
	public @ResponseBody String index() {
		
//		for(String s:ProductService.getProducts())
//			System.out.println(s);
//		
		return "Greetings from Spring Boot!";
		
	}
	
	@RequestMapping("/main")
	public ModelAndView main() {	
		
		
//	    
//	        for (String profileName : environment.getActiveProfiles()) {
//	            System.out.println("Currently active profile - " + profileName);
//	        }  
//	    
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("greeting");
	    mav.setViewName("index");
	    mav.addObject("name", "Abeyta");
	    return mav;
	}
	
	
//	@GetMapping("/cities")
//	public String abc(Model model) {
//	    Map<String, String> map = new HashMap<>();
//	    map.put("spring", "mvc");
//	    model.addAttribute("message", "Baeldung");
//	    model.mergeAttributes(map);
//	    return "showCities";
//	}
	
		
	@GetMapping("/cities")
	public ModelAndView findCities() {	
		ModelAndView mav = new ModelAndView();	   
		System.out.println(" cities :: "+ (List<City>) cityService.findAll());
	    mav.addObject("cities", (List<City>) cityService.findAll());
	    mav.setViewName("showCities");
	    return mav;
	}
	
	
	
	
	
	@PostMapping("/employees")
	 public Supplier newEmployee(@RequestBody Supplier newSupplier) {
		Supplier apr  =  new Supplier();				
	    return apr;
	  }
	
		
	
	@GetMapping("name/{category}")
	public ModelAndView getSubCategoryforCategories(@PathVariable("category") String category,Model model){
		
		System.out.println("category  "+category);
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "Nimo");
		mav.setViewName("greeting");	  
		
		return mav;
	}
	
	@Autowired
	private ApplicationContext appContext;
	
	
	@RequestMapping("/m")
	public @ResponseBody String indexs() {
		
//		for(String s:ProductService.getProducts())
//			System.out.println(s);
//		
		return "Greetings from Spring Boot!";
		
	}
	
	
	
	
	@GetMapping("/sendmg")
	public  String sendMessage() {		
		System.out.println("  call: ");
		StringRedisTemplate template = appContext.getBean(StringRedisTemplate.class);
		LOGGER.info("Sending message...");
			template.convertAndSend("chat", "Hello from Redis!");		
		return "Greetings from Spring Boot!";

	}

}

//https://zetcode.com/spring/modelandview/