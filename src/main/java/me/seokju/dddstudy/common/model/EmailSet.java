package me.seokju.dddstudy.common.model;

import java.util.Set;

public record EmailSet(Set<Email> emails) {
    public EmailSet(Set<Email> emails) {
        this.emails = Set.copyOf(emails);
    }
}
