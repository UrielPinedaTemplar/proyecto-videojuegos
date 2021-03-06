package itesm.cem.mx;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

class PantallaMenu extends Pantalla {
    private final PantallaInicio pantallaInicio;
    private Stage escenaMenu;
    private Texture textFondo;
    private Texture title;
    private TextureRegion D1;
    private TextureRegion D2;
    private TextureRegion D3;
    private TextureRegion D4;
    private TextureRegion D5;
    private Animation player;
    private float stateTime;
    private SpriteBatch spriteBatch;
    private TextureRegion currentFrame;

    public PantallaMenu(PantallaInicio pantallaInicio) {
        this.pantallaInicio=pantallaInicio;
    }

    @Override
    public void show() {
        crearEscena();
        Gdx.input.setInputProcessor(escenaMenu);
    }

    private void crearEscena() {
        escenaMenu=new Stage(vista);
        textFondo = new Texture("MainScreen.png");
        title = new Texture("TituloMaybe.png");

// Botones
        Texture textBtnPlay=new Texture("BtnJugarBasico01.png");
        Texture BtnOpciones = new Texture("OpcionesBtn01.png");
        Texture BtnExtras = new Texture("ExtrasBtn01.png");
        //declarar regiones
        TextureRegionDrawable top= new TextureRegionDrawable(new TextureRegion(BtnOpciones));
        TextureRegionDrawable trd = new TextureRegionDrawable(new TextureRegion(textBtnPlay));
        TextureRegionDrawable tex = new TextureRegionDrawable(new TextureRegion(BtnExtras));
        //boton oprimido
        Texture textBtnPlayOprimido = new Texture("BtnJugarBasico02HOVER.png");
        Texture textBtnOpcionesOp = new Texture("OpcionesBtn02HOVER.png");
        Texture textBtnExtrasOp = new Texture("ExtrasBtn02HOVER.png");
        ///region Boton Oprimido
        TextureRegionDrawable trdOp = new TextureRegionDrawable(new TextureRegion(textBtnPlayOprimido));
        TextureRegionDrawable tropr = new TextureRegionDrawable(new TextureRegion(textBtnOpcionesOp));
        TextureRegionDrawable  trexop = new TextureRegionDrawable(new TextureRegion(textBtnExtrasOp));
        //creo boton
        ImageButton btnOp = new ImageButton(top,tropr);
        ImageButton btnPlay = new ImageButton(trd, trdOp);
        ImageButton btnEX = new ImageButton(tex,trexop);
        //Ubicar Botones
        btnPlay.setPosition(ANCHO/16,(ALTO/2)-(btnPlay.getHeight()/2));
        btnOp.setPosition(ANCHO-btnOp.getWidth(), ALTO/2+ btnOp.getHeight()/2);
        btnEX.setPosition(ANCHO-btnEX.getWidth(), ALTO/2-btnEX.getHeight());
        stateTime = 0f;

        //accion del boton
        btnPlay.addListener(new ClickListener() {
                                @Override
                                public void clicked(InputEvent event, float x, float y) {
                                    super.clicked(event, x, y);
                                    pantallaInicio.setScreen(new PantallaJuego(pantallaInicio));
                                }
                            }
        );
        ///metodo de dibujo para los botones
        escenaMenu.addActor(btnPlay);
        escenaMenu.addActor(btnOp);
        escenaMenu.addActor(btnEX);
        // Animacion dientes

    }

    @Override
    public void render(float delta) {
        borrarPantalla(0,0,0);
        batch.setProjectionMatrix(camara.combined); //escalar la pantalla y la vista correctamente al dicpositivo
        batch.begin();
        batch.draw(textFondo,0,0);
        batch.draw(title,(ANCHO/2)-title.getWidth()/2, ALTO-title.getHeight());
        batch.end();
        escenaMenu.draw();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
    }
}