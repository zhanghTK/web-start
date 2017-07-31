package tk.zhangh.web.start.common;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Transient;

/**
 * Created by ZhangHao on 2017/6/19.
 */
@Data
@Accessors(chain = true)
public class CommonEntity {
    @Transient
    protected Integer page = 1;

    @Transient
    protected Integer rows = 10;
}
