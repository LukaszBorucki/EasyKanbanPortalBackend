package co.borucki.EasyKanbanPortalBackend.user.model;

public enum UserRole {
    SUPERADMIN("SUPERADMIN"), ADMIN("ADMIN"), USER("USER");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
