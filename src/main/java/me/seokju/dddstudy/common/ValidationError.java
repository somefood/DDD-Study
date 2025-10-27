package me.seokju.dddstudy.common;

public record ValidationError(
        String name,
        String code
) {
    public boolean hasName() {
        return name != null;
    }

    public static ValidationError of(String code) {
        return new ValidationError(null, code);
    }

    public static ValidationError of(String name, String code) {
        return new ValidationError(name, code);
    }
}
