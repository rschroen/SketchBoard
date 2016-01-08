package nl.fhict.sketchboard.layers;

import android.graphics.Canvas;

/**
 * Created by ruudschroen on 07-01-16.
 */
public interface Layerable {

    String getName();

    void draw(Canvas canvas);



}
