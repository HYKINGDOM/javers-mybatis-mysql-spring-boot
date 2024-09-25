package org.java.temporary.notepad.javers.config;

import com.mybatisflex.core.FlexConsts;
import com.mybatisflex.core.audit.AuditMessage;
import com.mybatisflex.core.audit.MessageFactory;
import com.mybatisflex.core.audit.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kscs
 */
@Slf4j
public class MybatisFlexAuditMessageFactory implements MessageFactory {

    private final String hostIp = HttpUtil.getHostIp();
    @Override
    public AuditMessage create() {
        AuditMessage message = new AuditMessage();

        Map<String, Object> stringObjectMap = new HashMap<>();
        String userName = "admin";
        message.setUser(userName);

        message.setPlatform(FlexConsts.NAME);
        message.setHostIp(hostIp);
        message.setDsName(FlexConsts.SCHEMA_NAME);
        message.setMetas(stringObjectMap);
        message.setUrl(FlexConsts.PRIMARY_VALUE);
        return message;
    }
}
