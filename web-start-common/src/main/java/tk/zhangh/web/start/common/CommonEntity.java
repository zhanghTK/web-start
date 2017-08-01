package tk.zhangh.web.start.common;

import com.alibaba.fastjson.JSON;
import jodd.vtor.Violation;
import jodd.vtor.Vtor;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/6/19.
 */
@Data
public class CommonEntity {
    @Transient
    protected Integer page = 1;

    @Transient
    protected Integer rows = 10;

    private static Vtor vtor() {
        return new Vtor();
    }

    public void validate(String... profiles) {
        Vtor vtor = vtor();
        vtor.useProfiles(profiles);
        vtor.validate(this);
        if (vtor.hasViolations()) {
            List<Validation> validations = new ArrayList<>();
            for (Violation violation : vtor.getViolations()) {
                String msg = violation.getCheck().getMessage();
                validations.add(new Validation(msg, violation.getName()));
            }
            throw new EntityValidateException(JSON.toJSONString(validations));
        }
    }

    @Data
    @AllArgsConstructor
    private static class Validation {
        private String msg;
        private String name;
    }
}
