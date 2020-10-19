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
    int pages = this.itemCount() / this.itemsPerPage;
    
    if (this.lastPageItemCount() > 0 && this.lastPageItemCount() < this.itemsPerPage)
      pages++;
    
    return pages;
  }
  
  /**
   * returns the number of items on the current page. page_index is zero based.
   * this method should return -1 for pageIndex values that are out of range
   */
  public int pageItemCount(int pageIndex) {
    final int pages = this.pageCount();
    
    if ((pageIndex >= 0 && pageIndex < pages - 1) || this.lastPageItemCount() == 0 && pageIndex == pages - 1)
      return this.itemsPerPage;
    
    if (pageIndex == pages - 1) 
      return this.lastPageItemCount();
    
    return -1;
  }
  
  /**
   * determines what page an item is on. Zero based indexes
   * this method should return -1 for itemIndex values that are out of range
   */
  public int pageIndex(int itemIndex) {
    if(itemIndex >= 0 && itemIndex < this.collection.size())
      return itemIndex/this.itemsPerPage;
    return -1;
  }
  /*
  ** Returns # of items on the last page
  */
  private int lastPageItemCount() {
    int remainder =  this.itemCount() % this.itemsPerPage;
    return remainder == 0 ? this.itemsPerPage : remainder;
  }
}