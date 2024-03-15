package com.bankproject.bank.entity.Enum;

public enum FixedTermDurationEnum {

    ONE_MONTH(1),
    THREE_MONTH(3),
    SIX_MONTH(6),
    ONE_YEAR(12);

    private final Integer months;

    FixedTermDurationEnum(Integer months) {
        this.months = months;
    }

    public Integer getMonths() {
        return months;
    }


}
