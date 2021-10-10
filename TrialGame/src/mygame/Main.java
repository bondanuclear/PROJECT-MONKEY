package mygame;


import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;


import com.jme3.bullet.collision.shapes.CylinderCollisionShape;


import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.collision.shapes.PlaneCollisionShape;

import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.input.KeyInput;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.math.Plane;
import com.jme3.scene.Mesh;
import com.jme3.scene.shape.Box;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    private BulletAppState bulletAppState;
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        initKeys();
        initLight();
        //stateManager.attach(new Level1(this));
        
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        bulletAppState.getPhysicsSpace().setGravity(new Vector3f(0, -9.81f, 0));
       bulletAppState.getPhysicsSpace().setAccuracy(1f/80f);
        bulletAppState.setDebugEnabled(true);
       
        //Node physicsCylinder = setPhysicsCylinder(1f,1f,1f);
        //setPlane();
        set3dFloor();
        // 1f -3.5f 20f
        // cam.lookAt(physicsCylinder.getWorldTranslation(),new Vector3f(0f,0f, 0f));
        flyCam.setMoveSpeed(10);
        //flyCam.setEnabled(false);
        //ChaseCamera chaseCam = new ChaseCamera(cam, physicsCylinder, inputManager);
     
        
    }
/**
 * 
 * @param x - set coords on x axis
 * @param y - set coords on y axis
 * @param z - set coords on z axis
 * @return Node(Cylinder)
 * @see PhysicsTestHelper class
 */
    public Node setPhysicsCylinder(float x, float y, float z) {
        
        Node physicsCylinder = PhysicsTestHelper.createPhysicsTestNode(assetManager, new CylinderCollisionShape(new Vector3f(1f, 1f, 1.5f)), 5);
        physicsCylinder.getControl(RigidBodyControl.class).setPhysicsLocation(new Vector3f(x,y,z));
        rootNode.attachChild(physicsCylinder);
        getPhysicsSpace().add(physicsCylinder);
        return physicsCylinder;
    }
/**
 * Method which creates plane. 
 * @see PhysicsTestHelper class
 */
    public void setPlane() {
        Node node3 = PhysicsTestHelper.createPhysicsTestNode(assetManager, new PlaneCollisionShape(new Plane(new Vector3f(0, 1, 0), 0)), 0);
        node3.getControl(RigidBodyControl.class).setPhysicsLocation(new Vector3f(0f, -2, 0f));
        node3.rotate(1f, 0, 0);
        rootNode.attachChild(node3);
        getPhysicsSpace().add(node3);
    }
/**
 * Method which creates 3D mesh floor. 
 * Currently used to test the physics of cylinder rolling down an inlclined plane.
 * @see PhysicsTestHelper class
 */
    public void set3dFloor() {
       
        Geometry testFloor = PhysicsTestHelper.createMeshTestFloor(assetManager, 40f, Vector3f.UNIT_X);
        testFloor.getControl(RigidBodyControl.class).setPhysicsLocation(new Vector3f(-2f,-2,-2f));
        
        rootNode.attachChild(testFloor);
        //testFloor.rotate(FastMath.PI / 4, 0, 0);
        getPhysicsSpace().add(testFloor);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    /**
     * Method which initializes light
     * @deprecated 
     */
    private void initLight() {
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(1.1f, 1f, 1.1f));
        rootNode.addLight(sun);
        rootNode.addLight(new AmbientLight());
    }
    /**
     * Method which initializes keys to spawn cylinders
     */
    private void initKeys() {
        inputManager.addMapping("Cylinder1", new KeyTrigger(KeyInput.KEY_1)); 
        inputManager.addMapping("Cylinder2", new KeyTrigger(KeyInput.KEY_2)); 
        inputManager.addMapping("Cylinder3", new KeyTrigger(KeyInput.KEY_3)); 
        inputManager.addMapping("Cylinder4", new KeyTrigger(KeyInput.KEY_4)); 

        
        
        inputManager.addListener(actionListener, "Cylinder1");
        inputManager.addListener(actionListener, "Cylinder2");
        inputManager.addListener(actionListener, "Cylinder3");
        inputManager.addListener(actionListener, "Cylinder4");
    }
    private Boolean isCylinderUsed = false;
    private final ActionListener actionListener = new ActionListener() {
        /**
         * Method which spawns cylinders when clicking on certain keys
         */
        @Override
        public void onAction(String name, boolean keyPressed, float tpf) {
            
                if(name.equals("Cylinder1") && !keyPressed && (isCylinderUsed == false)) {
                    Node physicsCylinder1 = setPhysicsCylinder(1f,0.5f,1f);
                    System.out.println("Works1!");
                    //isCylinderUsed = true;
                } else if (name.equals("Cylinder2") && !keyPressed && (isCylinderUsed == false)) {
                    Node physicsCylinder2 = setPhysicsCylinder(10f,-8f,26f);
                    System.out.println("Works2!");
                    //isCylinderUsed = true;
                } else if (name.equals("Cylinder3") && !keyPressed && (isCylinderUsed == false)) {
                    Node physicsCylinder3 = setPhysicsCylinder(20f,1f,18f);
                    System.out.println("Works3!");
                   // isCylinderUsed = true;
                } else if (name.equals("Cylinder4") && !keyPressed && (isCylinderUsed == false)) {
                    Node physicsCylinder4 = setPhysicsCylinder(20f,30f,20f);
                    System.out.println("Works4!");
                   // isCylinderUsed = true;
                }
        }
        
        
    };
    /**
     * Method which returns physics space, built on jBullet Physics
     * @return Physics space
     */
    private PhysicsSpace getPhysicsSpace() {
        return bulletAppState.getPhysicsSpace();
    }
    
    
}
