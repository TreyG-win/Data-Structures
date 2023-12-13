public class Student {
    private String name;
    private int credits;
    private long id;
    private String major;
    private boolean transfer;

    public Student(String name, int credits, long id, String major, boolean transfer) {
        this.name=name;
        this.credits=credits;
        this.id=id;
        this.major=major;
        this.transfer=transfer;
    }

    public String toString() {
        if (transfer)
            return name+" ["+id+"] (Transfer) "+credits+" credits major:"+major;
        else
        return name+" ["+id+"] "+credits+" credits major:"+major;
    }

}
