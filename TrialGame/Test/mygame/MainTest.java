/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.collision.CollisionResults;
import com.jme3.input.FlyByCamera;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import com.jme3.system.JmeContext;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author lanbo
 */
public class MainTest {
        public static Main app;//Our test target application or class.

    public MainTest() {
    }
   
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
 
    /**
     * Test of main method, of class Main.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        Main.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
    /**
     * Test of simpleInitApp method, of class Main.
     */
//    @Test
//    public void testSimpleInitApp() {
//        System.out.println("simpleInitApp");
//        Main instance = new Main();
//        instance.simpleInitApp();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of setPhysicsCylinder method, of class Main.
     */
//    @Test
//    public void testSetPhysicsCylinder() {
//        System.out.println("setPhysicsCylinder");
//        float x = 0.0F;
//        float y = 0.0F;
//        float z = 0.0F;
//        Main instance = new Main();
//        Node expResult = null;
//        Node result = instance.setPhysicsCylinder(x, y, z);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of setPlane method, of class Main.
     */
//    @Test
//    public void testSetPlane() {
//        System.out.println("setPlane");
//        Main instance = new Main();
//        instance.setPlane();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of set3dFloor method, of class Main.
     */
//    @Test
//    public void testSet3dFloor() {
//        System.out.println("set3dFloor");
//        Main instance = new Main();
//        instance.set3dFloor();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

   
    
   
    /**
     * Test of createPhysicsTestNode method, of class Main.
     */
//    @Test
//    public void testCreatePhysicsTestNode() {
//        System.out.println("createPhysicsTestNode");
//        AssetManager manager = null;
//        CollisionShape shape = null;
//        float mass = 0.0F;
//        Node expResult = null;
//        Node result = Main.createPhysicsTestNode(manager, shape, mass);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
   @Test
    public void testCamera() {
//        Vector3f camDir = app.getCamera().getDirection();
//        Assert.assertEquals(camDir, new Vector3f(0, 0, -1.0f));
            FlyByCamera flyBy = app.getFlyByCamera();
           // assertTrue(flyBy.getMoveSpeed() == 10);
    }
    
}
