public enum Months {
    JANUARY((byte)31,Seasons.WINTER),
    FEBRUARY((byte)28,Seasons.WINTER),
    MARCH((byte)31,Seasons.SPRING),
    APRIL((byte)30,Seasons.SPRING),
    MAY((byte)31,Seasons.SPRING),
    JUNE((byte)30,Seasons.SUMMER),
    JULY((byte)31,Seasons.SUMMER),
    AUGUST((byte)31,Seasons.SUMMER),
    SEPTEMBER((byte)30,Seasons.AUTUMN),
    OCTOBER((byte)31,Seasons.AUTUMN),
    NOVEMBER((byte)30,Seasons.AUTUMN),
    DECEMBER((byte)31,Seasons.WINTER);
    private final byte days;
    private final Seasons season;

    Months(byte d, Seasons s) {
        this.days = d;
        this.season = s;
    }

    public byte getDays() {
        return days;
    }

    public Seasons getSeason() {
        return season;
    }
}
