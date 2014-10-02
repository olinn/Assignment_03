package com.tgra;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

/**
 * Created by olafurn on 1.10.2014.
 */
public class outerWalls {

    Box eastWall;
    Box westWall;
    Box northWall;
    Box southWall;

    Vector3D eastVector;
    Vector3D westVector;
    Vector3D northVector;
    Vector3D southVector;

    public void create()
    {
        eastWall = new Box(new Point3D(0.0f, 0.0f, 0.0f),1f, new Color3(1f,0f,1f));
        westWall = new Box(new Point3D(0.0f, 0.0f, 0.0f),1f, new Color3(1f,0f,1f));
        northWall = new Box(new Point3D(0f, 0.0f, 0f),1f, new Color3(1f,0f,1f));
        southWall = new Box(new Point3D(0f, 0.0f, 0f),1f, new Color3(1f,0f,1f));

        eastVector = new Vector3D(20,0,0);
        westVector = new Vector3D(-20,0,20);
        northVector = new Vector3D(0,0,20);
        southVector = new Vector3D(20,0,-20);
    }

    public void display()
    {
        Gdx.gl11.glPushMatrix();
        Gdx.gl11.glTranslatef(10f,0f,0f);
        Gdx.gl11.glScalef(0.1f,2f,20f);
        eastWall.draw();
        Gdx.gl11.glPopMatrix();

        Gdx.gl11.glPushMatrix();
        Gdx.gl11.glTranslatef(-10f,0f,0f);
        Gdx.gl11.glScalef(0.1f,2f,20f);
        westWall.draw();
        Gdx.gl11.glPopMatrix();

        Gdx.gl11.glPushMatrix();
        Gdx.gl11.glTranslatef(0f,0f,10f);
        Gdx.gl11.glScalef(20f,2f,0.1f);
        northWall.draw();
        Gdx.gl11.glPopMatrix();

        Gdx.gl11.glPushMatrix();
        Gdx.gl11.glTranslatef(0f,0f,-10f);
        Gdx.gl11.glScalef(20f,2f,0.1f);
        southWall.draw();
        Gdx.gl11.glPopMatrix();
    }
}
