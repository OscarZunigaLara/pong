package mx.itesm.ozl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

class PantallaJUego implements Screen {

    private final Pong pong;

    public static final float ANCHO = 1200;
    public static  final float ALTO = 800;


    private OrthographicCamera camara;
    private Viewport vista;



    private SpriteBatch batch;

    //TEXTURAS


    private Texture texturaBarraHorizontal;
    private Texture texturaRaqueta;
    private Texture texturaCuadro;



    public PantallaJUego(Pong pong) {


        this.pong = pong;
    }




    ///////el que muestra toda la wea cosmica

    @Override
    public void show() {

        camara = new OrthographicCamera(ANCHO,ALTO);
        camara.position.set(ANCHO/2, ALTO/2, 0);
        camara.update();


        vista = new StretchViewport(ANCHO, ALTO,camara);

        batch = new SpriteBatch();

        cargarTexuras();
    }

    private void cargarTexuras() {
        texturaBarraHorizontal = new Texture( "barraHorizontal.png");
        texturaRaqueta = new Texture("raqueta.png");
        texturaCuadro = new Texture("cuadrito.png");

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        batch.setProjectionMatrix(camara.combined);

        batch.begin();

        /////TODOS LOS ELEMENTOS



        batch.draw(texturaBarraHorizontal,0,0);
        batch.draw(texturaBarraHorizontal, 0, ALTO - texturaBarraHorizontal.getHeight());


        for (float y = 0; y<ALTO; y+=2 * texturaCuadro.getHeight() ){
            batch.draw(texturaCuadro, ANCHO/2,y );
        }



        batch.draw(texturaRaqueta, 0, ALTO/2);
        batch.draw(texturaRaqueta, ANCHO-texturaRaqueta.getWidth(), ALTO/2);


        ////
        batch.end();
    }


    @Override
    public void resize(int width, int height) {

        vista.update(width,height);

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
