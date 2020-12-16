package com.test.testfactory.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.test.testfactory.TestFactory;
import com.test.testfactory.scenes.Hud;
import com.test.testfactory.sprites.Cupcake;

public class PlayScreen implements Screen {
    private TestFactory game;
    Texture peach;
    Texture background;
    private TextureAtlas atlas;
    private OrthographicCamera cam;
    private Viewport port;
    private Hud hud;

    private Cupcake cupcake;

    /*private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;*/

    //box2d
    private World world;
    private Box2DDebugRenderer b2dr;

    public PlayScreen(TestFactory game){
        atlas = new TextureAtlas("Cupcake2.pack");
        this.game = game;
        peach = new Texture("peach.png");
        background = new Texture("kitchen.jpg");

        cam = new OrthographicCamera();
      /*  port = new FillViewport(TestFactory.V_WIDTH, TestFactory.V_HEIGHT, cam);
        port = new ScreenViewport(cam);*/
        port = new FitViewport(TestFactory.V_WIDTH, TestFactory.V_HEIGHT, cam);
        hud = new Hud(game.batch);

       /* mapLoader = new TmxMapLoader();
        map = mapLoader.load("filename");
        renderer = new OrthogonalTiledMapRenderer(map);
        cam.position.set(port.getWorldWidth() / 2, port.getWorldHeight() / 2, 0);*/

        //för box2d-fysik, gravitation etc. OBS!!! för mer info, se part7
        world = new World(new Vector2(0, 0), true);
        b2dr = new Box2DDebugRenderer();

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        cupcake = new Cupcake(world, this);

    }

    public TextureAtlas getAtlas(){
        return atlas;
    }

    @Override
    public void show() {

    }
    //finns för update
    public void handleInput(float dt){
        if(Gdx.input.justTouched()) {
            //    cupcake.b2body.applyLinearImpulse(new Vector2(0, 4f), cupcake.b2body.getWorldCenter(),true);
           // cupcake.getFrame();
            Gdx.app.log("input", "touched");
           // cupcake.update(dt);
        }

    }
    //för att hantera maps
    public void update(float dt){
        handleInput(dt);
        //för kollision?
       // world.step(1/60f, 6, 2);

        cupcake.update(dt);

        cam.update();
        /*renderer.setView(cam);*/
    }

    @Override
    public void render(float delta) {
        //update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

       // game.batch.setProjectionMatrix(cam.combined);
        game.batch.begin();
        game.batch.draw(background, 0, 0);
        game.batch.draw(peach, 462 - peach.getWidth(), 0);
        cupcake.draw(game.batch);
        game.batch.end();

       // renderer.render();


        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();


    }

    @Override
    public void resize(int width, int height) {
        port.update(width, height);
     //   cam.position.set(TestFactory.V_WIDTH / 2, TestFactory.V_HEIGHT / 2, 0);


    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
