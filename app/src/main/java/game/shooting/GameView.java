package game.shooting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.study.graphic0714.R;

/**
 * Created by Administrator on 2015-07-14.
 */
public class GameView extends View{
    Bitmap ship;
    private int posX;
    private int posY;
    Paint paint;
    //조이스틱 총알버튼의 크기
    RectF[] control=new RectF[5];
    int controlWidth=150;
    int controlHeight=150;
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wowwow);
        ship=Bitmap.createScaledBitmap(bitmap, 500, 500, false);
        paint=new Paint();
        paint.setColor(Color.BLUE);

        control[0]=new RectF(100,200,100+controlWidth,200+controlHeight);//up
        control[1]=new RectF(100,200,100+controlWidth,200+controlHeight);//down
        control[2]=new RectF(100,200,100+controlWidth,200+controlHeight);//left
        control[3]=new RectF(100,200,100+controlWidth,200+controlHeight);//right
        control[4]=new RectF(100,200,100+controlWidth,200+controlHeight);//fire
    }

    //조이스틱 그리기
    public void paintJoyStick(Canvas canvas){
        //up
       // for(int i=0;i<control.length;i++) {
            canvas.drawRect(control[0], paint);
        //}

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(ship, posX, posY, null);
        paintJoyStick(canvas);
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
}
