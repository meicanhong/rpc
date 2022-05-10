package com.rpc.common.model;

import lombok.Data;

/**
 * @Author: canhong
 * @Date: 2022/5/9 14:28
 */
@Data
public class RpcRequest {
    private String id;
    private String interfaceName;
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object[] parameters;
    private String serviceVersion;
}
