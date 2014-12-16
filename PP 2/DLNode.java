public class DLNode<T> {
  private T element;
  private DLNode<T> next;
  private DLNode<T> previous;
  
  public DLNode(T element, DLNode<T> previous, DLNode<T> next) {
     /* You need to write the correct code here to create a correctly formed double linked list */
    this.element = element;
    this.previous = previous;
    this.next = next;
    previous.setNext(this.next);
    next.setPrevious(this.previous);
  }

  public T getElement() {
    return element;
  }

  public DLNode<T> getNext() {
    return next;
  }

  public void setNext(DLNode<T> next) {
    this.next = next;
  }

  public DLNode<T> getPrevious() {
    return previous;
  }

  public void setPrevious(DLNode<T> previous) {
    this.previous = previous;
  }
}