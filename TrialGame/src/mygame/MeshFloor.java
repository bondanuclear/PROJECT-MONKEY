/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.collision.shapes.MeshCollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer;
import com.jme3.util.BufferUtils;

/**
 *
 * @author lanbo
 */
public class MeshFloor {
   private AssetManager assetManager;
   private float floorDimensions;
   private Vector3f position;
    public MeshFloor(AssetManager assetManager,float floorDimensions,Vector3f position) {
     this.assetManager = assetManager;
     this.floorDimensions = floorDimensions;
     this.position = position;
    }
     /**
     * Creates a curved "floor" with a MeshCollisionShape provided as the RigidBodyControl's collision shape.
     * Surface has four slightly concave corners to allow for multiple tests and minimize falling off the edge
     * of the floor.
     *
     * @param assetManager for loading assets
     * @param floorDimensions width/depth of the "floor" (X/Z)
     * @param position sets the floor's local translation
     * @return a new Geometry
     */
    public Geometry createMeshTestFloor() {
        Geometry floor = createTestFloor(assetManager, floorDimensions, position, new ColorRGBA(0.5f, 0.5f, 0.9f, 1));
        RigidBodyControl floorControl = new RigidBodyControl(new MeshCollisionShape(floor.getMesh()), 0);
        floor.addControl(floorControl);
        return floor;
    }

    private  Geometry createTestFloor(AssetManager assetManager, float floorDimensions, Vector3f position, ColorRGBA color) {
        Geometry floor = new Geometry("floor", createFloorMesh(20, floorDimensions));
        Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.getAdditionalRenderState().setWireframe(true);
        material.setColor("Color", color);
        floor.setMaterial(material);
        floor.setLocalTranslation(position);
        return floor;
    }
    private  Mesh createFloorMesh(int meshDetail, float floorDimensions) {
        if (meshDetail < 10) {
            meshDetail = 10;
        }
        int numVertices = meshDetail * meshDetail * 2 * 3;//width * depth * two tris * 3 verts per tri

        int[] indexBuf = new int[numVertices];
        int i = 0;
        for (int x = 0; x < meshDetail; x++) {
            for (int z = 0; z < meshDetail; z++) {
                indexBuf[i] = i++;
                indexBuf[i] = i++;
                indexBuf[i] = i++;
                indexBuf[i] = i++;
                indexBuf[i] = i++;
                indexBuf[i] = i++;
            }
        }

        float[] vertBuf = new float[numVertices * 3];
        float xIncrement = floorDimensions / meshDetail;
        float zIncrement = floorDimensions / meshDetail;
        int j = 0;
        for (int x = 0; x < meshDetail; x++) {
            float xPos = x * xIncrement;
            for (int z = 0; z < meshDetail; z++) {
                float zPos = z * zIncrement;
                //First tri
                vertBuf[j++] = xPos;
                vertBuf[j++] = getY(xPos, zPos, floorDimensions);
                vertBuf[j++] = zPos;
                vertBuf[j++] = xPos;
                vertBuf[j++] = getY(xPos, zPos + zIncrement, floorDimensions);
                vertBuf[j++] = zPos + zIncrement;
                vertBuf[j++] = xPos + xIncrement;
                vertBuf[j++] = getY(xPos + xIncrement, zPos, floorDimensions);
                vertBuf[j++] = zPos;
                //Second tri
                vertBuf[j++] = xPos;
                vertBuf[j++] = getY(xPos, zPos + zIncrement, floorDimensions);
                vertBuf[j++] = zPos + zIncrement;
                vertBuf[j++] = xPos + xIncrement;
                vertBuf[j++] = getY(xPos + xIncrement, zPos + zIncrement, floorDimensions);
                vertBuf[j++] = zPos + zIncrement;
                vertBuf[j++] = xPos + xIncrement;
                vertBuf[j++] = getY(xPos + xIncrement, zPos, floorDimensions);
                vertBuf[j++] = zPos;
            }
        }

        Mesh m = new Mesh();
        m.setBuffer(VertexBuffer.Type.Index, 1, BufferUtils.createIntBuffer(indexBuf));
        m.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(vertBuf));
        m.updateBound();
        return m;
    }

    public  float getY(float x, float z, float max) {
        float yMaxHeight = 8;
        float xv = FastMath.unInterpolateLinear(FastMath.abs(x - (max / 2)), 0, max) * FastMath.TWO_PI;
        float zv = FastMath.unInterpolateLinear(FastMath.abs(z - (max / 2)), 0, max) * FastMath.TWO_PI;

        float xComp = (FastMath.sin(xv) + 1) * 0.5f;
        float zComp = (FastMath.sin(zv) + 1) * 0.5f;

        return -yMaxHeight * xComp * zComp;
    }
}
