package nl.fhict.sketchboard.layers;

import android.graphics.Paint;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by ruudschroen on 14-01-16.
 */
public class DrawingPoint implements Serializable {

    private float x;
    private float y;

    private Paint paint;

    public DrawingPoint(float x, float y, Paint paint){
        this.x = x;
        this.y = y;
        this.paint = paint;
    }

    public Paint getPaint(){
        return paint;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(x);
        out.writeObject(y);

        out.writeObject(paint.getAlpha());
        out.writeObject(paint.getColor());
        out.writeObject(paint.getTextSize());
        out.writeObject(paint.getStrokeWidth());
        out.writeObject(paint.getStrokeCap());
        out.writeObject(paint.isAntiAlias());
        // Missing shit
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        this.x = (float) in.readObject();
        this.y = (float) in.readObject();

        int alpha = (int) in.readObject();
        int color = (int) in.readObject();
        float size = (float) in.readObject();
        float width = (float) in.readObject();
        Paint.Cap cap = (Paint.Cap) in.readObject();
        boolean aa = (boolean) in.readObject();

        this.paint = new Paint();
        this.paint.setAlpha(alpha);
        this.paint.setColor(color);
        this.paint.setTextSize(size);
        this.paint.setStrokeWidth(width);
        this.paint.setStrokeCap(cap);
        this.paint.setAntiAlias(aa);
        // Missing shit
    }

}
