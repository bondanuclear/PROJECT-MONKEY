/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.levels;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.app.state.AppState;
import com.jme3.bounding.BoundingBox;
import com.jme3.bounding.BoundingSphere;
import com.jme3.bounding.BoundingVolume;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.input.ChaseCamera;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.renderer.Camera;
/**
 *
 * @author lanbo
 */
public class Level1 extends AbstractAppState {
    private final Node rootNode;
    private final Node localRootNode = new Node("Level 1");
    private final AssetManager assetManager;
    private BulletAppState bulletAppState;
    private Spatial player;
    private CharacterControl playerControl;
    private final FlyByCamera flyByCamera;
    private final Camera camera;
    private final InputManager inputManager;
    public Level1(SimpleApplication app) {
        rootNode = app.getRootNode();
        assetManager = app.getAssetManager();
        inputManager = app.getInputManager();
        flyByCamera = app.getFlyByCamera();
        camera = app.getCamera();
    }
    
   
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        bulletAppState = new BulletAppState();
        bulletAppState.setDebugEnabled(true);
        stateManager.attach(bulletAppState);
        rootNode.attachChild(localRootNode);
        Spatial scene = assetManager.loadModel("Scenes/newScene.j3o");
        localRootNode.attachChild(scene);
//        Spatial floor = localRootNode.getChild("Floor");
//        bulletAppState.getPhysicsSpace().add(floor.getControl(RigidBodyControl.class));
//        player = localRootNode.getChild("Player");
//        BoundingBox boundingBox = (BoundingBox) player.getWorldBound();
//        float radius = boundingBox.getXExtent(); 
//        float height = boundingBox.getYExtent();
//        CapsuleCollisionShape playerShape = new CapsuleCollisionShape(radius,height);
//        playerControl = new CharacterControl(playerShape, 1.0f);
//        player.addControl(playerControl);
//        bulletAppState.getPhysicsSpace().add(playerControl);
          //flyByCamera.setEnabled(false);
        //ChaseCamera chaseCam = new ChaseCamera(camera,player,inputManager);
    }   
    
    @Override
    public void cleanup(){
        rootNode.detachChild(localRootNode);
        super.cleanup();
    }
}
