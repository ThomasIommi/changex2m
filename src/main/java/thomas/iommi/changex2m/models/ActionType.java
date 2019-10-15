package thomas.iommi.changex2m.models;

public enum ActionType {
    ADD,
    CHANGE,
    REMOVE,
    FIX;

    public static ActionType fromString(String type) {
        switch (type.toLowerCase()) {
            case "add":
            case "feat":
                return ADD;
            case "remove":
                return REMOVE;
            case "fix":
                return FIX;
            case "update":
            default:
                return CHANGE;
        }
    }
}
