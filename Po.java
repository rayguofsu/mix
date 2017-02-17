public class Po{
	public int x;
	public int y;
	public Po(int x, int y) {
		this.x = x;
		this.y = y;
	}
        @Override
        public int hashCode() {
          return x + y;
    //    return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
    //        // if deriving: appendSuper(super.hashCode()).
    //        append(x).
    //        append(y).
    //        toHashCode();
        }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Po)) return false;
        Po other = (Po) o;
        return (this.x == other.x && this.y == other.y);
    }

//	public boolean isEqual(Point p) {
//		return (p.x == x && p.y == y);
//	}
//	
//	public String toString() {
//		return "(" + x + ", " + y + ")";
//	}
}
