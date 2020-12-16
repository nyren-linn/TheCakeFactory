package com.test.testfactory.sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.test.testfactory.screens.PlayScreen;

public class Cupcake extends Sprite {
    public enum State{START, FROSTING, TOPPING};
    public State currentState;
    public State previousState;
    public World world;
    public Body b2body;
    private TextureRegion cupcakeStart, t1, t2;
    private Animation cakeDecoration;
    private float stateTimer;

    public Cupcake(World world, PlayScreen screen){
        super(screen.getAtlas().findRegion("c1"));
        this.world = world;
        currentState = State.START;
        previousState = State.START;
        stateTimer = 0;

        Array<TextureRegion> frames = new Array<TextureRegion>();
        t1 = new TextureRegion(getTexture(), 1, 1, 300, 300);
        t2 = new TextureRegion(getTexture(), 303, 1, 300, 300);

        cupcakeStart = new TextureRegion(getTexture(), 605, 1, 300, 300);

        defineCupcake();
        setBounds(50, 0, 250, 250);
        setRegion(cupcakeStart);
    }

    public void update(float dt){
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
        setRegion(getFrame());
    }

    public State getState(){
        return currentState;
    }

    public TextureRegion getFrame(){
        if(currentState == State.START){
            currentState = State.FROSTING;
            cupcakeStart = t1;
            return cupcakeStart;
        } else if(currentState == State.FROSTING){
            currentState = State.TOPPING;
            cupcakeStart = t2;
            return cupcakeStart;
        }
        return cupcakeStart;
    }

    public void defineCupcake(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(32, 32);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(10);

        fdef.shape = shape;
        b2body.createFixture(fdef);
    }
}
