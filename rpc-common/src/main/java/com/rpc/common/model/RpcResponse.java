package com.rpc.common.model;

import lombok.Data;

/**
 * @Author: canhong
 * @Date: 2022/5/9 14:28
 */
@Data
public class RpcResponse {
    private String id;
    private Object data;
    private Exception exception;
}
