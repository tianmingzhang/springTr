package com.smart.test;

import com.smart.domain.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeMethod;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class GroupTest {
    @Test
    public void testhandle41() {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        restTemplate.getMessageConverters().add(jsonConverter);

        User user = new User();
        user.setUserName("tom");
        user.setPassword("1234");
        HttpHeaders entityHeaders = new HttpHeaders();
        entityHeaders.setContentType(MediaType.valueOf("application/json;UTF-8"));
        entityHeaders.setAccept(Collections.singletonList(MediaType.TEXT_PLAIN));
        HttpEntity<User> requestEntity = new HttpEntity<User>(user, entityHeaders);
        String result = restTemplate.postForObject(
                "http://localhost:8001/bbs/handle41.html", requestEntity,String.class);
        assertEquals("success",result);
    }

    @Test
    public void testhandle11() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add("userName", "tom");
        form.add("password", "123456");
        form.add("age", "45");
        String result = restTemplate.postForObject(
                "http://localhost:8001/bbs/handle11.html", form,String.class);
        assertEquals("success",result);
    }
}
