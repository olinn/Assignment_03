package com.tgra;

import java.nio.FloatBuffer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.utils.BufferUtils;

public class Box {

    private static FloatBuffer vertexBuffer;

    public static void loadVertices()
    {
        vertexBuffer = BufferUtils.newFloatBuffer(72);
        vertexBuffer.put(new float[] {-0.5f, -0.5f, -0.5f, -0.5f, 0.5f, -0.5f,
                0.5f, -0.5f, -0.5f, 0.5f, 0.5f, -0.5f,
                0.5f, -0.5f, -0.5f, 0.5f, 0.5f, -0.5f,
                0.5f, -0.5f, 0.5f, 0.5f, 0.5f, 0.5f,
                0.5f, -0.5f, 0.5f, 0.5f, 0.5f, 0.5f,
                -0.5f, -0.5f, 0.5f, -0.5f, 0.5f, 0.5f,
                -0.5f, -0.5f, 0.5f, -0.5f, 0.5f, 0.5f,
                -0.5f, -0.5f, -0.5f, -0.5f, 0.5f, -0.5f,
                -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f,
                0.5f, 0.5f, -0.5f, 0.5f, 0.5f, 0.5f,
                -0.5f, -0.5f, -0.5f, -0.5f, -0.5f, 0.5f,
                0.5f, -0.5f, -0.5f, 0.5f, -0.5f, 0.5f});
        vertexBuffer.rewind();
    }

    private Point3D position;
    private float xSize, ySize, zSize;
    private Color3 color;
    public Point3D a,b, c, d;

    public Box()
    {
    }

    public Box(Point3D position, float xSize,float ySize, float zSize, Color3 color)
    {
        setPosition(position);
        setSize(xSize,ySize,zSize);
        setColor(color);

        a = new Point3D(position.x - xSize/2, position.y , position.z + zSize/2);
        b = new Point3D(position.x + xSize/2, position.y , position.z + zSize/2);
        c = new Point3D(position.x + xSize/2, position.y , position.z - zSize/2);
        d = new Point3D(position.x - xSize/2, position.y , position.z - zSize/2);



    }

    public void setPosition(Point3D position)
    {
        this.position = position;
    }

    public Point3D getPosition(){
            return this.position;
    }

    public void setSize(float xSize, float ySize, float zSize)
    {
        this.xSize = xSize;
        this.ySize = ySize;
        this.zSize = zSize;
    }

    public void setColor(Color3 color)
    {
        this.color = color;
    }

    public void draw()
    {
        Gdx.gl11.glPushMatrix();

        Gdx.gl11.glVertexPointer(3, GL11.GL_FLOAT, 0, vertexBuffer);

        Gdx.gl11.glTranslatef(position.x, position.y, position.z);
        Gdx.gl11.glScalef(xSize, ySize, zSize);

        float[] materialDiffuse = {color.r, color.g, color.b, 1.0f};
        Gdx.gl11.glMaterialfv(GL11.GL_FRONT, GL11.GL_DIFFUSE, materialDiffuse, 0);

        Gdx.gl11.glNormal3f(0.0f, 0.0f, -1.0f);
        Gdx.gl11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 0, 4);
        Gdx.gl11.glNormal3f(1.0f, 0.0f, 0.0f);
        Gdx.gl11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 4, 4);
        Gdx.gl11.glNormal3f(0.0f, 0.0f, 1.0f);
        Gdx.gl11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 8, 4);
        Gdx.gl11.glNormal3f(-1.0f, 0.0f, 0.0f);
        Gdx.gl11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 12, 4);
        Gdx.gl11.glNormal3f(0.0f, 1.0f, 0.0f);
        Gdx.gl11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 16, 4);
        Gdx.gl11.glNormal3f(0.0f, -1.0f, 0.0f);
        Gdx.gl11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 20, 4);

        Gdx.gl11.glPopMatrix();
    }
}
