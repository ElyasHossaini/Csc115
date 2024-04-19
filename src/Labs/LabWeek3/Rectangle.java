package Labs.LabWeek3;

public class Rectangle implements Shape {

	private int length; //length units along x axis
	private int height;  //height units along y axis
	private Point position; // position is the (x,y) coordinates of lower left corner of the rectangle

	/*
	 * Purpose: initializes this Rectangle with length and height of 0
	 *   and position to new Point at 0,0
	 * Parameters: none
	 */
	public Rectangle() {
		this.length = 0;
		this.height = 0;
		this.position = new Point();
	}

	/*
	 * Purpose: initializes this Rectangle with given length and height
	 *   and position to new Point at 0,0
	 * Parameters: int length, int height
	 * Precondition: given length and height >=0
	 */
	public Rectangle(int length, int height) {
		this.length = length;
		this.height = height;
		this.position = new Point();
	}

	/*
	 * Purpose: initializes this Rectangle with given length, height and position
	 * Parameters: int length, int height, Point position
	 * Precondition: given length and height >=0, position is not null
	 */
	public Rectangle(int length, int height, Point position) {
		this.length = length;
		this.height = height;
		this.position = position;
	}

	/*
	 * Purpose: prints a message about the characteristics of this Rectangle
	 * Parameters: none
	 * Returns: void
	 */
	public void printCharacteristics() {
		if (length > height) {
			System.out.println("long rectangle");
		} else if (height > length) {
			System.out.println("tall rectangle");
		} else {
			System.out.println("square");
		}
	}

	public String toString() {
		return "Rectangle of dimensions: " + length + " by " + height + " at Point: " + position;
	}

	@Override
	public double area() {
		return height * length;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return (length * 2) + (height * 2);
	}

	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		int ptX = p.getX();
        int ptY = p.getY();

        int positionX = position.getX();
        int positionY = position.getY();

        int xDistance = ptX - positionX;
        int yDistance = ptY - positionY;

        return xDistance >= 0 && xDistance <= length && yDistance >= 0 && yDistance <= height;
		
		
	}

}
