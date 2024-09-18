package com.example.bottom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CircleView extends View {

    private Paint paint;
    private int level = 0; // 기본 레벨을 0으로 설정
    private int radiusBase = 100; // 가장 작은 원의 반지름을 100px로 설정

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    // 레벨에 따라 원의 크기와 색상을 그리는 메서드
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        // 중심 좌표
        int cx = width / 2;
        int cy = height / 2;

        int radius1 = radiusBase + 300 * level / 1000;
        int radius2 = radiusBase + 200 * level / 1000;
        int radius3 = radiusBase + 100 * level / 1000;

        // 레벨에 따라 원을 여러 개 그리는 방식
        if (level > 666) {
            // 연한 파란색 원 그리기
            drawCircle(canvas, cx, cy, radius1, "#4284C6");
        }
        if (level > 333) {
            // 파란색 원 그리기
            drawCircle(canvas, cx, cy, radius2, "#23648B");
        }
        // 항상 진한 파란색 원 그리기
        drawCircle(canvas, cx, cy, radius3, "#205273");
    }

    // 원을 그리는 헬퍼 메서드
    private void drawCircle(Canvas canvas, int cx, int cy, int radius, String color) {
        paint.setColor(Color.parseColor(color));
        canvas.drawCircle(cx, cy, radius, paint);
    }

    // 외부에서 레벨을 설정할 수 있도록 메서드를 추가
    public void setLevel(int level) {
        this.level = level;
        invalidate(); // View를 다시 그리도록 함
    }
}