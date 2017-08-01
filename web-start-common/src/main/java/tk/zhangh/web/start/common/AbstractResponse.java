package tk.zhangh.web.start.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ZhangHao on 2017/8/1.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractResponse {
    protected String status = "200";
    protected String message = "success";
}
