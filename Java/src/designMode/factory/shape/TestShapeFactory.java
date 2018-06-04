package designMode.factory.shape;

public class TestShapeFactory {

	public static void main(String[] args) {

		draw("Square");
	}
	
	public static void draw(String shapeType){
		Shape shape = new ShapeFactory().getShape(shapeType);
		shape.draw();
	}

}
