import java.util.List;

public class PaginationHelper<I> {
    private final List<I> list;

    private final int itemPerPage;

    /**
     * The constructor takes in an array of items and an integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        list = collection;
        this.itemPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return list.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        if (list.isEmpty()) return 0;
        return list.size() % itemPerPage != 0 ? list.size() / itemPerPage + 1 : list.size() / itemPerPage;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (list.isEmpty() || pageIndex < 0) return -1;
        int page = pageCount();
        if (pageIndex + 1 > page) {
            return -1;
        }
        return (int) list.stream().skip((long) pageIndex * itemPerPage).limit(itemPerPage).count();
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (list.isEmpty() || itemIndex < 0 || list.size() - 1 < itemIndex) return -1;
        for (int i = 0; i < pageCount(); i++) {
            int per = (i + 1) * itemPerPage - 1;
            if (per >= itemIndex) return i;
        }
        return -1;
    }
}