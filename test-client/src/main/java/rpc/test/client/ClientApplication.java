package rpc.test.client;

import com.rpc.client.RpcProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import rpc.test.api.HelloService;

/**
 * @Author: canhong
 * @Date: 2022/5/9 23:20
 */
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ClientApplication.class);
        RpcProxy rpcProxy = context.getBean(RpcProxy.class);
        HelloService helloService = rpcProxy.create(HelloService.class);
        String nihao = helloService.hello("nihao");
        System.out.println(nihao);
    }
}
