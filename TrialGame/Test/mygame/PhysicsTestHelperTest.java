/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.Application;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

/**
 *
 * @author lanbo
 */
public class PhysicsTestHelperTest {
    
    public PhysicsTestHelperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of createPhysicsTestWorld method, of class PhysicsTestHelper.
     */
    @Test
    public void testCreatePhysicsTestWorld() {
        System.out.println("createPhysicsTestWorld");
        Node rootNode = null;
        AssetManager assetManager = null;
        PhysicsSpace space = null;
        PhysicsTestHelper.createPhysicsTestWorld(rootNode, assetManager, space);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPhysicsTestWorldSoccer method, of class PhysicsTestHelper.
     */
    @Test
    public void testCreatePhysicsTestWorldSoccer() {
        System.out.println("createPhysicsTestWorldSoccer");
        Node rootNode = null;
        AssetManager assetManager = null;
        PhysicsSpace space = null;
        PhysicsTestHelper.createPhysicsTestWorldSoccer(rootNode, assetManager, space);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPhysicsTestBox method, of class PhysicsTestHelper.
     */
    @Test
    public void testCreatePhysicsTestBox() {
        System.out.println("createPhysicsTestBox");
        AssetManager assetManager = null;
        Geometry expResult = null;
        Geometry result = PhysicsTestHelper.createPhysicsTestBox(assetManager);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPhysicsTestSphere method, of class PhysicsTestHelper.
     */
    @Test
    public void testCreatePhysicsTestSphere() {
        System.out.println("createPhysicsTestSphere");
        AssetManager assetManager = null;
        Geometry expResult = null;
        Geometry result = PhysicsTestHelper.createPhysicsTestSphere(assetManager);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPhysicsTestNode method, of class PhysicsTestHelper.
     */
    @Test
    public void testCreatePhysicsTestNode() {
        System.out.println("createPhysicsTestNode");
        AssetManager manager = null;
        CollisionShape shape = null;
        float mass = 0.0F;
        Node expResult = null;
        Node result = PhysicsTestHelper.createPhysicsTestNode(manager, shape, mass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createBallShooter method, of class PhysicsTestHelper.
     */
    @Test
    public void testCreateBallShooter() {
        System.out.println("createBallShooter");
        Application app = null;
        Node rootNode = null;
        PhysicsSpace space = null;
        PhysicsTestHelper.createBallShooter(app, rootNode, space);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createGImpactTestFloor method, of class PhysicsTestHelper.
     */
    @Test
    public void testCreateGImpactTestFloor() {
        System.out.println("createGImpactTestFloor");
        AssetManager assetManager = null;
        float floorDimensions = 0.0F;
        Vector3f position = null;
        Geometry expResult = null;
        Geometry result = PhysicsTestHelper.createGImpactTestFloor(assetManager, floorDimensions, position);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMeshTestFloor method, of class PhysicsTestHelper.
     */
    @Test
    public void testCreateMeshTestFloor() {
        System.out.println("createMeshTestFloor");
        AssetManager assetManager = null;
        float floorDimensions = 0.0F;
        Vector3f position = null;
        Geometry expResult = null;
        Geometry result = PhysicsTestHelper.createMeshTestFloor(assetManager, floorDimensions, position);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void checkIfGetYIsCorrect() {
        float testVariable = PhysicsTestHelper.getY(10, 10, 5);
        assertTrue(-2.0f == testVariable);
    }
}
