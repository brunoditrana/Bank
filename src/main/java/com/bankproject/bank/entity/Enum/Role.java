package com.bankproject.bank.entity.Enum;

import java.util.Arrays;
import java.util.List;

public enum Role {

    ADMINISTRATOR(Arrays.asList(
            RolePermissionEnum.CREATE_PROFILE,
            RolePermissionEnum.CREATE_BRANCH,
            RolePermissionEnum.CREATE_ACCOUNT,
            RolePermissionEnum.CREATE_SERVICE,

            RolePermissionEnum.READ_ALL_PROFILES,
      
            RolePermissionEnum.READ_ONE_PROFILE,
            RolePermissionEnum.READ_ALL_BRANCHES,
            RolePermissionEnum.READ_ONE_BRANCH,
            RolePermissionEnum.READ_ALL_ACCOUNTS,
            RolePermissionEnum.READ_ONE_ACCOUNT,
            RolePermissionEnum.READ_ALL_SERVICES,
            RolePermissionEnum.READ_ONE_SERVICE,

            RolePermissionEnum.UPDATE_PROFILE,
            RolePermissionEnum.UPDATE_BRANCH,
            RolePermissionEnum.UPDATE_ACCOUNT,
            RolePermissionEnum.UPDATE_SERVICE,

            RolePermissionEnum.DELETE_PROFILE,
            RolePermissionEnum.DELETE_BRANCH,
            RolePermissionEnum.DELETE_ACCOUNT,
            RolePermissionEnum.DELETE_SERVICE
    )),
    ASSISTANT_ADMINISTRATOR(Arrays.asList(
            RolePermissionEnum.READ_ALL_PROFILES,
            RolePermissionEnum.READ_ONE_PROFILE,
            RolePermissionEnum.READ_ALL_BRANCHES,
            RolePermissionEnum.READ_ONE_BRANCH,
            RolePermissionEnum.READ_ALL_ACCOUNTS,
            RolePermissionEnum.READ_ONE_ACCOUNT,
            RolePermissionEnum.READ_ALL_SERVICES,
            RolePermissionEnum.READ_ONE_SERVICE,

            RolePermissionEnum.UPDATE_PROFILE,
            RolePermissionEnum.UPDATE_BRANCH,
            RolePermissionEnum.UPDATE_ACCOUNT,
            RolePermissionEnum.UPDATE_SERVICE
    )),
    CUSTOMER(Arrays.asList(
            RolePermissionEnum.CREATE_PROFILE,

            RolePermissionEnum.READ_ALL_PROFILES,
            RolePermissionEnum.READ_ONE_PROFILE,
            RolePermissionEnum.READ_ALL_BRANCHES,
            RolePermissionEnum.READ_ONE_BRANCH,
            RolePermissionEnum.READ_ALL_ACCOUNTS,
            RolePermissionEnum.READ_ONE_ACCOUNT,
            RolePermissionEnum.READ_ALL_SERVICES,
            RolePermissionEnum.READ_ONE_SERVICE,

            RolePermissionEnum.UPDATE_PROFILE,
            RolePermissionEnum.UPDATE_ACCOUNT
    ));

    private final List<RolePermissionEnum> permissions;

    Role(List<RolePermissionEnum> permissions) {
        this.permissions = permissions;
    }

    public List<RolePermissionEnum> getPermissions() {
        return permissions;
    }
}
