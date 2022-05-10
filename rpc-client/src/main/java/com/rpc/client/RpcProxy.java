package com.rpc.client;

import com.rpc.common.model.RpcRequest;
import com.rpc.common.model.RpcResponse;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;
import java.util.UUID;

/**
 * @Author: canhong
 * @Date: 2022/5/9 17:10
 */
public class RpcProxy {
    private String serviceAddress;

    public RpcProxy(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public  <T> T create(final Class<?> interfaceClass) {
        return create(interfaceClass, "");
    }

    public  <T> T create(final Class<?> interfaceClass, final String serviceVersion) {
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        RpcRequest request = new RpcRequest();
                        request.setId(UUID.randomUUID().toString());
                        request.setInterfaceName(method.getDeclaringClass().getName());
                        request.setServiceVersion(serviceVersion);
                        request.setMethodName(method.getName());
                        request.setParameterTypes(method.getParameterTypes());
                        request.setParameters(args);
                        // todo 服务发现
                        if (StringUtils.isEmpty(serviceAddress)) {
                            throw new RuntimeException("server address is empty");
                        }
                        String[] array = StringUtils.split(serviceAddress, ":");
                        String host = array[0];
                        int port = Integer.parseInt(array[1]);
                        RpcClient client = new RpcClient(host, port);
                        RpcResponse response = client.send(request);
                        if (Objects.isNull(response)) {
                            throw new RuntimeException("rpc response is null");
                        }
                        if (Objects.nonNull(response.getException())) {
                            throw response.getException();
                        }
                        return response.getData();
                    }
                }
        );
    }
}
