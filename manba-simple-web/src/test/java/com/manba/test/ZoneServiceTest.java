package com.manba.test;

import com.manba.simple.ManBaApplicationLauncher;
import com.manba.simple.api.OpenUserService;
import com.manba.simple.common.domain.ServiceResponse;
import com.manba.simple.domain.request.UserLoginRequest;
import com.manba.simple.domain.response.UserInfoResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lijin on 2017/10/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ManBaApplicationLauncher.class)
public class ZoneServiceTest {

    @Autowired
    OpenUserService openUserService;

    @Test
    public void testOneUser() {
        UserLoginRequest request = new UserLoginRequest();
        request.setUserId("1");
        ServiceResponse<UserInfoResponse> serviceResponse = openUserService.queryUserInfo(request);
        UserInfoResponse response = serviceResponse.getResult();
        System.out.println(response.getPhone());
    }
}
