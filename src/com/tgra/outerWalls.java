package com.tgra;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olafurn on 1.10.2014.
 */
public class outerWalls {


    List<Box> walls;
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
        walls = new ArrayList<Box>();
        eastWall = new Box(new Point3D(20.0f, 0.0f, 0.0f),1f,5f, 39f, new Color3(1f,0f,1f));
        northWall = new Box(new Point3D(0f, 0.0f, -20f),39f, 5f, 1f, new Color3(1f,0f,1f));
        westWall = new Box(new Point3D(-20.0f, 0.0f, 0.0f),1f, 5f, 39f, new Color3(1f,0f,1f));
        southWall = new Box(new Point3D(0f, 0.0f, 20f),39f, 5f, 1f, new Color3(1f,0f,1f));

        walls.add(eastWall);
        walls.add(northWall);
        walls.add(westWall);
        walls.add(southWall);
    }

    public void display()
    {

        for(Box i : walls) {
            Gdx.gl11.glPushMatrix();
            i.draw();
            Gdx.gl11.glPopMatrix();
        }
    }
}
