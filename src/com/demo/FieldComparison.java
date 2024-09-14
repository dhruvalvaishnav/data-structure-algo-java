package com.demo;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

/**
 * @author Dhruval Vaishnav Created on 30-04-2024
 */

class CreditMeasureEntity {
    private String id;
    private String name;
    private Integer value;

    public CreditMeasureEntity(String id, String name, Integer value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

class AuditHistory {
    private String id;
    private String fieldName;
    private String newValue;
    private String oldValue;
    private String entity;
    private Timestamp timeStamp;
    private String user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AuditHistory{" + "id='" + id + '\'' + ", fieldName='" + fieldName + '\'' + ", newValue='" + newValue + '\'' + ", oldValue='" + oldValue + '\'' + ", entity='" + entity + '\'' + ", timeStamp=" + timeStamp + ", user='" + user + '\'' + '}';
    }
}

class AuditHistoryDTO {
    private Map<String, CreditMeasureEntity> existingCreditMeasuresMap;

    public Map<String, CreditMeasureEntity> getExistingCreditMeasuresMap() {
        return existingCreditMeasuresMap;
    }

    public void setExistingCreditMeasuresMap(Map<String, CreditMeasureEntity> existingCreditMeasuresMap) {
        this.existingCreditMeasuresMap = existingCreditMeasuresMap;
    }

    // Other methods and properties (omitted for brevity)
}

class Employee {
    private String ldap;

    public Employee(String ldap) {
        this.ldap = ldap;
    }

    public String getLdap() {
        return ldap;
    }

    // Other methods and properties (omitted for brevity)
}

public class FieldComparison {

    public static void main(String[] args) {
        // Example usage
        CreditMeasureEntity current = new CreditMeasureEntity("1", "Credit Measure 1", null);
        CreditMeasureEntity existing = new CreditMeasureEntity("1", "Credit Measure 1", 350);

        AuditHistoryDTO auditHistoryDTO = new AuditHistoryDTO(); // Assuming it's properly initialized

        Map<String, CreditMeasureEntity> map = new HashMap<>();
        map.put("1", existing);
        auditHistoryDTO.setExistingCreditMeasuresMap(map);

        Employee loggedInUser = new Employee("john.doe"); // Assuming it's properly initialized

        FieldComparison generator = new FieldComparison();
        List<AuditHistory> auditHistories = generator.generateAuditHistories(Collections.singletonList(current), auditHistoryDTO, loggedInUser);

        for (AuditHistory auditHistory : auditHistories) {
            System.out.println(auditHistory);
        }
    }

    public List<AuditHistory> generateAuditHistories(List<CreditMeasureEntity> successCMList, AuditHistoryDTO auditHistoryDTO, Employee loggedInUser) {
        List<AuditHistory> auditHistoriesList = new ArrayList<>();
        String user = loggedInUser != null ? loggedInUser.getLdap() : "";

        try {
            Map<String, CreditMeasureEntity> existingCreditMeasuresMap = auditHistoryDTO.getExistingCreditMeasuresMap();

            for (CreditMeasureEntity cm : successCMList) {
                CreditMeasureEntity existingCm = existingCreditMeasuresMap.get(cm.getId());
                if (existingCm == null) {
                    continue; // Skip comparison if no existing record found
                }

                Field[] cmFields = CreditMeasureEntity.class.getDeclaredFields();
                for (Field field : cmFields) {
                    field.setAccessible(true);

                    Object parameterFieldValue = field.get(cm);
                    Object dbFieldValue = field.get(existingCm);

                    if (!fieldValuesEqual(parameterFieldValue, dbFieldValue)) {
                        AuditHistory auditHistory = createAuditHistory(cm.getId(), field.getName(), parameterFieldValue, dbFieldValue, user);
                        auditHistoriesList.add(auditHistory);
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println("Exception occurred while fetching creditMeasure values: " + ex.getMessage());
        }

        return auditHistoriesList;
    }

    private boolean fieldValuesEqual(Object value1, Object value2) {
        if (value1 == null && value2 == null) {
            return true;
        }
        if (value1 == null || value2 == null) {
            return false;
        }
        return value1.equals(value2);
    }

    private AuditHistory createAuditHistory(String creditMeasureOpgId, String fieldName, Object newValue, Object oldValue, String user) {
        AuditHistory auditHistory = new AuditHistory();
        auditHistory.setId(creditMeasureOpgId);
        auditHistory.setFieldName(fieldName);
        auditHistory.setNewValue(newValue != null ? newValue.toString() : null);
        auditHistory.setOldValue(oldValue != null ? oldValue.toString() : null);
        auditHistory.setEntity("CreditMeasure");
        auditHistory.setTimeStamp(Timestamp.from(Instant.now()));
        auditHistory.setUser(user);
        return auditHistory;
    }
}





