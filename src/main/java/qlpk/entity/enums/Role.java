package qlpk.entity.enums;

public enum Role {

    BACSY("bac sy",1), YTA("y ta",2), NHANVIEN("nhan vien", 3);
    private final String type;
    private final Integer value;
    Role(String type, int value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public Integer getValue() {
        return value;
    }
}
