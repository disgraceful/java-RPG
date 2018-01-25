package rpg.core.utils.slick;

import de.matthiasmann.twl.GUI;
import de.matthiasmann.twl.Widget;
import de.matthiasmann.twl.renderer.Renderer;
import de.matthiasmann.twl.renderer.lwjgl.LWJGLRenderer;
import de.matthiasmann.twl.theme.ThemeManager;
import java.io.IOException;
import java.net.URL;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.Transition;

/**
 * A StateBaseGame subclass with support for a TWL Ui per state.
 * 
 * @author Matthias Mann
 */
public abstract class TWLStateBasedGame extends StateBasedGame {

    private final Widget emptyRootWidget;
    
    private GUI gui;
    private boolean guiInitialized;

    protected TWLStateBasedGame(String name) {
        super(name);

        emptyRootWidget = new Widget();
        emptyRootWidget.setTheme("");
    }

    /**
     * Adds a new game state
     * @param state the game state
     * @see StateBasedGame#addState(org.newdawn.slick.state.GameState) 
     */
    public void addState(BasicTWLGameState state) {
        super.addState(state);
    }

    /**
     * Adds a new game state.
     *
     * This method is overriden to ensure that only instances of BasicTWLGameState are added.
     * 
     * @param state the game state. Must be an instance of BasicTWLGameState
     * @see StateBasedGame#addState(org.newdawn.slick.state.GameState) 
     */
    @Override
    public void addState(GameState state) {
        if(!(state instanceof BasicTWLGameState)) {
            throw new IllegalArgumentException("state must be a BasicTWLGameState");
        }
        super.addState(state);
    }

    /**
     * Implement this method and return the URL for the TWL theme.
     * 
     * @return the URL for the TWL theme. Must not be null.
     */
    protected abstract URL getThemeURL();

    /**
     * Transits to a the specified game state.
     * This method hides the UI of the current state before starting the transition.
     *
     * @param id The ID of the state to enter
     * @param leave The transition to use when leaving the current state
     * @param enter The transition to use when entering the new state
     * @see StateBasedGame#enterState(int, org.newdawn.slick.state.transition.Transition, org.newdawn.slick.state.transition.Transition)
     */
    @Override
    public void enterState(int id, Transition leave, Transition enter) {
        if(gui != null) {
            gui.setRootPane(emptyRootWidget);
        }
        super.enterState(id, leave, enter);
    }

    protected ThemeManager loadTheme(Renderer renderer) throws IOException {
        URL url = getThemeURL();
        assert url != null;
        return ThemeManager.createThemeManager(url, renderer);
    }

    protected void setRootPane(RootPane rootPane) throws SlickException {
        if(!guiInitialized) {
            guiInitialized = true;
            initGUI();
        }
        if(gui != null) {
            gui.setRootPane(rootPane);
        }
    }

    protected void initGUI() throws SlickException {
        GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
        try {
            Renderer renderer = new LWJGLRenderer();
            ThemeManager theme = loadTheme(renderer);

            gui = new GUI(emptyRootWidget, renderer, null);
            gui.applyTheme(theme);

            Input input = getContainer().getInput();
            TWLInputForwarder inputForwarder = new TWLInputForwarder(gui, input);
            input.addPrimaryListener(inputForwarder);
        } catch (Throwable e) {
            throw new SlickException("Could not initialize TWL GUI", e);
        } finally {
            GL11.glPopAttrib();
        }
    }

    @Override
    protected void postRenderState(GameContainer container, Graphics g) throws SlickException {
        if(gui != null) {
            gui.draw();
        }
    }

    @Override
    protected void postUpdateState(GameContainer container, int delta) throws SlickException {
        if(gui != null) {
            gui.setSize();
            gui.handleTooltips();
            gui.updateTimers();
            gui.invokeRunables();
            gui.validateLayout();
            gui.setCursor();
        }
    }
}
