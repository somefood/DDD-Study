package me.seokju.dddstudy.common.jpa;

import jakarta.persistence.AttributeConverter;
import me.seokju.dddstudy.common.model.Email;
import me.seokju.dddstudy.common.model.EmailSet;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class EmailSetConverter implements AttributeConverter<EmailSet, String> {

    @Override
    public String convertToDatabaseColumn(EmailSet attribute) {
        if (attribute == null) return null;
        return attribute.emails().stream()
                .map(Email::address)
                .collect(Collectors.joining(","));
    }

    @Override
    public EmailSet convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        String[] emails = dbData.split(",");
        Set<Email> emailSet = Arrays.stream(emails)
                .map(value -> new Email(value))
                .collect(toSet());
        return new EmailSet(emailSet);
    }
}

