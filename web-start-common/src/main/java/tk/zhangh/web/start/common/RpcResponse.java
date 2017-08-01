package tk.zhangh.web.start.common;

import lombok.Data;

/**
 * Created by ZhangHao on 2017/8/1.
 */
@Data
public class RpcResponse<T> extends AbstractResponse {

    private T object;

    public RpcResponse(String status, String message, T object) {
        super(status, message);
        this.object = object;
    }

    public RpcResponse(String status, String message) {
        super(status, message);
    }

    public RpcResponse(T object) {
        super();
        this.object = object;
    }
}
