package com.demo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

/**
 * @author Dhruval Vaishnav Created on 02-07-2024
 */
public class AuditHistoryDemo {

    public static void main(String[] args) {
        // Sample entities (replace with actual entities used in your application)
        List<CM> requestList = Arrays.asList(new CM(1, "Field1", "OldValue1"), new CM(2, "Field2", "OldValue2"), new CM(3, "Field3", ""), new CM(4, "Field4", null), new CM(5, "Field5", "0"));

        Map<String, CM> dbMap = new HashMap<>();
        dbMap.put("1", new CM(1, "Field1", "OldValue1"));
        dbMap.put("2", new CM(2, "Field2", "OldValue2"));
        dbMap.put("3", new CM(3, "Field3", ""));
        dbMap.put("4", new CM(4, "Field4", ""));
        dbMap.put("5", new CM(5, "Field5", "0"));

        String user = "testUser";

        // Call the method to generate audit history
        AuditHistoryHelper<CM> helper = new AuditHistoryHelper<CM>();
        List<AuditHistory> auditHistoryList = helper.generateAuditHistory(requestList, dbMap, user);

        System.out.println("auditHistoryList :: " + auditHistoryList);

    }


}

// Sample entity class (replace with your actual entity class)
@Setter
@Getter
class CM {
    private long creditMeasureOpgId;
    private String fieldName;
    private String value;

    public CM(long creditMeasureOpgId, String fieldName, String value) {
        this.creditMeasureOpgId = creditMeasureOpgId;
        this.fieldName = fieldName;
        this.value = value;
    }

    @Override
    public String toString() {
        return "CM{" + "creditMeasureOpgId=" + creditMeasureOpgId + ", fieldName='" + fieldName + '\'' + ", value='" + value + '\'' + '}';
    }
}

class AuditHistoryHelper<T> {

    public List<AuditHistory> generateAuditHistory(List<T> requestList, Map<String, T> dbMap, String user) {
        List<AuditHistory> auditHistoryList = new ArrayList<>();
        try {
            Class<?> clazz = requestList.isEmpty() ? null : requestList.get(0).getClass();
            if (clazz == null) {
                throw new IllegalArgumentException("List requestList cannot be empty.");
            }

            for (T entity : requestList) {
                Serializable id = getIdFromEntity(entity);
                if (dbMap.containsKey(id.toString())) {
                    T dbEntity = dbMap.get(id.toString());

                    Field[] fields = clazz.getDeclaredFields();
                    for (Field field : fields) {
                        field.setAccessible(true);
                        Object parameterValue = field.get(entity);
                        Object dbValue = field.get(dbEntity);

                        if (!isEqual(parameterValue, dbValue)) {
                            AuditHistory auditHistory = createAuditHistory(entity, dbEntity, field, user);
                            auditHistoryList.add(auditHistory);
                        }
                    }
                }
            }
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Generated {} audit history entries : " + auditHistoryList.size());
        return auditHistoryList;
    }

    private Serializable getIdFromEntity(T entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null");
        }

        if (entity instanceof CM) {
            long id = ((CM) entity).getCreditMeasureOpgId();
            if (id != 0) {
                return id;
            } else {
                throw new IllegalArgumentException("OpportunityLineItemEntity ID is null or empty");
            }
        }

        throw new IllegalArgumentException("Unsupported entity type: " + entity.getClass().getName());
    }

    private boolean isEqual(Object value1, Object value2) {
        if (value1 == null && value2 == null) {
            return true;
        }
        if (value1 == null || value2 == null) {
            return false;
        }
        return value1.toString().equalsIgnoreCase(value2.toString());
    }

    private AuditHistory createAuditHistory(T entity, T dbEntity, Field field, String user) throws IllegalAccessException {
        AuditHistory auditHistory = new AuditHistory();
        field.setAccessible(true);
        Object parameterValue = field.get(entity);
        Object dbValue = (dbEntity != null) ? field.get(dbEntity) : null;

        auditHistory.setId(getIdFromEntity(entity).toString());
        auditHistory.setFieldName(field.getName());
        auditHistory.setEntity(entity.getClass().getSimpleName());
        auditHistory.setTimeStamp(Timestamp.from(Instant.now()));
        auditHistory.setUser(user);

        if (parameterValue != null) {
            auditHistory.setNewValue(parameterValue.toString());
        }
        if (dbValue != null) {
            auditHistory.setOldValue(dbValue.toString());
        }

        return auditHistory;
    }


}

