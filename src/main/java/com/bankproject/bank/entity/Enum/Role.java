package com.bankproject.bank.entity.Enum;

import java.util.Arrays;
import java.util.List;

public enum Role {

    ROLE_ADMINISTRATOR(Arrays.asList(
            RolePermission.CREATE_PROFILE,
            RolePermission.CREATE_BRANCH,
            RolePermission.CREATE_ACCOUNT,
            RolePermission.CREATE_SERVICE,

            RolePermission.READ_ALL_PROFILES,
            RolePermission.READ_ONE_PROFILE,
            RolePermission.READ_ALL_BRANCHES,
            RolePermission.READ_ONE_BRANCH,
            RolePermission.READ_ALL_ACCOUNTS,
            RolePermission.READ_ONE_ACCOUNT,
            RolePermission.READ_ALL_SERVICES,
            RolePermission.READ_ONE_SERVICE,

            RolePermission.UPDATE_PROFILE,
            RolePermission.UPDATE_BRANCH,
            RolePermission.UPDATE_ACCOUNT,
            RolePermission.UPDATE_SERVICE,

            RolePermission.DELETE_PROFILE,
            RolePermission.DELETE_BRANCH,
            RolePermission.DELETE_ACCOUNT,
            RolePermission.DELETE_SERVICE
    )),
    ROLE_ASSISTANT_ADMINISTRATOR(Arrays.asList(
            RolePermission.READ_ALL_PROFILES,
            RolePermission.READ_ONE_PROFILE,
            RolePermission.READ_ALL_BRANCHES,
            RolePermission.READ_ONE_BRANCH,
            RolePermission.READ_ALL_ACCOUNTS,
            RolePermission.READ_ONE_ACCOUNT,
            RolePermission.READ_ALL_SERVICES,
            RolePermission.READ_ONE_SERVICE,

            RolePermission.UPDATE_PROFILE,
            RolePermission.UPDATE_BRANCH,
            RolePermission.UPDATE_ACCOUNT,
            RolePermission.UPDATE_SERVICE
    )),
    ROLE_CUSTOMER(Arrays.asList(
            RolePermission.CREATE_PROFILE,

            RolePermission.READ_ALL_PROFILES,
            RolePermission.READ_ONE_PROFILE,
            RolePermission.READ_ALL_BRANCHES,
            RolePermission.READ_ONE_BRANCH,
            RolePermission.READ_ALL_ACCOUNTS,
            RolePermission.READ_ONE_ACCOUNT,
            RolePermission.READ_ALL_SERVICES,
            RolePermission.READ_ONE_SERVICE,

            RolePermission.UPDATE_PROFILE,
            RolePermission.UPDATE_ACCOUNT
    ));

    private final List<RolePermission> permissions;

    Role(List<RolePermission> permissions) {
        this.permissions = permissions;
    }

    public List<RolePermission> getPermissions() {
        return permissions;
    }
}
