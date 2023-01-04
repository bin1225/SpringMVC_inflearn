package hello.springmvc.basic.request;


import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RequestHeaderController {

	@RequestMapping("/headers")
	public String headers(HttpServletRequest request,
		HttpServletResponse response,
		HttpMethod httpMethod,
		Locale locale,
		@RequestHeader MultiValueMap<String, String>
			headerMap,
		@RequestHeader("host") String host,
		@CookieValue(value = "myCookie", required = false)
			String cookie
	) {
		log.info("request={}", request);
		log.info("response={}", response);
		log.info("httpMethod={}", httpMethod);
		log.info("locale={}", locale);
		log.info("headerMap={}", headerMap);
		log.info("header host={}", host);
		log.info("myCookie={}", cookie);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/request-param-required")
	public String requestParamRequired(
		@RequestParam(required = true) String username,
		@RequestParam(required = false) Integer age
	){
		log.info("username = {}, age = {}", username, age);
		return "ok";
	}
	@ResponseBody
	@RequestMapping("/request-param-default")
	public String requestParamDefault(
		@RequestParam(defaultValue = "guest") String username,
		@RequestParam(defaultValue = "-1") int age
	){
		log.info("username = {}, age = {}", username, age);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/request-param-map")
	public String requestParamMap(
		@RequestParam Map<String, Object> paramMap
	){
		log.info("username = {}, age = {}", paramMap.get("username"), paramMap.get("age"));
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/model-attribute-v1")
	public String modelAttributeV1(@ModelAttribute HelloData helloData, String username
	){
		//HelloData helloData = new HelloData();
		//helloData.setUsername(username);
		//helloData.setAge(age);
		log.info("username = {}", username);
		log.info("helloData = {}", helloData);
		return "ok";
	}

}
