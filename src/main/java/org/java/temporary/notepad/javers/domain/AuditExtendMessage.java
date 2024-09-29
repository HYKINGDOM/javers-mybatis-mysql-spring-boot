package org.java.temporary.notepad.javers.domain;

import com.mybatisflex.core.audit.AuditMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author kscs
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AuditExtendMessage extends AuditMessage {

    public String sql;
    public String sqlArgs;
    public String rawArgs;
    public String schemaName;
    public String tableName;
    public String fieldName;
    public String primaryKey;
    public String primaryValue;
    public String value ;

    public String query;
    public String row ;
    public String rows;

    public String entity;
    public String entities;
    public String ignoreNulls;


}
