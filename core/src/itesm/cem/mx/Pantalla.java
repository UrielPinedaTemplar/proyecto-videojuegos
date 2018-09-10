package itesm.cem.mx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class Pantalla implements Screen {
    public static final float ANCHO=1280;
    public static final float ALTO=720;
    protected OrthographicCamera camara;
    protected Viewport vista;
    protected Animation animation;
    protected float tiempo = 0;
    protected SpriteBatch spriteBatch;
    private TextureRegion D1;
    private TextureRegion D2;
    private TextureRegion D3;
    private TextureRegion D4;
    private TextureRegion D5;



    protected SpriteBatch batch;
    public Pantalla(){
        camara = new OrthographicCamera(ANCHO, ALTO);
        camara.position.set(ANCHO/2,ALTO/2,0);
        camara.update();
        vista=new StretchViewport(ANCHO, ALTO,camara);
        batch= new SpriteBatch();
    }
    protected void borrarPantalla(){

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
    protected void borrarPantalla(float r, float g, float b) {

        //D1= new TextureRegion(new Texture("Teeth01.png"));
        //D2= new TextureRegion(new Texture("Teeth02.png"));
        //D3= new TextureRegion(new Texture("Teeth03.png"));
        //D4= new TextureRegion(new Texture("Teeth04.png"));
        //D5= new TextureRegion(new Texture("Teeth05.png"));
       // animation = new Animation(0.5f,D1,D2,D3,D4,D5);

        //batch.begin();
        //sprite.draw(batch);
        //tiempo += Gdx.graphics.getDeltaTime();
       // batch.draw(animation.getKeyFrame(tiempo, true), 0, 0);
        //batch.end();

        Gdx.gl.glClearColor(r,g,b,1);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {
        vista.update(width,height);
    }

    @Override
    public void hide() {
        dispose();

    }
}
