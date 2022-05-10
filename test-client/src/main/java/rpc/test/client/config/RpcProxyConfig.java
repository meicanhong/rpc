package rpc.test.client.config;

import com.rpc.client.RpcProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: canhong
 * @Date: 2022/5/9 23:25
 */
@Component
public class RpcProxyConfig {
    @Bean
    public RpcProxy rpcProxy() {
        return new RpcProxy("127.0.0.1:8000");
    }
}
