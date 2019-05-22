package com.smart.web;

import com.smart.domain.User;

import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Collections;


public class UserControllerTest  {

    @Test
    public void testhandle51WithJson() {

        RestTemplate restTemplate = buildRestTemplate();

        User user = new User();
        user.setUserName("tom");
        user.setPassword("1234");

        HttpHeaders entityHeaders = new HttpHeaders();
        entityHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));
        entityHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<User> requestEntity = new HttpEntity<User>(user, entityHeaders);

        ResponseEntity<User> responseEntity = restTemplate.exchange(
                "http://localhost:8001/bbs/handle41.html",
                HttpMethod.POST, requestEntity, User.class);

        User responseUser = responseEntity.getBody();
        Assert.assertNotNull(responseUser);
        Assert.assertEquals("11111", responseUser.getPassword());
    }

    @Test
    public void testhandle11() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("userName", "tom");
        restTemplate.postForLocation(
                "http://192.168.100.13:8001/bbs/handle11.html",null, form);
    }

    private RestTemplate buildRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        System.out.println(jsonConverter.getSupportedMediaTypes());

        restTemplate.getMessageConverters().add(jsonConverter);
        return restTemplate;
    }

}
