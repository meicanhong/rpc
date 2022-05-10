package rpc.test.server.config;

import com.rpc.server.RpcServer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: canhong
 * @Date: 2022/5/9 23:53
 */
@Component
public class RpcServerConfig {
    @Bean
    public RpcServer rpcServer() {
        return new RpcServer("127.0.0.1:8000");
    }
}
