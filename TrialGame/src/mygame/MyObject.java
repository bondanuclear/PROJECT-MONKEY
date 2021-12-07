/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;

import com.jme3.bullet.collision.shapes.CollisionShape;

import com.jme3.bullet.control.RigidBodyControl;

import com.jme3.scene.Node;

/**
 *
 * @author lanbo
 */
public class MyObject {
    private CollisionShape shape;
    private float mass = 0;
    AssetManager manager;
    public MyObject(AssetManager manager, CollisionShape shape, float mass) {
        this.manager = manager;
        this.mass = mass;
        this.shape = shape;
    }
     /**
     * creates an empty node with a RigidBodyControl
     *   
     * @return new physical node
     */
    public Node createNode() {
        Node node = new Node("PhysicsNode");
        RigidBodyControl control = new RigidBodyControl(shape, mass);
        node.addControl(control);
        return node;
    }
}
