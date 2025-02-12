import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import java.util.concurrent.TimeUnit;

import gpdraw.*; // for DrawingTool


public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        // TODO: Add a point to the IrregularPolygon.
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        double sum = 0;
        for (int i = 0; i < myPolygon.size() - 1; i++) {
            Point2D.Double point = myPolygon.get(i);
            Point2D.Double secondPoint = myPolygon.get(i + 1);
            sum += point.distance(secondPoint);
        }
        sum += myPolygon.get(myPolygon.size() - 1).distance(myPolygon.get(0));
        return sum;
    }

    public double area() {
        // TODO: Calculate the area.
        double first = 0;
        double second = 0;
        for (int i = 0; i < myPolygon.size() - 1; i++) {
            first += myPolygon.get(i).x * myPolygon.get(i + 1).y;
            second += myPolygon.get(i).y * myPolygon.get(i + 1).x;
        }
        first += myPolygon.get(myPolygon.size() - 1).x * myPolygon.get(0).y;
        second += myPolygon.get(myPolygon.size() - 1).y * myPolygon.get(0).x;
        return Math.abs((first - second) / 2);
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            DrawingTool pen = new DrawingTool(new SketchPad(500, 500));
            pen.move(50, 50);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }
}
