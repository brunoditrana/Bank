package com.bankproject.bank.entity.Enum;

public enum FixedTermDuration {

    ONE_MONTH(1),
    THREE_MONTH(3),
    SIX_MONTH(6),
    ONE_YEAR(12);

    private final Integer months;

    FixedTermDuration(Integer months) {
        this.months = months;
    }

    public Integer getMonths() {
        return months;
    }


}
