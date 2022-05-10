package rpc.test.server.impl;

import com.rpc.server.RpcService;
import org.springframework.stereotype.Service;
import rpc.test.api.HelloService;

/**
 * @Author: canhong
 * @Date: 2022/5/9 23:50
 */
@Service
@RpcService(value = HelloService.class)
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String value) {
        System.out.println(value);
        return value;
    }
}
