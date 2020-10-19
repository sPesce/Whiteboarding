import java.util.List;

// TODO: complete this object/class

public class PaginationHelper<I> {
  List<I> collection;
  int itemsPerPage;
  /**
   * The constructor takes in an array of items and a integer indicating how many
   * items fit within a single page
   */
  public PaginationHelper(List<I> collection, int itemsPerPage) {
    this.collection = collection;
    this.itemsPerPage = itemsPerPage;
  }
  
  /**
   * returns the number of items within the entire collection
   */
  public int itemCount() {
    return this.collection.size();
  }
  
  /**
   * returns the number of pages
   */
  public int pageCount() {
    final int items = this.itemCount();
    final int partialPage = this.lastPageCount() == 0 ? 0 : 1;
    return ((items / this.itemsPerPage) + partialPage);
  }
  
  /**
   * returns the number of items on the current page. page_index is zero based.
   * this method should return -1 for pageIndex values that are out of range
   */
  public int pageItemCount(int pageIndex) {
    final int pages = this.pageCount();
    if (pageIndex < pages - 1 && pageIndex >= 0)
      return this.itemsPerPage;
    if (pageIndex == pages - 1)    
      return this.lastPageCount();
    return -1;
  }
  
  /**
   * determines what page an item is on. Zero based indexes
   * this method should return -1 for itemIndex values that are out of range
   */
  public int pageIndex(int itemIndex) {
    final int pageNum = itemIndex/this.itemsPerPage;
    return (pageNum < this.pageCount() && pageNum >= 0) ? pageNum : -1;
  }

  private int lastPageCount() {
    return this.itemCount() % this.itemsPerPage;
  }
}