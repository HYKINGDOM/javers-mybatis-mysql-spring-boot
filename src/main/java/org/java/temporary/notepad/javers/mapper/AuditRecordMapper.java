package org.java.temporary.notepad.javers.mapper;

import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.java.temporary.notepad.javers.domain.AuditRecord;

/**
 * @author kscs
 */
@Mapper
public interface AuditRecordMapper extends BaseMapper<AuditRecord> {}
