public class ItemID {
    private int id;

    public ItemID(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj) return true;
    //     if (obj == null || getClass() != obj.getClass()) return false;
    //     ItemID itemID = (ItemID) obj;
    //     return id == itemID.id;
    // }
}