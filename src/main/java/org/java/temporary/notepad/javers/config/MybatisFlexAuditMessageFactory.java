package org.java.temporary.notepad.javers.config;

import com.mybatisflex.core.FlexConsts;
import com.mybatisflex.core.audit.AuditMessage;
import com.mybatisflex.core.audit.MessageFactory;
import com.mybatisflex.core.audit.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.java.temporary.notepad.javers.domain.AuditExtendMessage;

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
        AuditExtendMessage message = new AuditExtendMessage();

        Map<String, Object> stringObjectMap = new HashMap<>();
        String userName = "admin";
        message.setUser(userName);
        message.setPlatform(FlexConsts.NAME);
        message.setHostIp(hostIp);
        message.setDsName(FlexConsts.SCHEMA_NAME);
        message.setMetas(stringObjectMap);
        message.setEntity(FlexConsts.ENTITY);
        message.setPrimaryKey(FlexConsts.PRIMARY_KEY);
        message.setPrimaryValue(FlexConsts.PRIMARY_VALUE);
        message.setQuery(FlexConsts.QUERY);
        message.setSql(FlexConsts.SQL);
        message.setTableName(FlexConsts.TABLE_NAME);
        return message;
    }
}
