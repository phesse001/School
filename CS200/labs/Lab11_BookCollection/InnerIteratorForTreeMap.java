// This class should be an inner class in your <FOO>TreeMap class.
// The tree variable is an instance variable of the outer class
// of type ZHBinarySearchTree<ZHComparableKeyPair<KeyType, ValueType>>.

/**
 * An iterator that returns the keys of this map in order,
 * using a tree iterator.
 */
protected class MapIterator implements Iterator<KeyType> {
  
  protected Iterator<ZHComparableKeyPair<KeyType, ValueType>> iter;
    
  /**
   * Constructs a new inorder iterator
   * over the keys of this map.
   */
  public MapIterator() {
    iter = innerTree.iterator();
  }
  
  /* (non-Javadoc)
   * @see java.lang.Iterator#hasNext()
   */
  public boolean hasNext() {
    return iter.hasNext();
  }
  
  /* (non-Javadoc)
   * @see java.lang.Iterator#next()
   */
  public KeyType next() {
    return iter.next().getKey();
  }
  
  /**
   * Unsupported operation
   *
   * @throw UnsupportedOperationException
   * @see java.lang.Iterator#remove()
   */
  public void remove() {
    throw new UnsupportedOperationException();
  }
}

