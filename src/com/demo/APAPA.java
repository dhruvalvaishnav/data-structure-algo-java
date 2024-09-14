package com.demo;

/**
 * @author Dhruval Vaishnav Created on 19-04-2024
 */

import java.util.*;
import java.util.stream.Collectors;

public class APAPA {
    public static void main(String[] args) {
        // Dummy data for columnPermissionList
        List<ColumnPermission> columnPermissionList = Arrays.asList(new ColumnPermission("Entity1", "Column1"),
                new ColumnPermission("Entity1", "Column2"), new ColumnPermission("Entity1", "Column3"),
                new ColumnPermission("Entity2", "Column1"));

        // Dummy data for compAdjustmentEditableColumns
        List<CompAdjustmentEditableColumns> compAdjustmentEditableColumns = Arrays.asList(new CompAdjustmentEditableColumns("Entity1", "Column1"),
                new CompAdjustmentEditableColumns("Entity1", "Column2"),
                new CompAdjustmentEditableColumns("Entity1", "Column3"),
                new CompAdjustmentEditableColumns("Entity2", "Column1"),
                new CompAdjustmentEditableColumns("Entity2", "Column2"),
                new CompAdjustmentEditableColumns("Entity3", "Column1"));

        // Obtain result using the provided method
        List<CompAdjustmentEditableColumns> result = compareColumnPermissionToEditableColumns(columnPermissionList, compAdjustmentEditableColumns);
        //System.out.println("Result:" + result);

        for (CompAdjustmentEditableColumns editableColumns : result) {
            System.out.println("Entity: " + editableColumns.getEntity() + ", Column: " + editableColumns.getColumn());
        }
    }

    private static List<CompAdjustmentEditableColumns> compareColumnPermissionToEditableColumns(List<ColumnPermission> columnPermissionList, List<CompAdjustmentEditableColumns> compAdjustmentEditableColumns) {
        if (columnPermissionList == null || compAdjustmentEditableColumns == null) {
            throw new IllegalArgumentException("Input lists cannot be null");
        }

        // Group allowed columns by entity
        Map<String, Set<String>> permissionMap = columnPermissionList.stream().filter(Objects::nonNull).filter(ColumnPermission::isUpdate).collect(Collectors.groupingBy(ColumnPermission::getEntity, Collectors.mapping(ColumnPermission::getColumn, Collectors.toSet())));

        // Filter compAdjustmentEditableColumns based on permissions
        return compAdjustmentEditableColumns.stream().filter(editableColumns -> permissionMap.containsKey(editableColumns.getEntity()) && permissionMap.get(editableColumns.getEntity()).contains(editableColumns.getColumn())).collect(Collectors.toList());
    }
}


class ColumnPermission {
    private String entity;
    private String column;

    public ColumnPermission(String entity, String column) {
        this.entity = entity;
        this.column = column;
    }

    public String getEntity() {
        return entity;
    }

    public String getColumn() {
        return column;
    }

    public boolean isUpdate() {
        // Implement your logic to determine if it's an update permission
        return true;
    }

    @Override
    public String toString() {
        return "ColumnPermission{" + "entity='" + entity + '\'' + ", column='" + column + '\'' + '}';
    }
}

class CompAdjustmentEditableColumns {
    private String entity;
    private String column;

    public CompAdjustmentEditableColumns(String entity, String column) {
        this.entity = entity;
        this.column = column;
    }

    public String getEntity() {
        return entity;
    }

    public String getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "CompAdjustmentEditableColumns{" + "entity='" + entity + '\'' + ", column='" + column + '\'' + '}';
    }
}
