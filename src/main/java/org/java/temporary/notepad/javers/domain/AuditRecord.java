package org.java.temporary.notepad.javers.domain;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(value = "audit_record")
public class AuditRecord {

    @Id
    private Long id;
    private String entityName;
    private String entityId;
    private String changeType;
    private String user;
    private String changeDate;
    private String diff;
}
