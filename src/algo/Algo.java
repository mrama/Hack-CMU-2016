package src.algo;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Size;
import org.opencv.core.Point;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.MatOfPoint2f;
import org.opencv.calib3d.Calib3d;
import org.opencv.core.Scalar;

/** @class Algo
 *  @author Pavel Khokhlov <pkhokhlo@andrew.cmu.edu>
 *  @author Ariel Davis <azdavis@andrew.cmu.edu>
 *  @thanks https://github.com/spmallick/learnopencv/tree/master/Homography
 */
public class Algo
{
    public static void algo(double[][] wallCoords)
    {
        // Load OpenCV
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Poster image
        Mat posterImg = Highgui.imread("src/img/poster/02.jpg");
        Size posterSize = posterImg.size();

        // Border of the poster, used for the point correspondence
        // top left, top right, bottom left, bottom right
        MatOfPoint2f posterPoints = new MatOfPoint2f(
            new Point(0, 0),
            new Point(posterSize.width - 1, 0),
            new Point(0, posterSize.height - 1 ),
            new Point(posterSize.width - 1, posterSize.height -1)
        );

        // Destination image
        Mat wallImg = Highgui.imread("src/img/wall.jpg");

        // Points on the wall where we map the poster
        // top left, top right, bottom left, bottom right
        MatOfPoint2f wallPoints = new MatOfPoint2f(
            new Point(wallCoords[0][0], wallCoords[0][1]),
            new Point(wallCoords[1][0], wallCoords[1][1]),
            new Point(wallCoords[2][0], wallCoords[2][1]),
            new Point(wallCoords[3][0], wallCoords[3][1])
        );

        // Clone the wall
        Mat tmpImg = wallImg.clone();
        // Calculate homography between source and destination points
        Mat homog = Calib3d.findHomography(posterPoints, wallPoints);
        // Warp poster using the homography
        Imgproc.warpPerspective(posterImg, tmpImg, homog, wallImg.size());
        // Add the warped picture to the wall
        Core.add(wallImg, tmpImg, wallImg);
        // Writes resulting image
        Highgui.imwrite("src/img/result.jpg", wallImg, new MatOfInt(95));
    }
}
